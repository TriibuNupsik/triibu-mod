package me.triibu_mod.entity.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.world.World;

public class BallEntity extends FireballEntity {
    public BallEntity(World world, LivingEntity owner, double velocityX, double velocityY, double velocityZ, int explosionPower) {
        super(world, owner, velocityX, velocityY, velocityZ, explosionPower);
    }
}
