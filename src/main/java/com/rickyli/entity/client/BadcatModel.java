package com.rickyli.entity.client;

import com.rickyli.entity.custom.BadcatEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class BadcatModel extends EntityModel<BadcatEntity> {
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart front_left_leg;
	private final ModelPart front_right_leg;
	private final ModelPart back_left_leg;
	private final ModelPart back_right_leg;
	private final ModelPart tail;
	private final ModelPart tail2;
	public BadcatModel(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.front_left_leg = root.getChild("front_left_leg");
		this.front_right_leg = root.getChild("front_right_leg");
		this.back_left_leg = root.getChild("back_left_leg");
		this.back_right_leg = root.getChild("back_right_leg");
		this.tail = root.getChild("tail");
		this.tail2 = root.getChild("tail2");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(20, 0).cuboid(-2.5F, -2.0F, -3.0F, 5.0F, 4.0F, 5.0F, new Dilation(0.0F))
		.uv(8, 22).cuboid(-2.0F, -3.0F, 0.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(14, 22).cuboid(1.0F, -3.0F, 0.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(30, 10).cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 15.0F, -9.0F));

		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, 3.0F, -8.0F, 4.0F, 16.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 12.0F, -10.0F, 1.5708F, 0.0F, 0.0F));

		ModelPartData front_left_leg = modelPartData.addChild("front_left_leg", ModelPartBuilder.create().uv(20, 9).cuboid(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.1F, 14.1F, -5.0F));

		ModelPartData front_right_leg = modelPartData.addChild("front_right_leg", ModelPartBuilder.create().uv(20, 9).cuboid(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.1F, 14.1F, -5.0F));

		ModelPartData back_left_leg = modelPartData.addChild("back_left_leg", ModelPartBuilder.create().uv(20, 21).cuboid(-1.0F, 0.0F, 1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.1F, 18.0F, 5.0F));

		ModelPartData back_right_leg = modelPartData.addChild("back_right_leg", ModelPartBuilder.create().uv(20, 21).cuboid(-1.0F, 0.0F, 1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.1F, 18.0F, 5.0F));

		ModelPartData tail = modelPartData.addChild("tail", ModelPartBuilder.create().uv(0, 22).cuboid(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 15.5F, 8.0F, 1.5708F, 0.0F, 0.0F));

		ModelPartData tail2 = modelPartData.addChild("tail2", ModelPartBuilder.create().uv(4, 22).cuboid(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 15.5F, 16.0F, 1.5708F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}


	@Override
	public void setAngles(BadcatEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
		head.render(matrices, vertices, light, overlay, color);
		body.render(matrices, vertices, light, overlay, color);
		front_left_leg.render(matrices, vertices, light, overlay, color);
		front_right_leg.render(matrices, vertices, light, overlay, color);
		back_left_leg.render(matrices, vertices, light, overlay, color);
		back_right_leg.render(matrices, vertices, light, overlay, color);
		tail.render(matrices, vertices, light, overlay, color);
		tail2.render(matrices, vertices, light, overlay, color);
	}
}