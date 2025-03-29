package com.rickyli.item.custom;

import com.google.common.collect.ImmutableMap;
import com.rickyli.item.materials.RickyLiModArmorMaterials;
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

public class RubyArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, StatusEffectInstance> map =
            new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>()
                    .put(RickyLiModArmorMaterials.RUBY.value(), new StatusEffectInstance(StatusEffects.HEALTH_BOOST,
                            20, 4, false, false, true)).build();

    public RubyArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override //和tick有关的基本都是关于实时调用
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient() && entity instanceof PlayerEntity player && hasFullSuitOfArmor(player)){
            evaluateArmorEffect(player);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffect(PlayerEntity player) {
        for(Map.Entry<ArmorMaterial, StatusEffectInstance> entry : map.entrySet()){
           ArmorMaterial material = entry.getKey();
           StatusEffectInstance effects = entry.getValue();
           if (hasCorrectArmorSet(player, material)){
               addStatusEffect(player, effects);
           }
        }
    }

    private void addStatusEffect(PlayerEntity player, StatusEffectInstance effects){
            player.addStatusEffect(new StatusEffectInstance(effects));
    }

    private boolean hasCorrectArmorSet(PlayerEntity player, ArmorMaterial material) {
        for(ItemStack stack : player.getInventory().armor){
            if(!(stack.getItem() instanceof ArmorItem)){
                return false; //因为鞘翅没有ArmorMaterial, 如果不写这部分装备鞘翅则会直接崩溃
            }
        }

        ArmorItem helmet = (ArmorItem) player.getInventory().getArmorStack(3).getItem();
        ArmorItem chestplate = (ArmorItem) player.getInventory().getArmorStack(2).getItem();
        ArmorItem leggings = (ArmorItem) player.getInventory().getArmorStack(1).getItem();
        ArmorItem boots = (ArmorItem) player.getInventory().getArmorStack(0).getItem();

        return helmet.getMaterial().value() == material && chestplate.getMaterial().value() == material && leggings.getMaterial().value() == material && boots.getMaterial().value() == material;
    }

    private boolean hasFullSuitOfArmor(PlayerEntity player) {
        ItemStack helmet = player.getInventory().getArmorStack(3);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack boots = player.getInventory().getArmorStack(0);

        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

}
