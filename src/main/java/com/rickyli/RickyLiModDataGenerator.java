package com.rickyli;

import com.rickyli.datagen.*;
import com.rickyli.enchantment.ModEnchantmentEffects;
import com.rickyli.enchantment.ModEnchantments;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class RickyLiModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider(ModENUSLanProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelsProvider::new);
		pack.addProvider(ModRecipesProvider::new);
		pack.addProvider(ModItemTagsProvider::new);
		pack.addProvider(ModWorldGen::new);
	}
	@Override
	public void buildRegistry(RegistryBuilder registryBuilder){
		registryBuilder.addRegistry(RegistryKeys.ENCHANTMENT, ModEnchantments::bootstrap);
	}
}
