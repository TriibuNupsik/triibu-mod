package me.triibu_mod;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class WorldAPI {
    private static MinecraftServer minecraftServer;
    private static final int PORT = 8080;

    public void StartAPI() {
        System.out.println("Starting WorldAPI...");
        startApiServer();
    }

    private void startApiServer() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);

            server.createContext("/world/block", exchange -> {
                try {
                    var params = parseQueryParams(exchange.getRequestURI().getQuery());
                    int x = Integer.parseInt(params.getOrDefault("x", "0"));
                    int y = Integer.parseInt(params.getOrDefault("y", "0"));
                    int z = Integer.parseInt(params.getOrDefault("z", "0"));

                    String response = getBlockData(x, y, z);
                    sendResponse(exchange, 200, response);
                } catch (Exception e) {
                    sendResponse(exchange, 400, "{ \"error\": \"Invalid parameters\" }");
                }
            });

            server.createContext("/world/slab", exchange -> {
                try {
                    var params = parseQueryParams(exchange.getRequestURI().getQuery());
                    int xStart = Integer.parseInt(params.getOrDefault("xStart", "0"));
                    int yStart = Integer.parseInt(params.getOrDefault("yStart", "0"));
                    int zStart = Integer.parseInt(params.getOrDefault("zStart", "0"));
                    int xEnd = Integer.parseInt(params.getOrDefault("xEnd", "1"));
                    int yEnd = Integer.parseInt(params.getOrDefault("yEnd", "1"));
                    int zEnd = Integer.parseInt(params.getOrDefault("zEnd", "1"));

                    String response = getSlabData(xStart, yStart, zStart, xEnd, yEnd, zEnd);
                    sendResponse(exchange, 200, response);
                } catch (Exception e) {
                    sendResponse(exchange, 400, "{ \"error\": \"Invalid parameters\" }");
                }
            });


            server.setExecutor(Executors.newCachedThreadPool());
            server.start();
            System.out.println("API server running on port " + PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Map<String, String> parseQueryParams(String query) {
        if (query == null || query.isEmpty()) {
            return Collections.emptyMap();
        }

        return Arrays.stream(query.split("&"))
                .map(param -> param.split("="))
                .filter(keyValue -> keyValue.length == 2)
                .collect(Collectors.toMap(keyValue -> keyValue[0], keyValue -> keyValue[1]));
    }

    private void sendResponse(HttpExchange exchange, int statusCode, String response) throws IOException {
        exchange.getResponseHeaders().add("Content-Type", "text/plain");
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        exchange.sendResponseHeaders(statusCode, response.getBytes().length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }



    private String getSlabData(int xStart, int yStart, int zStart, int xEnd, int yEnd, int zEnd) {
        if (minecraftServer == null) return "{ \"error\": \"Server not initialized\" }";

        ServerWorld overworld = minecraftServer.getWorld(World.OVERWORLD);
        if (overworld == null) return "{ \"error\": \"Overworld not found\" }";

        StringBuilder slabData = new StringBuilder();

        for (int x = xStart; x<xEnd; x++)
            for (int y = yStart; y<yEnd; y++)
                for (int z = zStart; z<zEnd; z++) {
                    var blockState = overworld.getBlockState(new BlockPos(x, y, z));
                    var block = blockState.getBlock();
                    var id = Registries.BLOCK.getId(block).toString();

                    if (id.equals("minecraft:air") || id.equals("minecraft:void_air"))
                        continue;
                    int type = switch (id) {
                        case "minecraft:grass_block" -> 1;
                        case "minecraft:dirt" -> 2;
                        case "minecraft:stone" -> 3;
                        case "minecraft:deepslate" -> 4;
                        case "minecraft:andesite", "minecraft:tuff" -> 5;
                        case "minecraft:bedrock" -> 6;
                        case "minecraft:granite" -> 7;
                        case "minecraft:diorite" -> 8;
                        case "minecraft:water" -> 9;
                        default -> 0;
                    };

                    slabData.append(x);
                    slabData.append(",");
                    slabData.append(y);
                    slabData.append(",");
                    slabData.append(z);
                    slabData.append(",");
//                    slabData.append(type);
                    slabData.append(id);
                    slabData.append("\n");
                }

        return slabData.toString();
    }

    private String setBlockData(int x, int y, int z, String type) {
        if (minecraftServer == null) return "{ \"error\": \"Server not initialized\" }";

        ServerWorld overworld = minecraftServer.getWorld(World.OVERWORLD);
        if (overworld == null) return "{ \"error\": \"Overworld not found\" }";

        var pos = new BlockPos(x,y,z);

        var blockState = switch (type) {
            case "stone" -> Blocks.STONE.getDefaultState();
            case "dirt" -> Blocks.DIRT.getDefaultState();
            default -> Blocks.AIR.getDefaultState();
        };

        overworld.setBlockState(pos, blockState);

        return "OK";
    }

    private String getBlockData(int x, int y, int z) {
        if (minecraftServer == null) return "{ \"error\": \"Server not initialized\" }";

        ServerWorld overworld = minecraftServer.getWorld(World.OVERWORLD);
        if (overworld == null) return "{ \"error\": \"Overworld not found\" }";

        var block = overworld.getBlockState(new BlockPos(x,y,z));

        StringBuilder blockData = new StringBuilder();
        var block1 = block.getBlock();
        var id = Registries.BLOCK.getId(block1);
        blockData.append(id);

        //blockData.append(block.getBlock());

        return blockData.toString();
    }



    public static void setMinecraftServer(MinecraftServer server) {
        minecraftServer = server;
    }
}
