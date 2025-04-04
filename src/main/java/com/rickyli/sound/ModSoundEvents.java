package com.rickyli.sound;

import com.rickyli.RickyLiMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvents {
    public static final SoundEvent GUN_SHOOT = register("gun_shoot");
    public static SoundEvent register(String name){
        Identifier id = Identifier.of(RickyLiMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    public static void init(){}
}
