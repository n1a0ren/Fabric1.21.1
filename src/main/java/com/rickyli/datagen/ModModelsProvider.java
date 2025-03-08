package com.rickyli.datagen;

import com.rickyli.ModBlocks.Blocks;
import com.rickyli.ModItems.Items;
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
        blockStateModelGenerator.registerSimpleCubeAll(Blocks.rubyblock);
        blockStateModelGenerator.registerSimpleCubeAll(Blocks.rubyore);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(Items.ruby, Models.GENERATED);
        itemModelGenerator.register(Items.fairwood, Models.GENERATED);
    }
}
