package com.rickyli.datagen;

import com.rickyli.ModBlocks.MBlocks;
import com.rickyli.tags.ModBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(MBlocks.rubyblock)
                .add(MBlocks.rubyore)
                .add(MBlocks.deepslate_rubyore);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(MBlocks.rubyore)
                .add(MBlocks.deepslate_rubyore);
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(MBlocks.rubyblock);
        getOrCreateTagBuilder(ModBlockTags.ORE_LIST)
                .add(MBlocks.rubyore)
                .add(MBlocks.deepslate_rubyore)
                .forceAddTag(BlockTags.COAL_ORES)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES)
                .forceAddTag(BlockTags.COPPER_ORES)
                .forceAddTag(BlockTags.LAPIS_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES);
    }
}
