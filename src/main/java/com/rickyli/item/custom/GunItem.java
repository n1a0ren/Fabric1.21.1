package com.rickyli.item.custom;

import com.rickyli.item.ModItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Predicate;

public class GunItem extends RangedWeaponItem {
    public GunItem(Settings settings) {
        super(settings);
    }
    public static final Predicate<ItemStack> BULLET = stack -> stack.isOf(ModItems.BULLET);

    @Override
    public Predicate<ItemStack> getProjectiles() {
        return BULLET;
    }

    @Override
    public int getRange() {
        return 15;
    }

    @Override
    protected void shoot(LivingEntity shooter, ProjectileEntity projectile, int index, float speed, float divergence, float yaw, @Nullable LivingEntity target) {
        projectile.setVelocity(shooter, shooter.getPitch(), shooter.getYaw() + yaw, 0.0F, speed, divergence);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (user instanceof PlayerEntity playerEntity) {
            ItemStack itemStack = playerEntity.getProjectileType(stack);
            if (!itemStack.isEmpty()) {
                List<ItemStack> list = load(stack, itemStack, playerEntity);
                if (world instanceof ServerWorld serverWorld && !list.isEmpty()) {
                    this.shootAll(serverWorld, playerEntity, playerEntity.getActiveHand(), stack, list, 3.0F, 1.0F, true, null);
                }

                world.playSound(
                        null,
                        playerEntity.getX(),
                        playerEntity.getY(),
                        playerEntity.getZ(),
                        SoundEvents.ENTITY_ARROW_SHOOT,
                        SoundCategory.PLAYERS,
                        1.0F,
                        1.0F / (world.getRandom().nextFloat() * 0.4F + 1.2F) + 1.0F * 0.5F
                );
                playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
            }
        }
        return TypedActionResult.fail(stack);
    }

    @Override
    protected void shootAll(ServerWorld world, LivingEntity shooter, Hand hand, ItemStack stack, List<ItemStack> projectiles, float speed, float divergence, boolean critical, @Nullable LivingEntity target) {
        float f = EnchantmentHelper.getProjectileSpread(world, stack, shooter, 0.0F);
        float g = projectiles.size() == 1 ? 0.0F : 2.0F * f / (projectiles.size() - 1);
        float h = (projectiles.size() - 1) % 2 * g / 2.0F;
        float i = 1.0F;

        for (int j = 0; j < projectiles.size(); j++) {
            ItemStack itemStack = projectiles.get(j);
            if (!itemStack.isEmpty()) {
                float k = h + i * ((j + 1) / 2) * g;
                i = -i;
                ProjectileEntity projectileEntity = this.createBulletEntity(world, shooter, stack, itemStack, critical);
                this.shoot(shooter, projectileEntity, j, speed, divergence, k, target);
                world.spawnEntity(projectileEntity);
                stack.damage(this.getWeaponStackDamage(itemStack), shooter, LivingEntity.getSlotForHand(hand));
                if (stack.isEmpty()) {
                    break;
                }
            }
        }
    }

    protected ProjectileEntity createBulletEntity(World world, LivingEntity shooter, ItemStack weaponStack, ItemStack projectileStack, boolean critical) {
        BulletItem bulletItem = projectileStack.getItem() instanceof BulletItem bulletItem1 ? bulletItem1 : (BulletItem) ModItems.BULLET;
        PersistentProjectileEntity persistentProjectileEntity = bulletItem.createBullet(world, projectileStack, shooter, weaponStack);
        if (critical) {
            persistentProjectileEntity.setCritical(true);
        }

        return persistentProjectileEntity;
    }
}
