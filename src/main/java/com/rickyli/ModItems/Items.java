package com.rickyli.ModItems;

import com.rickyli.RickyLiMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Items {
    public static final Item ruby = registerItem("ruby", new Item(new Item.Settings()));
    public static final Item fairwood = registerItem("fairwood", new Item((new Item.Settings()).food(ModFoodComponents.Fairwood)));
    public static Item registerItem(String id, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(RickyLiMod.MOD_ID, id), item);
    }
    public static void init() {
    }
}
