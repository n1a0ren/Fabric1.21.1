package com.rickyli.item.custom;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import com.rickyli.RickyLiModArmorMaterials;
import com.rickyli.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class FlashpointItem extends Item implements Equipment {
    protected final Type type;
    public FlashpointItem(Type type, Settings settings) {
        super(settings);
        this.type = type;
    }
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return this.equipAndSwap(this, world, user, hand);
    }

    @Override
    public EquipmentSlot getSlotType() {
        return this.type.getEquipmentSlot();
    }
    private static final Map<ArmorMaterial, StatusEffectInstance> map =
            new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>()
                    .put(RickyLiModArmorMaterials.FLASHPOINT.value(), new StatusEffectInstance(StatusEffects.SPEED,
                            1, 50, false, false, true)).build();

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient() && entity instanceof PlayerEntity player && !player.getInventory().getArmorStack(0).isEmpty()){
            evaluateArmorEffect(player);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffect(PlayerEntity player) {
        StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.SPEED,
                20, 50, false, false, true);
        Item boots = player.getInventory().getArmorStack(0).getItem();
        if(boots == ModItems.FLASHPOINT){
            addStatusEffect(player, effect);
        }
    }

    private void addStatusEffect(PlayerEntity player, StatusEffectInstance effect) {
        player.addStatusEffect(new StatusEffectInstance(effect));
    }

    public static enum Type implements StringIdentifiable {
        FOOT(EquipmentSlot.FEET, 13, "foot");

        public static final Codec<ArmorItem.Type> CODEC = StringIdentifiable.createBasicCodec(ArmorItem.Type::values);
        private final EquipmentSlot equipmentSlot;
        private final String name;
        private final int baseMaxDamage;

        private Type(final EquipmentSlot equipmentSlot, final int baseMaxDamage, final String name) {
            this.equipmentSlot = equipmentSlot;
            this.name = name;
            this.baseMaxDamage = baseMaxDamage;
        }

        public int getMaxDamage(int multiplier) {
            return this.baseMaxDamage * multiplier;
        }

        public EquipmentSlot getEquipmentSlot() {
            return this.equipmentSlot;
        }

        public String getName() {
            return this.name;
        }

        public boolean isTrimmable() {
            return false;
        }

        @Override
        public String asString() {
            return this.name;
        }
    }
}
