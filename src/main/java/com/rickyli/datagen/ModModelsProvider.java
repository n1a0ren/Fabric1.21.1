package com.rickyli.datagen;

import com.rickyli.block.ModBlocks;
import com.rickyli.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.rubyblock);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.rubyore);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.deepslate_rubyore);
        blockStateModelGenerator.registerSimpleState(ModBlocks.HONEY_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ruby, Models.GENERATED);
        itemModelGenerator.register(ModItems.fairwood, Models.GENERATED);
        itemModelGenerator.register(ModItems.pressure, Models.GENERATED);
        itemModelGenerator.register(ModItems.prospector, Models.GENERATED);
        itemModelGenerator.register(ModItems.Big_Mouth_Bird, Models.HANDHELD);
        itemModelGenerator.register(ModItems.Honey_Bucket, Models.GENERATED);


        itemModelGenerator.register(ModItems.RUBY_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.RUBY_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.RUBY_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.RUBY_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.RUBY_BOOTS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.FLASHPOINT);
    }
}
