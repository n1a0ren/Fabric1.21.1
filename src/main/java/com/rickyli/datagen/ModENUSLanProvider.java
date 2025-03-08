package com.rickyli.datagen;

import com.rickyli.ModBlocks.Blocks;
import com.rickyli.ModItems.Items;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModENUSLanProvider extends FabricLanguageProvider {
    public ModENUSLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(Items.ruby, "Ruby");
        translationBuilder.add(Items.fairwood, "Fairwood");

        translationBuilder.add(Blocks.rubyore, "Ruby Ore");
        translationBuilder.add(Blocks.rubyblock, "Ruby Block");

        translationBuilder.add("itemGroup.rickylimod", "RickyLi's Tab");
    }
}
