package com.rickyli.event;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.ActionResult;

public class ModEvents {
    public static void init(){
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
        BlockState state = world.getBlockState(pos);
        /* 手动的旁观者检查是必要的，因为 AttackBlockCallbacks 会在旁观者检查之前应用 */
        if (state.isToolRequired() && !player.isSpectator() && player.getMainHandStack().isEmpty()) {
            player.damage(world.getDamageSources().generic(), 1.0f);
        }
        return ActionResult.PASS;
    });}

}
