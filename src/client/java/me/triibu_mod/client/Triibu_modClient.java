package me.triibu_mod.client;

import me.triibu_mod.client.entity.BallModel;
import me.triibu_mod.client.entity.BallRenderer;
import me.triibu_mod.client.entity.ModModelLayers;
import me.triibu_mod.entity.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class Triibu_modClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.BALL, BallRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BALL, BallModel::getTexturedModelData);
    }
}