package com.rickyli.item.custom;

import com.google.common.collect.ImmutableMap;
import com.rickyli.RickyLiModArmorMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

import java.util.Map;

public class FlashpointItem extends ArmorItem {
    private static final Map<ArmorMaterial, StatusEffectInstance> map =
            new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>()
                    .put(RickyLiModArmorMaterials.FLASHPOINT.value(), new StatusEffectInstance(StatusEffects.SPEED,
                            20, 50, false, false, true)).build();

    public FlashpointItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient() && entity instanceof PlayerEntity player && !player.getInventory().getArmorStack(0).isEmpty()){
            evaluateArmorEffect(player);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffect(PlayerEntity player) {
        for(Map.Entry<ArmorMaterial, StatusEffectInstance> entry : map.entrySet()){
            ArmorMaterial material = entry.getKey();
            StatusEffectInstance effect = entry.getValue();
            ArmorItem boots = (ArmorItem) player.getInventory().getArmorStack(0).getItem();
            if(boots.getMaterial().value() == material){
                addStatusEffect(player, effect);
            }
        }
    }

    private void addStatusEffect(PlayerEntity player, StatusEffectInstance effect) {
        player.addStatusEffect(new StatusEffectInstance(effect));
    }
}
