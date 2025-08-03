package com.enhancedfarming.blocks.blockentities;

import com.enhancedfarming.blocks.blockgeos.SprinklerGeoModel;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class SprinklerBlockEntityRenderer extends GeoBlockRenderer<SprinklerBlockEntity> {

    public SprinklerBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        super(new SprinklerGeoModel());
    }
}
