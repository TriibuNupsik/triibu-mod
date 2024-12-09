package me.triibu_mod;

import com.sun.net.httpserver.HttpServer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class WorldAPI implements ModInitializer {
    private static MinecraftServer minecraftServer;
    private static final int PORT = 8080;

    @Override
    public void onInitialize() {
        System.out.println("Starting WorldAPI...");
        startApiServer();
    }

    private void startApiServer() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);

            server.createContext("/world/block", exchange -> {
                String query = exchange.getRequestURI().getQuery();
                int x = 0,y=0, z = 0;

                if (query != null) {
                    for (String param : query.split("&")) {
                        String[] keyValue = param.split("=");
                        if (keyValue[0].equals("x")) x = Integer.parseInt(keyValue[1]);
                        if (keyValue[0].equals("y")) y = Integer.parseInt(keyValue[1]);
                        if (keyValue[0].equals("z")) z = Integer.parseInt(keyValue[1]);
                    }
                }

                String response = getBlockData(x, y, z);
                exchange.getResponseHeaders().add("Content-Type", "text/plain");
                exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            });

            server.createContext("/world/slab", exchange -> {
                String query = exchange.getRequestURI().getQuery();
                int xStart = 0, yStart = 0, zStart = 0, xEnd = 0, yEnd = 0, zEnd = 0;


                if (query != null) {
                    for (String param : query.split("&")) {
                        String[] keyValue = param.split("=");
                        if (keyValue[0].equals("xStart")) xStart = Integer.parseInt(keyValue[1]);
                        if (keyValue[0].equals("yStart")) yStart = Integer.parseInt(keyValue[1]);
                        if (keyValue[0].equals("zStart")) zStart = Integer.parseInt(keyValue[1]);
                        if (keyValue[0].equals("xEnd")) xEnd = Integer.parseInt(keyValue[1]);
                        if (keyValue[0].equals("yEnd")) yEnd = Integer.parseInt(keyValue[1]);
                        if (keyValue[0].equals("zEnd")) zEnd = Integer.parseInt(keyValue[1]);
                    }
                }

                String response = getSlabData(xStart, yStart, zStart, xEnd, yEnd, zEnd);
                exchange.getResponseHeaders().add("Content-Type", "text/plain");
                exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            });

            server.setExecutor(Executors.newCachedThreadPool());
            server.start();
            System.out.println("API server running on port " + PORT);
        } catch (Exception exception) {
            exception.printStackTrace();
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
                        default -> 0;
                    };

                    slabData.append(x);
                    slabData.append(",");
                    slabData.append(y);
                    slabData.append(",");
                    slabData.append(z);
                    slabData.append(",");
                    slabData.append(type);
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
