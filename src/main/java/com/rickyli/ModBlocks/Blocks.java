package com.rickyli.ModBlocks;


import com.rickyli.RickyLiMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class Blocks {
    public static final Block rubyore = registerBlock("ruby_ore", new Block(AbstractBlock.Settings.create()
            .strength(3.0f)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresTool()
    ));
    public static final Block rubyblock = registerBlock("ruby_block", new Block(AbstractBlock.Settings.create()
            .strength(1.5f)
            .instrument(NoteBlockInstrument.BASEDRUM)
    ));

    public static final Block firstblock = registerBlock("firstblock", new Block(AbstractBlock.Settings.create()));
    public static Block registerBlock(String id, Block block) {
        registerBlockItem(id, block);
        return Registry.register(Registries.BLOCK, Identifier.of(RickyLiMod.MOD_ID, id), block);
    }
    public static void registerBlockItem(String id, Block block) {
        Item item = Registry.register(Registries.ITEM, Identifier.of(RickyLiMod.MOD_ID, id), new BlockItem(block, new Item.Settings()));
        if(item instanceof BlockItem){
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
    }
    public static void init() {
    }
}

