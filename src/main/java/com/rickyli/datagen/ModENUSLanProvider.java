package com.rickyli.datagen;

import com.rickyli.block.ModBlocks;
import com.rickyli.item.ModItems;
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
        translationBuilder.add(ModItems.ruby, "Ruby");
        translationBuilder.add(ModItems.fairwood, "Fairwood");
        translationBuilder.add(ModItems.pressure, "pressure");
        translationBuilder.add(ModItems.prospector, "prospector");
        translationBuilder.add(ModItems.RUBY_SWORD, "Ruby Sword");
        translationBuilder.add(ModItems.RUBY_SHOVEL, "Ruby Shovel");
        translationBuilder.add(ModItems.RUBY_PICKAXE, "Ruby Pickaxe");
        translationBuilder.add(ModItems.RUBY_AXE, "Ruby Axe");
        translationBuilder.add(ModItems.RUBY_HOE, "Ruby Hoe");
        translationBuilder.add(ModItems.RUBY_HELMET, "Ruby Helmet");
        translationBuilder.add(ModItems.RUBY_CHESTPLATE, "Ruby Chestplate");
        translationBuilder.add(ModItems.RUBY_LEGGINGS, "Ruby Leggings");
        translationBuilder.add(ModItems.RUBY_BOOTS, "Ruby Boots");
        translationBuilder.add(ModItems.Big_Mouth_Bird, "Big Mouth Bird");
        translationBuilder.add(ModItems.Honey_Bucket, "Honey Bucket");

        translationBuilder.add(ModBlocks.rubyore, "Ruby Ore");
        translationBuilder.add(ModBlocks.rubyblock, "Ruby Block");
        translationBuilder.add(ModBlocks.deepslate_rubyore, "Deepslate Ruby Ore");
        translationBuilder.add(ModBlocks.HONEY_BLOCK, "Honey");

        translationBuilder.add("itemGroup.rickylimod", "RickyLi's Tab");
        translationBuilder.add("enchantment.rickylimod.thor", "Thor's Power");

        translationBuilder.add("item.rickylimod.prospector.tooltip", "Press \u00A76Shift\u00A7r for more information");
        translationBuilder.add("item.rickylimod.prospector.shift_tooltip", "Use it with holding shift to find the ores under target position");
        translationBuilder.add("item.rickylimod.prospector.unshift_tooltip", "You can use it to find the ores arounds you");
    }
}
