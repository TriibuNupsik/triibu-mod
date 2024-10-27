package me.triibu_mod.client.entity;

import me.triibu_mod.Triibu_mod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer BALL =
            new EntityModelLayer(new Identifier(Triibu_mod.MOD_ID,"ball"),"main");
}
