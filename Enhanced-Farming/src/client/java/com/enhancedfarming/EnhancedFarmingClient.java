package com.enhancedfarming;

import com.enhancedfarming.blocks.ModBlockEntities;
import com.enhancedfarming.blocks.blockentities.SprinklerBlockEntityRenderer;
import com.enhancedfarming.blocks.blockgeos.SprinklerGeoModel;
import com.enhancedfarming.items.ModItems;
import com.enhancedfarming.items.SprinklerItem;
import com.enhancedfarming.items.SprinklerItemRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;

public class EnhancedFarmingClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		BlockEntityRendererFactories.register(
				ModBlockEntities.SPRINKLER_BLOCK_ENTITY,
				SprinklerBlockEntityRenderer::new
		);

		((SprinklerItem) ModItems.SPRINKLER_ITEM).renderProviderHolder.setValue(new GeoRenderProvider() {
			private SprinklerItemRenderer renderer;

			@Override
			public SprinklerItemRenderer getGeoItemRenderer() {
				if (this.renderer == null)
					this.renderer = new SprinklerItemRenderer();
				return this.renderer;
			}
		});
	}
}