package me.triibu_mod.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.world.World;

public class BallEntity extends FireballEntity {

    public BallEntity(EntityType<? extends FireballEntity> entityType, World world) {
        super(entityType, world);
    }
}
