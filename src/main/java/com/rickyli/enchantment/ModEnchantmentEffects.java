package com.rickyli.enchantment;

import com.mojang.serialization.MapCodec;
import com.rickyli.RickyLiMod;
import com.rickyli.enchantment.custom.DraculaEnchantmentEffect;
import com.rickyli.enchantment.custom.ThorEnchantmentEffect;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {
    public static final MapCodec<? extends EnchantmentEntityEffect> THOR = register("thor", ThorEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> DRACULA = register("dracula", DraculaEnchantmentEffect.CODEC);
    private static MapCodec<? extends EnchantmentEntityEffect> register(String name, MapCodec<? extends EnchantmentEntityEffect> codec){
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(RickyLiMod.MOD_ID, name), codec);
    }
    public static void init(){}
}
