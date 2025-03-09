package com.rickyli.datagen;

import com.rickyli.ModBlocks.Blocks;
import com.rickyli.ModItems.Items;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;

import java.util.concurrent.CompletableFuture;

public class ModENUSLanProvider extends FabricLanguageProvider {
    public ModENUSLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(Items.ruby, "Ruby");
        translationBuilder.add(Items.fairwood, "Fairwood");
        translationBuilder.add(Items.pressure, "pressure");
        translationBuilder.add(Items.prospector, "prospector");
        translationBuilder.add(Items.RUBY_SWORD, "Ruby Sword");
        translationBuilder.add(Items.RUBY_SHOVEL, "Ruby Shovel");
        translationBuilder.add(Items.RUBY_PICKAXE, "Ruby Pickaxe");
        translationBuilder.add(Items.RUBY_AXE, "Ruby Axe");
        translationBuilder.add(Items.RUBY_HOE, "Ruby Hoe");
        translationBuilder.add(Items.RUBY_HELMET, "Ruby Helmet");
        translationBuilder.add(Items.RUBY_CHESTPLATE, "Ruby Chestplate");
        translationBuilder.add(Items.RUBY_LEGGINGS, "Ruby Leggings");
        translationBuilder.add(Items.RUBY_BOOTS, "Ruby Boots");
        translationBuilder.add(Items.Big_Mouth_Bird, "Big Mouth Bird");

        translationBuilder.add(Blocks.rubyore, "Ruby Ore");
        translationBuilder.add(Blocks.rubyblock, "Ruby Block");

        translationBuilder.add("itemGroup.rickylimod", "RickyLi's Tab");

        translationBuilder.add("item.rickylimod.prospector.tooltip", "Press \u00A76Shift\u00A7r for more information");
        translationBuilder.add("item.rickylimod.prospector.shift_tooltip", "Use it with holding shift to find the ores under target position");
        translationBuilder.add("item.rickylimod.prospector.unshift_tooltip", "You can use it to find the ores arounds you");
    }
}
