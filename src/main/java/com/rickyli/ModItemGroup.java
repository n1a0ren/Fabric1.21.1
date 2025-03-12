package com.rickyli;

import com.rickyli.block.ModBlocks;
import com.rickyli.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup MyGroup = Registry.register(Registries.ITEM_GROUP,Identifier.of(RickyLiMod.MOD_ID, "rickylimod"), ItemGroup.create(null, -1)
            .displayName(Text.translatable("itemGroup.rickylimod"))
            .icon(() -> new ItemStack(ModItems.ruby))
            .entries((displayContext, entries) -> {
                entries.add(ModItems.ruby);
                entries.add(ModItems.fairwood);
                entries.add(ModItems.pressure);
                entries.add(ModItems.prospector);
                entries.add(ModItems.RUBY_SWORD);
                entries.add(ModItems.RUBY_SHOVEL);
                entries.add(ModItems.RUBY_PICKAXE);
                entries.add(ModItems.RUBY_AXE);
                entries.add(ModItems.RUBY_HOE);
                entries.add(ModItems.RUBY_HELMET);
                entries.add(ModItems.RUBY_CHESTPLATE);
                entries.add(ModItems.RUBY_LEGGINGS);
                entries.add(ModItems.RUBY_BOOTS);
                entries.add(ModItems.Big_Mouth_Bird);
                entries.add(ModItems.Honey_Bucket);
                ///////////////////////////////
                entries.add(ModBlocks.rubyblock);
                entries.add(ModBlocks.rubyore);
                entries.add(ModBlocks.deepslate_rubyore);
                entries.add(ModBlocks.HONEY_BLOCK);
            })
            .build());

    public static void init(){}
}
