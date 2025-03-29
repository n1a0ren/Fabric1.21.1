package com.rickyli.util;

import com.rickyli.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier JUNGLE_TEMPLE =
            Identifier.ofVanilla("chest/jungle_temple");

    private static final Identifier CREEPER =
            Identifier.ofVanilla("entities/creeper");

    public static void init(){
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(JUNGLE_TEMPLE.equals(key.getValue())){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f)) //指定掉落概率
                        .with(ItemEntry.builder(ModItems.prospector)) //指定掉落物
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f))); //指定掉落数量最小值与最大值
            }
            if(CREEPER.equals(key.getValue())){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .with(ItemEntry.builder(ModItems.ruby))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 5.0f)));
            }});
    }
}
