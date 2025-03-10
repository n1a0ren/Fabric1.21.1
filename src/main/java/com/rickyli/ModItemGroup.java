package com.rickyli;

import com.rickyli.ModBlocks.MBlocks;
import com.rickyli.ModItems.MItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup MyGroup = Registry.register(Registries.ITEM_GROUP,Identifier.of(RickyLiMod.MOD_ID, "rickylimod"), ItemGroup.create(null, -1)
            .displayName(Text.translatable("itemGroup.rickylimod"))
            .icon(() -> new ItemStack(MItems.ruby))
            .entries((displayContext, entries) -> {
                entries.add(MItems.ruby);
                entries.add(MItems.fairwood);
                entries.add(MItems.pressure);
                entries.add(MItems.prospector);
                entries.add(MItems.RUBY_SWORD);
                entries.add(MItems.RUBY_SHOVEL);
                entries.add(MItems.RUBY_PICKAXE);
                entries.add(MItems.RUBY_AXE);
                entries.add(MItems.RUBY_HOE);
                entries.add(MItems.RUBY_HELMET);
                entries.add(MItems.RUBY_CHESTPLATE);
                entries.add(MItems.RUBY_LEGGINGS);
                entries.add(MItems.RUBY_BOOTS);
                entries.add(MItems.Big_Mouth_Bird);
                entries.add(MItems.Honey_Bucket);
                ///////////////////////////////
                entries.add(MBlocks.rubyblock);
                entries.add(MBlocks.rubyore);
                entries.add(MBlocks.deepslate_rubyore);
                entries.add(MBlocks.HONEY_BLOCK);

            })
            .build());

    public static void init(){}
}
