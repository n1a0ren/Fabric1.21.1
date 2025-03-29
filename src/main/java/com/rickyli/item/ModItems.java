package com.rickyli.item;

import com.rickyli.item.materials.RickyLiModArmorMaterials;
import com.rickyli.item.materials.RickyLiModToolMaterials;
import com.rickyli.block.ModBlocks;
import com.rickyli.entity.ModEntities;
import com.rickyli.fluid.ModFluids;
import com.rickyli.item.custom.FlashpointItem;
import com.rickyli.item.custom.RubyArmorItem;
import com.rickyli.item.custom.Prospector;
import com.rickyli.RickyLiMod;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ruby = registerItem("ruby", new Item(new Item.Settings()));

    public static final Item fairwood = registerItem("fairwood", new AliasedBlockItem(ModBlocks.FAIRWOOD,
            new Item.Settings()));
    public static final Item CURRY = registerItem("curry", new Item(
            new Item.Settings()
                    .food(ModFoodComponents.Fairwood)));

    public static final Item pressure = registerItem("pressure", new Item(
            new Item.Settings()));

    public static final Item prospector = registerItem("prospector", new Prospector(
            new Item.Settings()
                    .maxDamage(127)));

    public static final Item RUBY_SWORD = registerItem("ruby_sword", new SwordItem(RickyLiModToolMaterials.RUBY,
            new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(RickyLiModToolMaterials.RUBY, 3, -2.4F))));

    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel", new ShovelItem(RickyLiModToolMaterials.RUBY,
            new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(RickyLiModToolMaterials.RUBY, 1.5F, -3.0F))));

    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe", new PickaxeItem(RickyLiModToolMaterials.RUBY,
            new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(RickyLiModToolMaterials.RUBY, 1.0F, -2.8F))));

    public static final Item RUBY_AXE = registerItem("ruby_axe", new AxeItem(RickyLiModToolMaterials.RUBY,
            new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(RickyLiModToolMaterials.RUBY, 5.0F, -3.0F))));

    public static final Item RUBY_HOE = registerItem("ruby_hoe", new HoeItem(RickyLiModToolMaterials.RUBY,
            new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(RickyLiModToolMaterials.RUBY, -3.0F, 0.0F))));

    public static final Item RUBY_HELMET = registerItem("ruby_helmet", new RubyArmorItem(RickyLiModArmorMaterials.RUBY, ArmorItem.Type.HELMET,
            new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(33))));

    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate", new RubyArmorItem(RickyLiModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE,
            new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(33))));

    public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings", new RubyArmorItem(RickyLiModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS,
            new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(33))));

    public static final Item RUBY_BOOTS = registerItem("ruby_boots", new RubyArmorItem(RickyLiModArmorMaterials.RUBY, ArmorItem.Type.BOOTS,
            new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(33))));

    public static final Item Big_Mouth_Bird = registerItem("big_mouth_bird", new SwordItem(RickyLiModToolMaterials.RUBY,
            new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(RickyLiModToolMaterials.RUBY, 3, 0))));

    public static final Item Honey_Bucket = registerItem("honey_bucket", new BucketItem(ModFluids.HONEY,
            new Item.Settings()
                    .recipeRemainder(Items.BUCKET)
                    .maxCount(1)));

    public static final Item FLASHPOINT = registerItem("flashpoint", new FlashpointItem(FlashpointItem.Type.FOOT,
            new Item.Settings()
                    .maxDamage(99999)));

    public static final Item TESTSMELT = registerItem("testsmelt", new Item(
            new Item.Settings()));

    public static final Item BADCAT_SPAWNEGG = registerItem("badcat_spawnegg", new SpawnEggItem(
            ModEntities.BADCAT, 0x252525, 0x4D4D4D, new Item.Settings()));

    public static final Item GOLD_STAFF = registerItem("gold_staff", new Item(
            new Item.Settings()));


    public static Item registerItem(String id, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(RickyLiMod.MOD_ID, id), item);
    }
    public static void init() {
    }
}
