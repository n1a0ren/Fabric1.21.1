package com.rickyli.setup;

import com.rickyli.entity.*;
import com.rickyli.entity.client.BadcatEntityRenderer;
import com.rickyli.entity.client.BadcatModel;
import com.rickyli.entity.client.BulletEntityRenderer;
import com.rickyli.fluid.ModFluids;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class RickyLiModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.HONEY, ModFluids.FLOWING_HONEY, new SimpleFluidRenderHandler(
                Identifier.of("minecraft:block/water_still"),
                Identifier.of("minecraft:block/water_flow"),
                0xffff00
        ));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.HONEY, ModFluids.FLOWING_HONEY);
        EntityRendererRegistry.register(ModEntities.BADCAT, BadcatEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BADCAT, BadcatModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.BULLET, BulletEntityRenderer::new);
    }
}
//if you want to use custom textures they needs to be registered.
//In this example this is unnecessary because the vanilla water textures are already registered.
//To register your custom textures use this method.
//ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
//    registry.register(new Identifier("tutorial:block/custom_fluid_still"));
//    registry.register(new Identifier("tutorial:block/custom_fluid_flowing"));
//});
// ...