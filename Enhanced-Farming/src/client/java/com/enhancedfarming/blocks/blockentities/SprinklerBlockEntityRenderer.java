package com.enhancedfarming.blocks.blockentities;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;

public class SprinklerBlockEntityRenderer implements BlockEntityRenderer<SprinklerBlockEntity> {
    public SprinklerBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
    }

    @Override
    public void render(SprinklerBlockEntity entity, float tickProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Vec3d cameraPos) {
    }
}
