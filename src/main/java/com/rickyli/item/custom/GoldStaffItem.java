package com.rickyli.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class GoldStaffItem extends Item {
    public GoldStaffItem(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if(user instanceof LivingEntity entity) {
            if(user.getHungerManager().getFoodLevel() >= 3) {
                Vec3d vec3d = new Vec3d(entity.getX(), entity.getY() + 1, entity.getZ());
                Vec3d vec3d1 = user.getRotationVec(1.0F);
                FireballEntity fireballEntity = new FireballEntity(world, entity, vec3d1.normalize(), 0);
                fireballEntity.setVelocity(vec3d1.x, vec3d1.y, vec3d1.z, 10.0f, 0);
                fireballEntity.setPosition(vec3d.x, vec3d.y+1, vec3d.z);
                world.spawnEntity(fireballEntity);
                if(!user.isCreative()){
                    user.getHungerManager().add(-3, 0);
                    return TypedActionResult.success(itemStack);
                }else{
                    return TypedActionResult.success(itemStack);
                }
            }
        }
        return TypedActionResult.fail(itemStack);
    }
}
