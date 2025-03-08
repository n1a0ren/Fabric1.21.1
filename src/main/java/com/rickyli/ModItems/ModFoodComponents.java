package com.rickyli.ModItems;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent Fairwood = (new FoodComponent.Builder()).alwaysEdible().nutrition(20).saturationModifier(2.0F).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 2400, 5), 1.0F).build();
}
