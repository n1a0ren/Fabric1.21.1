package com.rickyli.datagen;

import com.rickyli.block.ModBlocks;
import com.rickyli.item.ModItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.Attachment;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Items;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

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

        blockStateModelGenerator.registerCrop(ModBlocks.FAIRWOOD, Properties.AGE_4, 0,1,2,3,4);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ruby, Models.GENERATED);
        itemModelGenerator.register(ModItems.pressure, Models.GENERATED);
        itemModelGenerator.register(ModItems.prospector, Models.GENERATED);
        itemModelGenerator.register(ModItems.Big_Mouth_Bird, Models.HANDHELD);
        itemModelGenerator.register(ModItems.Honey_Bucket, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLASHPOINT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CURRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.TESTSMELT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_STAFF, Models.GENERATED);
        itemModelGenerator.register(ModItems.Redgem, Models.GENERATED);
        itemModelGenerator.register(ModItems.BULLET, Models.GENERATED);
        itemModelGenerator.register(ModItems.GUN, Models.GENERATED);

        itemModelGenerator.register(ModItems.RUBY_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_HOE, Models.HANDHELD);


        itemModelGenerator.registerArmor((ArmorItem) ModItems.RUBY_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.RUBY_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.RUBY_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.RUBY_BOOTS);
    }
}
