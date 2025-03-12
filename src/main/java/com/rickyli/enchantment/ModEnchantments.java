package com.rickyli.enchantment;

import com.rickyli.RickyLiMod;
import com.rickyli.enchantment.custom.ThorEnchantmentEffect;
import net.minecraft.block.Block;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.item.Item;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    public static final RegistryKey<Enchantment> THOR = of("thor");
    public static void bootstrap(Registerable<Enchantment> registry){
        RegistryEntryLookup<DamageType> registryEntryLookup = registry.getRegistryLookup(RegistryKeys.DAMAGE_TYPE);
        RegistryEntryLookup<Enchantment> registryEntryLookup2 = registry.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        RegistryEntryLookup<Item> registryEntryLookup3 = registry.getRegistryLookup(RegistryKeys.ITEM);
        RegistryEntryLookup<Block> registryEntryLookup4 = registry.getRegistryLookup(RegistryKeys.BLOCK);
        register(registry, THOR, Enchantment.builder(Enchantment.definition(
                registryEntryLookup3.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                registryEntryLookup3.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                5,
                3,
                Enchantment.leveledCost(5,7),
                Enchantment.leveledCost(25,10),
                2,
                AttributeModifierSlot.MAINHAND))
                .exclusiveSet(registryEntryLookup2.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM, new ThorEnchantmentEffect()
                ));
    }
    private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.getValue()));
    }
    private static RegistryKey<Enchantment> of(String id) {
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(RickyLiMod.MOD_ID, id));
    }
}
