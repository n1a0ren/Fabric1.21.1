package com.rickyli.datagen;

import com.rickyli.ModBlocks.MBlocks;
import com.rickyli.ModItems.MItems;
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
        translationBuilder.add(MItems.ruby, "Ruby");
        translationBuilder.add(MItems.fairwood, "Fairwood");
        translationBuilder.add(MItems.pressure, "pressure");
        translationBuilder.add(MItems.prospector, "prospector");
        translationBuilder.add(MItems.RUBY_SWORD, "Ruby Sword");
        translationBuilder.add(MItems.RUBY_SHOVEL, "Ruby Shovel");
        translationBuilder.add(MItems.RUBY_PICKAXE, "Ruby Pickaxe");
        translationBuilder.add(MItems.RUBY_AXE, "Ruby Axe");
        translationBuilder.add(MItems.RUBY_HOE, "Ruby Hoe");
        translationBuilder.add(MItems.RUBY_HELMET, "Ruby Helmet");
        translationBuilder.add(MItems.RUBY_CHESTPLATE, "Ruby Chestplate");
        translationBuilder.add(MItems.RUBY_LEGGINGS, "Ruby Leggings");
        translationBuilder.add(MItems.RUBY_BOOTS, "Ruby Boots");
        translationBuilder.add(MItems.Big_Mouth_Bird, "Big Mouth Bird");
        translationBuilder.add(MItems.Honey_Bucket, "Honey Bucket");

        translationBuilder.add(MBlocks.rubyore, "Ruby Ore");
        translationBuilder.add(MBlocks.rubyblock, "Ruby Block");
        translationBuilder.add(MBlocks.deepslate_rubyore, "Deepslate Ruby Ore");
        translationBuilder.add(MBlocks.HONEY_BLOCK, "Honey");

        translationBuilder.add("itemGroup.rickylimod", "RickyLi's Tab");

        translationBuilder.add("item.rickylimod.prospector.tooltip", "Press \u00A76Shift\u00A7r for more information");
        translationBuilder.add("item.rickylimod.prospector.shift_tooltip", "Use it with holding shift to find the ores under target position");
        translationBuilder.add("item.rickylimod.prospector.unshift_tooltip", "You can use it to find the ores arounds you");
    }
}
