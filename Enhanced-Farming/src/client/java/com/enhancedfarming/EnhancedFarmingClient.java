package com.enhancedfarming;

import com.enhancedfarming.blocks.ModBlockEntities;
import com.enhancedfarming.blocks.blockentities.SprinklerBlockEntityRenderer;
import com.enhancedfarming.blocks.blockgeos.SprinklerGeoModel;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class EnhancedFarmingClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		BlockEntityRendererFactories.register(
				ModBlockEntities.SPRINKLER_BLOCK_ENTITY, 
				context -> new SprinklerBlockEntityRenderer(new SprinklerGeoModel())
		);
	}
}