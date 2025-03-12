package com.rickyli.item;

import com.rickyli.fluid.ModFluids;
import com.rickyli.item.custom.Prospector;
import com.rickyli.RickyLiMod;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ruby = registerItem("ruby", new Item(new Item.Settings()));
    public static final Item fairwood = registerItem("fairwood", new Item((new Item.Settings()).food(ModFoodComponents.Fairwood)));
    public static final Item pressure = registerItem("pressure", new Item((new Item.Settings())));
    public static final Item prospector = registerItem("prospector", new Prospector((new Item.Settings().maxDamage(127))));
    public static final Item RUBY_SWORD = registerItem("ruby_sword", (new SwordItem(ToolMaterials.DIAMOND, (new Item.Settings()).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4F)))));
    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel", (new ShovelItem(ToolMaterials.DIAMOND, (new Item.Settings()).attributeModifiers(ShovelItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1.5F, -3.0F)))));
    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe", (new PickaxeItem(ToolMaterials.DIAMOND, (new Item.Settings()).attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1.0F, -2.8F)))));
    public static final Item RUBY_AXE = registerItem("ruby_axe", (new AxeItem(ToolMaterials.DIAMOND, (new Item.Settings()).attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 5.0F, -3.0F)))));
    public static final Item RUBY_HOE = registerItem("ruby_hoe", (new HoeItem(ToolMaterials.DIAMOND, (new Item.Settings()).attributeModifiers(HoeItem.createAttributeModifiers(ToolMaterials.DIAMOND, -3.0F, 0.0F)))));
    public static final Item RUBY_HELMET = registerItem("ruby_helmet", (new ArmorItem(ArmorMaterials.DIAMOND, net.minecraft.item.ArmorItem.Type.HELMET, (new Item.Settings()).maxDamage(net.minecraft.item.ArmorItem.Type.HELMET.getMaxDamage(33)))));
    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate", (new ArmorItem(ArmorMaterials.DIAMOND, net.minecraft.item.ArmorItem.Type.CHESTPLATE, (new Item.Settings()).maxDamage(net.minecraft.item.ArmorItem.Type.CHESTPLATE.getMaxDamage(33)))));
    public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings", (new ArmorItem(ArmorMaterials.DIAMOND, net.minecraft.item.ArmorItem.Type.LEGGINGS, (new Item.Settings()).maxDamage(net.minecraft.item.ArmorItem.Type.LEGGINGS.getMaxDamage(33)))));
    public static final Item RUBY_BOOTS = registerItem("ruby_boots", (new ArmorItem(ArmorMaterials.DIAMOND, net.minecraft.item.ArmorItem.Type.BOOTS, (new Item.Settings()).maxDamage(net.minecraft.item.ArmorItem.Type.BOOTS.getMaxDamage(33)))));
    public static final Item Big_Mouth_Bird = registerItem("big_mouth_bird", (new SwordItem(ToolMaterials.DIAMOND, (new Item.Settings()).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4F)))));
    public static final Item Honey_Bucket = registerItem("honey_bucket", (new BucketItem(ModFluids.HONEY, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1))));
    public static Item registerItem(String id, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(RickyLiMod.MOD_ID, id), item);
    }
    public static void init() {
    }
}
