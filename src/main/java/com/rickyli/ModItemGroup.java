package com.rickyli;

import com.rickyli.ModBlocks.Blocks;
import com.rickyli.ModItems.Items;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup MyGroup = Registry.register(Registries.ITEM_GROUP,Identifier.of(RickyLiMod.MOD_ID, "rickylimod"), ItemGroup.create(null, -1)
            .displayName(Text.translatable("itemGroup.rickylimod"))
            .icon(() -> new ItemStack(Items.ruby))
            .entries((displayContext, entries) -> {
                entries.add(Items.ruby);
                entries.add(Items.fairwood);
                entries.add(Items.pressure);
                entries.add(Items.prospector);
                entries.add(Items.RUBY_SWORD);
                entries.add(Items.RUBY_SHOVEL);
                entries.add(Items.RUBY_PICKAXE);
                entries.add(Items.RUBY_AXE);
                entries.add(Items.RUBY_HOE);
                entries.add(Items.RUBY_HELMET);
                entries.add(Items.RUBY_CHESTPLATE);
                entries.add(Items.RUBY_LEGGINGS);
                entries.add(Items.RUBY_BOOTS);
                entries.add(Items.Big_Mouth_Bird);
                ///////////////////////////////
                entries.add(Blocks.rubyblock);
                entries.add(Blocks.rubyore);

            })
            .build());

    public static void init(){}
}
