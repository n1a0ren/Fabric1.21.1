package com.rickyli.entity;

import com.rickyli.RickyLiMod;
import com.rickyli.entity.custom.BadcatEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<BadcatEntity> BADCAT = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(RickyLiMod.MOD_ID, "badcat"),
            EntityType.Builder.create(BadcatEntity::new, SpawnGroup.CREATURE).dimensions(1.0f, 1.0f).build()
    );
    public static void init() {
        FabricDefaultAttributeRegistry.register(BADCAT, BadcatEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.8)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 100.0)
                );
    }
}
