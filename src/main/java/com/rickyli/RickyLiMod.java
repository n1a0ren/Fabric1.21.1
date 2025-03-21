package com.rickyli;

import com.rickyli.block.ModBlocks;
import com.rickyli.enchantment.ModEnchantmentEffects;
import com.rickyli.fluid.ModFluids;
import com.rickyli.item.ModItems;
import com.rickyli.tags.ModBlockTags;
import com.rickyli.tags.ModItemTags;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RickyLiMod implements ModInitializer {
	public static final String MOD_ID = "rickylimod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final RegistryKey<PlacedFeature> RUBY_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MOD_ID, "ore_ruby"));
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ModItems.init();
		ModBlocks.init();
		ModFluids.init();
		ModItemGroups.init();
		ModItemTags.init();
		ModBlockTags.init();
		ModEnchantmentEffects.init();

		FuelRegistry.INSTANCE.add(ModItems.pressure, 3600);

		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RUBY_ORE_PLACED_KEY);
	}
}