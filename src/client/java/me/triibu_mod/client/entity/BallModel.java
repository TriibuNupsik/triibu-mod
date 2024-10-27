package me.triibu_mod.client.entity;

import me.triibu_mod.entity.custom.BallEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class BallModel<T extends BallEntity> extends SinglePartEntityModel <T> {
	private final ModelPart ball;
	public BallModel(ModelPart root) {
		this.ball = root.getChild("ball");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(4, 17).cuboid(-0.5F, -3.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(12, 13).cuboid(-0.5F, -3.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(0, 1).cuboid(-0.5F, -0.4F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(4, 9).cuboid(-0.5F, -5.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData hexadecagon_r1 = bb_main.addChild("hexadecagon_r1", ModelPartBuilder.create().uv(4, 11).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(4, 2).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(0, 15).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(2, 18).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, -0.6981F, 0.0F));

		ModelPartData hexadecagon_r2 = bb_main.addChild("hexadecagon_r2", ModelPartBuilder.create().uv(4, 10).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(0, 4).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(8, 14).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(14, 17).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, -0.3491F, 0.0F));

		ModelPartData hexadecagon_r3 = bb_main.addChild("hexadecagon_r3", ModelPartBuilder.create().uv(12, 3).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(4, 6).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(16, 1).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(18, 8).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, -1.3963F, 0.0F));

		ModelPartData hexadecagon_r4 = bb_main.addChild("hexadecagon_r4", ModelPartBuilder.create().uv(12, 5).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(0, 8).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(16, 4).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(12, 18).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, -3.1416F, -1.3963F, 3.1416F));

		ModelPartData hexadecagon_r5 = bb_main.addChild("hexadecagon_r5", ModelPartBuilder.create().uv(8, 12).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(8, 2).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(8, 16).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(18, 15).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, -3.1416F, -1.0472F, 3.1416F));

		ModelPartData hexadecagon_r6 = bb_main.addChild("hexadecagon_r6", ModelPartBuilder.create().uv(0, 13).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(8, 7).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(16, 14).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(10, 19).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, -3.1416F, -0.3491F, 3.1416F));

		ModelPartData hexadecagon_r7 = bb_main.addChild("hexadecagon_r7", ModelPartBuilder.create().uv(12, 0).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(0, 5).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(10, 15).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(18, 5).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		ModelPartData hexadecagon_r8 = bb_main.addChild("hexadecagon_r8", ModelPartBuilder.create().uv(12, 10).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(8, 4).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(16, 11).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(0, 19).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, -3.1416F, -0.6981F, 3.1416F));

		ModelPartData hexadecagon_r9 = bb_main.addChild("hexadecagon_r9", ModelPartBuilder.create().uv(4, 13).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(8, 8).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(16, 15).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(12, 19).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 2.7489F, -0.3491F, 3.1416F));

		ModelPartData hexadecagon_r10 = bb_main.addChild("hexadecagon_r10", ModelPartBuilder.create().uv(12, 12).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(8, 6).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(14, 16).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(8, 19).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, -2.7489F, -0.3491F, 3.1416F));

		ModelPartData hexadecagon_r11 = bb_main.addChild("hexadecagon_r11", ModelPartBuilder.create().uv(16, 16).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(14, 19).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 2.3562F, -0.3491F, 3.1416F));

		ModelPartData hexadecagon_r12 = bb_main.addChild("hexadecagon_r12", ModelPartBuilder.create().uv(16, 13).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(6, 19).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, -2.3562F, -0.3491F, 3.1416F));

		ModelPartData hexadecagon_r13 = bb_main.addChild("hexadecagon_r13", ModelPartBuilder.create().uv(12, 11).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(8, 5).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(12, 16).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(2, 19).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 2.7489F, -0.6981F, 3.1416F));

		ModelPartData hexadecagon_r14 = bb_main.addChild("hexadecagon_r14", ModelPartBuilder.create().uv(12, 9).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(4, 8).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(16, 10).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(18, 18).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, -2.7489F, -0.6981F, 3.1416F));

		ModelPartData hexadecagon_r15 = bb_main.addChild("hexadecagon_r15", ModelPartBuilder.create().uv(16, 12).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(4, 19).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 2.3562F, -0.6981F, 3.1416F));

		ModelPartData hexadecagon_r16 = bb_main.addChild("hexadecagon_r16", ModelPartBuilder.create().uv(10, 16).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(18, 17).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, -2.3562F, -0.6981F, 3.1416F));

		ModelPartData hexadecagon_r17 = bb_main.addChild("hexadecagon_r17", ModelPartBuilder.create().uv(12, 8).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(8, 3).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(16, 8).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(16, 18).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 2.7489F, -1.0472F, 3.1416F));

		ModelPartData hexadecagon_r18 = bb_main.addChild("hexadecagon_r18", ModelPartBuilder.create().uv(12, 7).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(8, 1).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(16, 7).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(18, 14).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, -2.7489F, -1.0472F, 3.1416F));

		ModelPartData hexadecagon_r19 = bb_main.addChild("hexadecagon_r19", ModelPartBuilder.create().uv(16, 9).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(18, 16).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 2.3562F, -1.0472F, 3.1416F));

		ModelPartData hexadecagon_r20 = bb_main.addChild("hexadecagon_r20", ModelPartBuilder.create().uv(16, 6).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(14, 18).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, -2.3562F, -1.0472F, 3.1416F));

		ModelPartData hexadecagon_r21 = bb_main.addChild("hexadecagon_r21", ModelPartBuilder.create().uv(12, 6).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(8, 0).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(16, 5).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(18, 12).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 2.7489F, -1.3963F, 3.1416F));

		ModelPartData hexadecagon_r22 = bb_main.addChild("hexadecagon_r22", ModelPartBuilder.create().uv(12, 4).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(4, 7).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(4, 16).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(18, 11).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, -2.7489F, -1.3963F, 3.1416F));

		ModelPartData hexadecagon_r23 = bb_main.addChild("hexadecagon_r23", ModelPartBuilder.create().uv(6, 16).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(18, 13).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 2.3562F, -1.3963F, 3.1416F));

		ModelPartData hexadecagon_r24 = bb_main.addChild("hexadecagon_r24", ModelPartBuilder.create().uv(16, 3).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(18, 10).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, -2.3562F, -1.3963F, 3.1416F));

		ModelPartData hexadecagon_r25 = bb_main.addChild("hexadecagon_r25", ModelPartBuilder.create().uv(4, 12).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(0, 7).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(2, 16).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(18, 9).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, -0.3927F, -1.3963F, 0.0F));

		ModelPartData hexadecagon_r26 = bb_main.addChild("hexadecagon_r26", ModelPartBuilder.create().uv(12, 2).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(0, 6).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(16, 0).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(8, 18).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.3927F, -1.3963F, 0.0F));

		ModelPartData hexadecagon_r27 = bb_main.addChild("hexadecagon_r27", ModelPartBuilder.create().uv(16, 2).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(10, 18).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, -0.7854F, -1.3963F, 0.0F));

		ModelPartData hexadecagon_r28 = bb_main.addChild("hexadecagon_r28", ModelPartBuilder.create().uv(0, 16).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(18, 7).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.7854F, -1.3963F, 0.0F));

		ModelPartData hexadecagon_r29 = bb_main.addChild("hexadecagon_r29", ModelPartBuilder.create().uv(12, 1).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(4, 5).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(12, 15).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(6, 18).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, -0.3927F, -1.0472F, 0.0F));

		ModelPartData hexadecagon_r30 = bb_main.addChild("hexadecagon_r30", ModelPartBuilder.create().uv(0, 12).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(4, 4).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(8, 15).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(18, 4).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.3927F, -1.0472F, 0.0F));

		ModelPartData hexadecagon_r31 = bb_main.addChild("hexadecagon_r31", ModelPartBuilder.create().uv(14, 15).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(18, 6).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, -0.7854F, -1.0472F, 0.0F));

		ModelPartData hexadecagon_r32 = bb_main.addChild("hexadecagon_r32", ModelPartBuilder.create().uv(6, 15).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(4, 18).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.7854F, -1.0472F, 0.0F));

		ModelPartData hexadecagon_r33 = bb_main.addChild("hexadecagon_r33", ModelPartBuilder.create().uv(8, 11).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(4, 3).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(2, 15).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(18, 2).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, -0.3927F, -0.6981F, 0.0F));

		ModelPartData hexadecagon_r34 = bb_main.addChild("hexadecagon_r34", ModelPartBuilder.create().uv(0, 11).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(4, 1).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(14, 14).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(18, 1).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.3927F, -0.6981F, 0.0F));

		ModelPartData hexadecagon_r35 = bb_main.addChild("hexadecagon_r35", ModelPartBuilder.create().uv(4, 15).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(18, 3).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, -0.7854F, -0.6981F, 0.0F));

		ModelPartData hexadecagon_r36 = bb_main.addChild("hexadecagon_r36", ModelPartBuilder.create().uv(14, 13).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(18, 0).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.7854F, -0.6981F, 0.0F));

		ModelPartData hexadecagon_r37 = bb_main.addChild("hexadecagon_r37", ModelPartBuilder.create().uv(8, 10).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(4, 0).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(10, 14).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(16, 17).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, -0.3927F, -0.3491F, 0.0F));

		ModelPartData hexadecagon_r38 = bb_main.addChild("hexadecagon_r38", ModelPartBuilder.create().uv(0, 10).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(0, 3).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(6, 14).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(12, 17).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.3927F, -0.3491F, 0.0F));

		ModelPartData hexadecagon_r39 = bb_main.addChild("hexadecagon_r39", ModelPartBuilder.create().uv(12, 14).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(0, 18).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, -0.7854F, -0.3491F, 0.0F));

		ModelPartData hexadecagon_r40 = bb_main.addChild("hexadecagon_r40", ModelPartBuilder.create().uv(4, 14).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(10, 17).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.7854F, -0.3491F, 0.0F));

		ModelPartData hexadecagon_r41 = bb_main.addChild("hexadecagon_r41", ModelPartBuilder.create().uv(8, 9).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(0, 2).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(0, 14).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(6, 17).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		ModelPartData hexadecagon_r42 = bb_main.addChild("hexadecagon_r42", ModelPartBuilder.create().uv(0, 9).cuboid(-0.5F, -2.8F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-0.5F, 2.6F, -0.557F, 1.0F, 0.2F, 1.1139F, new Dilation(0.0F))
		.uv(10, 13).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(2, 17).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		ModelPartData hexadecagon_r43 = bb_main.addChild("hexadecagon_r43", ModelPartBuilder.create().uv(2, 14).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(8, 17).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		ModelPartData hexadecagon_r44 = bb_main.addChild("hexadecagon_r44", ModelPartBuilder.create().uv(8, 13).cuboid(-0.5F, -0.557F, 2.6F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F))
		.uv(0, 17).cuboid(-0.5F, -0.557F, -2.8F, 1.0F, 1.1139F, 0.2F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(BallEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		ball.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return ball;
	}
}