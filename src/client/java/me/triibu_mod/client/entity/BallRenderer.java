package me.triibu_mod.client.entity;

import me.triibu_mod.Triibu_mod;
import me.triibu_mod.entity.custom.BallEntity;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class BallRenderer extends EntityRenderer<BallEntity> {
    public static final Identifier TEXTUERE = new Identifier(Triibu_mod.MOD_ID, "textures/entity/ball.png");

    public BallRenderer(EntityRendererFactory.Context context) { super(context); }

    @Override
    public Identifier getTexture(BallEntity entity) {
        return TEXTUERE;
    }
}
