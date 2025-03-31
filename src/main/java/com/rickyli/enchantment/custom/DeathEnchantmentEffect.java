package com.rickyli.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record DeathEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<DeathEnchantmentEffect> CODEC = MapCodec.unit(DeathEnchantmentEffect::new);
    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if(user.isAlive()){
            user.kill();
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
