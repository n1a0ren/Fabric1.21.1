package com.rickyli.entity.client;

import com.rickyli.RickyLiMod;
import com.rickyli.entity.custom.BulletEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class BulletEntityRenderer extends ProjectileEntityRenderer<BulletEntity> {
    public BulletEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }
    public static final Identifier TEXTURE = Identifier.of(RickyLiMod.MOD_ID, "textures/entity/projectiles/bullet.png");

    @Override
    public Identifier getTexture(BulletEntity entity) {
        return TEXTURE;
    }
}
