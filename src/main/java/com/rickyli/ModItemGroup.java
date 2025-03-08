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
                entries.add(Blocks.rubyblock);
                entries.add(Blocks.rubyore);
                entries.add(Items.fairwood);
            })
            .build());

    public static void init(){}
}
