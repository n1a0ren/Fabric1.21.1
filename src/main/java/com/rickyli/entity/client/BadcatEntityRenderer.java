package com.rickyli.entity.client;

import com.rickyli.RickyLiMod;
import com.rickyli.entity.custom.BadcatEntity;
import com.rickyli.entity.ModModelLayers;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class BadcatEntityRenderer extends MobEntityRenderer<BadcatEntity, BadcatModel> {

    public BadcatEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new BadcatModel(context.getPart(ModModelLayers.BADCAT)), 0.5f);
    }

    @Override
    public Identifier getTexture(BadcatEntity entity) {
        return Identifier.of(RickyLiMod.MOD_ID, "textures/entity/badcat.png");
    }
}