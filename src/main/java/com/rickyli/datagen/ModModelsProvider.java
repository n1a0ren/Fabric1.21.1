package com.rickyli.datagen;

import com.rickyli.ModBlocks.MBlocks;
import com.rickyli.ModItems.MItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(MBlocks.rubyblock);
        blockStateModelGenerator.registerSimpleCubeAll(MBlocks.rubyore);
        blockStateModelGenerator.registerSimpleCubeAll(MBlocks.deepslate_rubyore);
        blockStateModelGenerator.registerSimpleState(MBlocks.HONEY_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(MItems.ruby, Models.GENERATED);
        itemModelGenerator.register(MItems.fairwood, Models.GENERATED);
        itemModelGenerator.register(MItems.pressure, Models.GENERATED);
        itemModelGenerator.register(MItems.prospector, Models.GENERATED);
        itemModelGenerator.register(MItems.RUBY_HELMET, Models.GENERATED);
        itemModelGenerator.register(MItems.RUBY_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(MItems.RUBY_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(MItems.RUBY_BOOTS, Models.GENERATED);
        itemModelGenerator.register(MItems.Big_Mouth_Bird, Models.HANDHELD);
        itemModelGenerator.register(MItems.Honey_Bucket, Models.GENERATED);


        itemModelGenerator.register(MItems.RUBY_SWORD, Models.HANDHELD);
        itemModelGenerator.register(MItems.RUBY_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(MItems.RUBY_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(MItems.RUBY_AXE, Models.HANDHELD);
        itemModelGenerator.register(MItems.RUBY_HOE, Models.HANDHELD);
    }
}
