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

    /**public final void registerCrop(Block crop, Property<Integer> ageProperty, int... ageTextureIndices) {
        if (ageProperty.getValues().size() != ageTextureIndices.length) {
            throw new IllegalArgumentException();
        } else {
            Int2ObjectMap<Identifier> int2ObjectMap = new Int2ObjectOpenHashMap();
            BlockStateVariantMap blockStateVariantMap = BlockStateVariantMap.create(ageProperty).register((integer) -> {
                int i = ageTextureIndices[integer];
                Identifier identifier = (Identifier)int2ObjectMap.computeIfAbsent(i, (j) -> {
                    return this.createSubModel(crop, "_stage" + i, Models.CROP, TextureMap::crop);
                });
                return BlockStateVariant.create().put(VariantSettings.MODEL, identifier);
            });
            this.registerItemModel(crop.asItem());
            this.blockStateCollector.accept(VariantsBlockStateSupplier.create(crop).coordinate(blockStateVariantMap));
        }
    }

    public void registerSimpleCubeAll(Block block) {
        this.registerSingleton(block, TexturedModel.CUBE_ALL);
    }

    public void registerSingleton(Block block, TexturedModel.Factory modelFactory) {
        this.blockStateCollector.accept(createSingletonBlockState(block, modelFactory.upload(block, this.modelCollector)));
    }
    private void registerBell() {
        Identifier identifier = ModelIds.getBlockSubModelId(Blocks.BELL, "_floor");
        Identifier identifier2 = ModelIds.getBlockSubModelId(Blocks.BELL, "_ceiling");
        Identifier identifier3 = ModelIds.getBlockSubModelId(Blocks.BELL, "_wall");
        Identifier identifier4 = ModelIds.getBlockSubModelId(Blocks.BELL, "_between_walls");
        this.registerItemModel(Items.BELL);
        this.blockStateCollector.accept(VariantsBlockStateSupplier.create(Blocks.BELL).coordinate(BlockStateVariantMap
                .create(Properties.HORIZONTAL_FACING, Properties.ATTACHMENT)
                .register(Direction.NORTH, Attachment.FLOOR, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, identifier))
                .register(Direction.SOUTH, Attachment.FLOOR, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, identifier)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.EAST, Attachment.FLOOR, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, identifier)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, Attachment.FLOOR, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, identifier)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.NORTH, Attachment.CEILING, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, identifier2))
                .register(Direction.SOUTH, Attachment.CEILING, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, identifier2)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.EAST, Attachment.CEILING, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, identifier2)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.WEST, Attachment.CEILING, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, identifier2)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.NORTH, Attachment.SINGLE_WALL, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, identifier3)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.SOUTH, Attachment.SINGLE_WALL, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, identifier3)
                        .put(VariantSettings.Y, VariantSettings.Rotation.R90)).register(Direction.EAST, Attachment.SINGLE_WALL, BlockStateVariant.create().put(VariantSettings.MODEL, identifier3)).register(Direction.WEST, Attachment.SINGLE_WALL, BlockStateVariant.create().put(VariantSettings.MODEL, identifier3).put(VariantSettings.Y, VariantSettings.Rotation.R180)).register(Direction.SOUTH, Attachment.DOUBLE_WALL, BlockStateVariant.create().put(VariantSettings.MODEL, identifier4).put(VariantSettings.Y, VariantSettings.Rotation.R90)).register(Direction.NORTH, Attachment.DOUBLE_WALL, BlockStateVariant.create().put(VariantSettings.MODEL, identifier4).put(VariantSettings.Y, VariantSettings.Rotation.R270)).register(Direction.EAST, Attachment.DOUBLE_WALL, BlockStateVariant.create().put(VariantSettings.MODEL, identifier4)).register(Direction.WEST, Attachment.DOUBLE_WALL, BlockStateVariant.create().put(VariantSettings.MODEL, identifier4).put(VariantSettings.Y, VariantSettings.Rotation.R180))));
    }*/
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
