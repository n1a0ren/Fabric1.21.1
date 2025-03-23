package com.rickyli.datagen;

import com.rickyli.block.ModBlocks;
import com.rickyli.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }
    public LootTable.Builder fairwoodDrops(Block crop, Item product, Item seeds, LootCondition.Builder condition) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return (LootTable.Builder)this.applyExplosionDecay(crop, LootTable.builder()
                .pool(LootPool.builder()
                        .with(((LeafEntry.Builder) ItemEntry.builder(product)
                                .conditionally(condition))
                                .alternatively(ItemEntry.builder(seeds))))
                .pool(LootPool.builder()
                        .conditionally(condition)
                        .with(ItemEntry.builder(seeds)
                                .apply(ApplyBonusLootFunction.binomialWithBonusCount(impl.getOrThrow(Enchantments.FORTUNE), 1, 0)))));
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.rubyblock);
        addDrop(ModBlocks.rubyore, oreDrops(ModBlocks.rubyore, ModItems.ruby));
        LootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.FAIRWOOD)
                .properties(StatePredicate.Builder.create().exactMatch(CropBlock.AGE, 4));
        addDrop(ModBlocks.FAIRWOOD, fairwoodDrops(ModBlocks.FAIRWOOD, ModItems.CURRY, ModItems.fairwood, builder2));
    }
}
