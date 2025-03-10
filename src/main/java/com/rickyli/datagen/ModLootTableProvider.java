package com.rickyli.datagen;

import com.rickyli.ModBlocks.MBlocks;
import com.rickyli.ModItems.MItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(MBlocks.rubyblock);
        addDrop(MBlocks.rubyore, oreDrops(MBlocks.rubyore, MItems.ruby));
    }
}
