package com.enhancedfarming;

import com.enhancedfarming.blocks.ModBlockEntities;
import com.enhancedfarming.blocks.blockentities.SprinklerBlockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class EnhancedFarmingClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		BlockEntityRendererFactories.register(
				ModBlockEntities.SPRINKLER_BLOCK_ENTITY, SprinklerBlockEntityRenderer::new
		);
	}
}