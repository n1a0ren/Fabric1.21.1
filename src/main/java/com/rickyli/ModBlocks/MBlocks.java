package com.rickyli.ModBlocks;


import com.rickyli.ModFluid.MFluids;
import com.rickyli.RickyLiMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class MBlocks {
    public static final Block rubyore = registerBlock("ruby_ore", new Block(AbstractBlock.Settings.create()
            .strength(3.0f, 3.0f)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresTool()
    ));
    public static final Block deepslate_rubyore = registerBlock("deepslate_ruby_ore", new Block(AbstractBlock.Settings.create()
            .strength(4.5f, 3.0f)
            .sounds(BlockSoundGroup.DEEPSLATE)
            .requiresTool()
    ));
    public static final Block rubyblock = registerBlock("ruby_block", new Block(AbstractBlock.Settings.create()
            .strength(5.0f, 6.0f)
            .instrument(NoteBlockInstrument.BASEDRUM)
    ));
    public static final Block firstblock = registerBlock("firstblock", new Block(AbstractBlock.Settings.create()));
    public static final Block oresniffer = registerBlock("ore_sniffer", new Block(AbstractBlock.Settings.create()));
    public static final Block HONEY_BLOCK = registerBlock("honey", new FluidBlock(MFluids.HONEY, AbstractBlock.Settings.create()
            .mapColor(MapColor.PALE_YELLOW)
            .replaceable()
            .noCollision()
            .strength(100.0F)
            .pistonBehavior(PistonBehavior.DESTROY)
            .dropsNothing()
            .liquid()
    ));



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

