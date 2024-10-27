package me.triibu_mod.entity;

import me.triibu_mod.Triibu_mod;
import me.triibu_mod.entity.custom.BallEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<BallEntity> BALL = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Triibu_mod.MOD_ID, "ball"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, BallEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f,0.5f)).build());

    public static void registerModEntities() {
        Triibu_mod.LOGGER.info("Registering Entities for " + Triibu_mod.MOD_ID);

    }
}
