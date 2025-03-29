package com.rickyli.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class BadcatEntity extends HostileEntity {

    public BadcatEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }
    private static final TrackedData<Boolean> IS_ATTACKING =
            DataTracker.registerData(BadcatEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(IS_ATTACKING, false);
    }
    public void setAttacking(boolean attacking) {
        this.dataTracker.set(IS_ATTACKING, attacking);
    }
    public boolean isAttacking() {
        return this.dataTracker.get(IS_ATTACKING);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
        this.goalSelector.add(2, new BadcatAttackGoal(this, 1.0, false));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0));
        this.targetSelector.add(1, (new RevengeGoal(this).setGroupRevenge(ZombifiedPiglinEntity.class)));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, MerchantEntity.class, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.add(5, new ActiveTargetGoal<>(this, TurtleEntity.class, 10, true, false, TurtleEntity.BABY_TURTLE_ON_LAND_FILTER));
    }


    public static class BadcatAttackGoal extends MeleeAttackGoal {

        private final BadcatEntity entity;
        private int ticks;

        public BadcatAttackGoal(BadcatEntity badcat, double speed, boolean pauseWhenMobIdle) {
            super(badcat, speed, pauseWhenMobIdle);
            this.entity = badcat;
        }

        public void start() {
            super.start();
            this.ticks = 0;
        }

        public void stop() {
            super.stop();
            this.entity.setAttacking(false);
        }

        public void tick() {
            super.tick();
            ++this.ticks;
            this.entity.setAttacking(this.ticks >= 5 && this.getCooldown() < this.getMaxCooldown() / 2);

        }
    }
}
