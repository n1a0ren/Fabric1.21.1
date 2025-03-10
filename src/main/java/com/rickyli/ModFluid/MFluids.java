package com.rickyli.ModFluid;

import com.rickyli.ModFluid.custom.Honey;
import com.rickyli.RickyLiMod;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MFluids {
    public static final FlowableFluid FLOWING_HONEY = (FlowableFluid)register("flowing_honey", new Honey.Flowing());
    public static final FlowableFluid HONEY = (FlowableFluid)register("honey", new Honey.Still());
    private static <T extends Fluid> T register(String id, T value) {
        return Registry.register(Registries.FLUID, Identifier.of(RickyLiMod.MOD_ID, id), value);
    }
    public static void init(){
    }
}
