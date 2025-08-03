package com.enhancedfarming.items;

import com.enhancedfarming.blocks.blockgeos.SprinklerGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SprinklerItemRenderer extends GeoItemRenderer<SprinklerItem> {
    public SprinklerItemRenderer() {
        super(new SprinklerGeoModel());
    }
}
