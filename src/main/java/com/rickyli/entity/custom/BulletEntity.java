package com.rickyli.entity.custom;

import com.google.common.collect.Lists;
import com.rickyli.item.ModItems;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ProjectileDeflection;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Unit;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BulletEntity extends ProjectileEntity {
    private static final TrackedData<Byte> PROJECTILE_FLAGS = DataTracker.registerData(BulletEntity.class, TrackedDataHandlerRegistry.BYTE);
    private static final TrackedData<Byte> PIERCE_LEVEL = DataTracker.registerData(BulletEntity.class, TrackedDataHandlerRegistry.BYTE);
    private ItemStack stack = new ItemStack(ModItems.BULLET);
    private boolean inGround;
    public int shake;
    private int life;
    private BlockState inBlockState;
    private IntOpenHashSet piercedEntities;
    private List<Entity> piercingKilledEntities;
    protected int inGroundTime;
    @Nullable
    private ItemStack weapon = null;
    public BulletEntity(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }
    public BulletEntity(
            EntityType<? extends ProjectileEntity> type, double x, double y, double z, World world, ItemStack stack, @Nullable ItemStack weapon
    ) {
        this(type, world);
        this.stack = stack.copy();
        this.setCustomName(stack.get(DataComponentTypes.CUSTOM_NAME));
        Unit unit = stack.remove(DataComponentTypes.INTANGIBLE_PROJECTILE);

        this.setPosition(x, y, z);
        if (weapon != null && world instanceof ServerWorld serverWorld) {
            if (weapon.isEmpty()) {
                throw new IllegalArgumentException("Invalid weapon firing a bullet");
            }

            this.weapon = weapon.copy();
            int i = EnchantmentHelper.getProjectilePiercing(serverWorld, weapon, this.stack);
            if (i > 0) {
                this.setPierceLevel((byte)i);
            }

            //EnchantmentHelper.onProjectileSpawned(serverWorld, weapon, this, item -> this.weapon = null);
        }
    }
    public BulletEntity(
            EntityType<? extends ProjectileEntity> type, LivingEntity owner, World world, ItemStack stack, @Nullable ItemStack shotFrom) {
        this(type, owner.getX(), owner.getEyeY() - 0.1F, owner.getZ(), world, stack, shotFrom);
        this.setOwner(owner);
    }

    private void setPierceLevel(byte level) {
        this.dataTracker.set(PIERCE_LEVEL, level);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        builder.add(PROJECTILE_FLAGS, (byte)0);
        builder.add(PIERCE_LEVEL, (byte)0);
    }
    protected void age() {
        this.life++;
        if (this.life >= 1200) {
            this.discard();
        }
    }

    @Nullable
    protected EntityHitResult getEntityCollision(Vec3d currentPosition, Vec3d nextPosition) {
        return ProjectileUtil.getEntityCollision(
                this.getWorld(), this, currentPosition, nextPosition, this.getBoundingBox().stretch(this.getVelocity()).expand(1.0), this::canHit
        );
    }
    public byte getPierceLevel() {
        return this.dataTracker.get(PIERCE_LEVEL);
    }
    private static List<Double> turnIntoList(Vec3d vec3d){
        List<Double> list = new ArrayList<>();
        list.add(vec3d.getX());
        list.add(vec3d.getY());
        list.add(vec3d.getZ());
        return list;
    };
    private static boolean isOverDistance(Double dou, Double dou2){
        return Math.abs(dou - dou2) >= 100;
    };
    @Override
    public void tick() {
        if(this.getOwner() != null && !(isOverDistance(turnIntoList(this.getPos()).get(0), turnIntoList((this.getOwner()).getPos()).get(0))
        || isOverDistance(turnIntoList(this.getPos()).get(1), turnIntoList(this.getOwner().getPos()).get(1))
        || isOverDistance(turnIntoList(this.getPos()).get(2), turnIntoList(this.getOwner().getPos()).get(2)))){
            super.tick();
            boolean bl = this.isNoClip();
            Vec3d vec3d = this.getVelocity();
            if (this.prevPitch == 0.0F && this.prevYaw == 0.0F) {
                double d = vec3d.horizontalLength();
                this.setYaw((float)(MathHelper.atan2(vec3d.x, vec3d.z) * 180.0F / (float)Math.PI));
                this.setPitch((float)(MathHelper.atan2(vec3d.y, d) * 180.0F / (float)Math.PI));
                this.prevYaw = this.getYaw();
                this.prevPitch = this.getPitch();
            }

            BlockPos blockPos = this.getBlockPos();
            BlockState blockState = this.getWorld().getBlockState(blockPos);
            if (!blockState.isAir() && !bl) {
                VoxelShape voxelShape = blockState.getCollisionShape(this.getWorld(), blockPos);
                if (!voxelShape.isEmpty()) {
                    Vec3d vec3d2 = this.getPos();

                    for (Box box : voxelShape.getBoundingBoxes()) {
                        if (box.offset(blockPos).contains(vec3d2)) {
                            this.inGround = true;
                            break;
                        }
                    }
                }
            }

            if (this.shake > 0) {
                this.shake--;
            }

            if (this.isTouchingWaterOrRain() || blockState.isOf(Blocks.POWDER_SNOW)) {
                this.extinguish();
            }

            if (this.inGround && !bl) {
                if (!this.getWorld().isClient) {
                    this.age();
                }

                this.inGroundTime++;
            } else {
                this.inGroundTime = 0;
                Vec3d vec3d3 = this.getPos();
                Vec3d vec3d2 = vec3d3.add(vec3d);
                HitResult hitResult = this.getWorld()
                        .raycast(new RaycastContext(vec3d3, vec3d2, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, this));
                if (hitResult.getType() != HitResult.Type.MISS) {
                    vec3d2 = hitResult.getPos();
                }

                while (!this.isRemoved()) {
                    EntityHitResult entityHitResult = this.getEntityCollision(vec3d3, vec3d2);
                    if (entityHitResult != null) {
                        hitResult = entityHitResult;
                    }

                    if (hitResult != null && hitResult.getType() == HitResult.Type.ENTITY) {
                        Entity entity = ((EntityHitResult)hitResult).getEntity();
                        Entity entity2 = this.getOwner();
                        if (entity instanceof PlayerEntity && entity2 instanceof PlayerEntity && !((PlayerEntity)entity2).shouldDamagePlayer((PlayerEntity)entity)) {
                            hitResult = null;
                            entityHitResult = null;
                        }
                    }

                    if (hitResult != null && !bl) {
                        ProjectileDeflection projectileDeflection = this.hitOrDeflect(hitResult);
                        this.velocityDirty = true;
                        if (projectileDeflection != ProjectileDeflection.NONE) {
                            break;
                        }
                    }

                    if (entityHitResult == null || this.getPierceLevel() <= 0) {
                        break;
                    }

                    hitResult = null;
                }

                vec3d = this.getVelocity();
                double e = vec3d.x;
                double f = vec3d.y;
                double g = vec3d.z;
            /*if (this.isCritical()) {
                for (int i = 0; i < 4; i++) {
                    this.getWorld().addParticle(ParticleTypes.CRIT, this.getX() + e * i / 4.0, this.getY() + f * i / 4.0, this.getZ() + g * i / 4.0, -e, -f + 0.2, -g);
                }
            }**/

                double h = this.getX() + e;
                double j = this.getY() + f;
                double k = this.getZ() + g;
                double l = vec3d.horizontalLength();
                if (bl) {
                    this.setYaw((float)(MathHelper.atan2(-e, -g) * 180.0F / (float)Math.PI));
                } else {
                    this.setYaw((float)(MathHelper.atan2(e, g) * 180.0F / (float)Math.PI));
                }

                this.setPitch((float)(MathHelper.atan2(f, l) * 180.0F / (float)Math.PI));
                this.setPitch(updateRotation(this.prevPitch, this.getPitch()));
                this.setYaw(updateRotation(this.prevYaw, this.getYaw()));
                float m = 0.99F;
            /*if (this.isTouchingWater()) {
                for (int n = 0; n < 4; n++) {
                    float o = 0.25F;
                    this.getWorld().addParticle(ParticleTypes.BUBBLE, h - e * 0.25, j - f * 0.25, k - g * 0.25, e, f, g);
                }

                m = 0.6F;
            }*/

                this.setVelocity(vec3d.multiply(10.0f));

                this.setPosition(h, j, k);
                this.checkBlockCollision();
            }
        }
        else{
            this.discard();
        }

        /*super.tick();
        Vec3d vec3d = this.getVelocity();

        if (this.prevPitch == 0.0F && this.prevYaw == 0.0F) {
            double d = vec3d.horizontalLength();
            this.setYaw((float)(MathHelper.atan2(vec3d.x, vec3d.z) * 180.0F / (float)Math.PI));
            this.setPitch((float)(MathHelper.atan2(vec3d.y, d) * 180.0F / (float)Math.PI));
            this.prevYaw = this.getYaw();
            this.prevPitch = this.getPitch();
        }
        this.setPitch(updateRotation(this.prevPitch, this.getPitch()));
        this.setYaw(updateRotation(this.prevYaw, this.getYaw()));




        Entity entity = this.getOwner();
        if (this.getWorld().isClient || (entity == null || !entity.isRemoved()) && this.getWorld().isChunkLoaded(this.getBlockPos())) {
            super.tick();
            boolean bl = this.isNoClip();
            BlockPos blockPos = this.getBlockPos();
            BlockState blockState = this.getWorld().getBlockState(blockPos);
            if (!blockState.isAir() && !bl) {
                VoxelShape voxelShape = blockState.getCollisionShape(this.getWorld(), blockPos);
                if (!voxelShape.isEmpty()) {
                    Vec3d vec3d2 = this.getPos();

                    for (Box box : voxelShape.getBoundingBoxes()) {
                        if (box.offset(blockPos).contains(vec3d2)) {
                            this.inGround = true;
                            break;
                        }
                    }
                }
            }


            HitResult hitResult = ProjectileUtil.getCollision(this, this::canHit, this.getRaycastShapeType());
            if (hitResult.getType() != HitResult.Type.MISS) {
                this.hitOrDeflect(hitResult);
            }

            this.checkBlockCollision();
            double d = this.getX() + vec3d.x;
            double e = this.getY() + vec3d.y;
            double f = this.getZ() + vec3d.z;
            ProjectileUtil.setRotationFromVelocity(this, 1.0F);
            this.setVelocity(vec3d.add(vec3d.normalize().multiply(5.0)).multiply(5.0));

            this.setPosition(d, e, f);
        } else {
            this.discard();
        }**/
    }
    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        this.inBlockState = this.getWorld().getBlockState(blockHitResult.getBlockPos());
        super.onBlockHit(blockHitResult);
        Vec3d vec3d = blockHitResult.getPos().subtract(this.getX(), this.getY(), this.getZ());
        this.setVelocity(vec3d);
        ItemStack itemStack = this.getWeaponStack();
        Vec3d vec3d2 = vec3d.normalize().multiply(0.05F);
        this.setPos(this.getX() - vec3d2.x, this.getY() - vec3d2.y, this.getZ() - vec3d2.z);
        this.inGround = true;
        this.shake = 7;
        this.setCritical(false);
        this.setPierceLevel((byte)0);
        this.clearPiercingStatus();
    }
    private void clearPiercingStatus() {
        if (this.piercingKilledEntities != null) {
            this.piercingKilledEntities.clear();
        }

        if (this.piercedEntities != null) {
            this.piercedEntities.clear();
        }
    }

    public boolean isCritical() {
        byte b = this.dataTracker.get(PROJECTILE_FLAGS);
        return (b & 1) != 0;
    }


    public boolean isNoClip() {
        return !this.getWorld().isClient ? this.noClip : (this.dataTracker.get(PROJECTILE_FLAGS) & 2) != 0;
    }
    protected RaycastContext.ShapeType getRaycastShapeType() {
        return RaycastContext.ShapeType.COLLIDER;
    }

    public void setCritical(boolean critical) {
        this.setProjectileFlag(1, critical);
    }
    private void setProjectileFlag(int index, boolean flag) {
        byte b = this.dataTracker.get(PROJECTILE_FLAGS);
        if (flag) {
            this.dataTracker.set(PROJECTILE_FLAGS, (byte)(b | index));
        } else {
            this.dataTracker.set(PROJECTILE_FLAGS, (byte)(b & ~index));
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        float f = (float)this.getVelocity().length();
        double d = 2.0f;
        Entity entity2 = this.getOwner();
        DamageSource damageSource = this.getDamageSources().mobProjectile(this, (LivingEntity) entity2);
        if (this.getWeaponStack() != null && this.getWorld() instanceof ServerWorld serverWorld) {
            d = EnchantmentHelper.getDamage(serverWorld, this.getWeaponStack(), entity, damageSource, (float)d);
        }

        int i = MathHelper.ceil(MathHelper.clamp(f * d, 0.0, 2.147483647E9));
        if (this.getPierceLevel() > 0) {
            if (this.piercedEntities == null) {
                this.piercedEntities = new IntOpenHashSet(5);
            }

            if (this.piercingKilledEntities == null) {
                this.piercingKilledEntities = Lists.<Entity>newArrayListWithCapacity(5);
            }

            if (this.piercedEntities.size() >= this.getPierceLevel() + 1) {
                this.discard();
                return;
            }

            this.piercedEntities.add(entity.getId());
        }

        if (this.isCritical()) {
            long l = this.random.nextInt(i / 2 + 2);
            i = (int)Math.min(l + i, 2147483647L);
        }

        if (entity2 instanceof LivingEntity livingEntity) {
            livingEntity.onAttacking(entity);
        }

        boolean bl = entity.getType() == EntityType.ENDERMAN;
        int j = entity.getFireTicks();
        if (this.isOnFire() && !bl) {
            entity.setOnFireFor(5.0F);
        }

        if (entity.damage(damageSource, 25)) {
            if (bl) {
                return;
            }

            if (entity instanceof LivingEntity livingEntity2) {
                if (!this.getWorld().isClient && this.getPierceLevel() <= 0) {
                    livingEntity2.setStuckArrowCount(livingEntity2.getStuckArrowCount() + 1);
                }

                //this.knockback(livingEntity2, damageSource);
                if (this.getWorld() instanceof ServerWorld serverWorld2) {
                    EnchantmentHelper.onTargetDamaged(serverWorld2, livingEntity2, damageSource, this.getWeaponStack());
                }

                //this.onHit(livingEntity2);
                if (livingEntity2 != entity2 && livingEntity2 instanceof PlayerEntity && entity2 instanceof ServerPlayerEntity && !this.isSilent()) {
                    ((ServerPlayerEntity)entity2)
                            .networkHandler
                            .sendPacket(new GameStateChangeS2CPacket(GameStateChangeS2CPacket.PROJECTILE_HIT_PLAYER, GameStateChangeS2CPacket.DEMO_OPEN_SCREEN));
                }

                if (!entity.isAlive() && this.piercingKilledEntities != null) {
                    this.piercingKilledEntities.add(livingEntity2);
                }
            }

        } else {
            entity.setFireTicks(j);
            this.deflect(ProjectileDeflection.SIMPLE, entity, this.getOwner(), false);
            this.setVelocity(this.getVelocity().multiply(0.2));
            if (!this.getWorld().isClient && this.getVelocity().lengthSquared() < 1.0E-7) {
                this.discard();
            }
        }
    }

    @Override
    public boolean shouldRender(double distance) {
        double d = this.getBoundingBox().getAverageSideLength() * 10.0;
        if (Double.isNaN(d)) {
            d = 1.0;
        }

        d *= 64.0 * getRenderDistanceMultiplier();
        return distance < d * d;
    }
}
