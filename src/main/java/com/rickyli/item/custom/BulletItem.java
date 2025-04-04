package com.rickyli.item.custom;

import com.rickyli.entity.ModEntities;
import com.rickyli.entity.custom.BulletEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ProjectileItem;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BulletItem extends Item implements ProjectileItem {
    public BulletItem(Item.Settings settings) {
        super(settings);
    }
    public ProjectileEntity createBullet(World world, ItemStack stack, LivingEntity shooter, @Nullable ItemStack shotFrom) {
        return new BulletEntity(ModEntities.BULLET, shooter, world, stack.copyWithCount(1), shotFrom);
    }
    @Override
    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        BulletEntity bulletEntity = new BulletEntity(ModEntities.BULLET, pos.getX(), pos.getY(), pos.getZ(), world, stack.copyWithCount(1), null);
        return bulletEntity;
    }
}
