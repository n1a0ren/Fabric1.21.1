package com.rickyli.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record DraculaEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<DraculaEnchantmentEffect> CODEC = MapCodec.unit(DraculaEnchantmentEffect::new);
    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if(user instanceof PlayerEntity player){
            player.heal(4);
        }
    }
    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
