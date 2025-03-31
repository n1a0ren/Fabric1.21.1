package com.rickyli.tags;

import com.rickyli.RickyLiMod;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
    public static final TagKey<Item> ORE_LIST = of("ore_list");
    public static final TagKey<Item> STAFFS = of("staffs");
    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(RickyLiMod.MOD_ID, id));
    }
    public static void init(){}
}
