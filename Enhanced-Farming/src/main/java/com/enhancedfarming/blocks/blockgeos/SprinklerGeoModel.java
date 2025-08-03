package com.enhancedfarming.blocks.blockgeos;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

import static com.enhancedfarming.EnhancedFarming.MOD_ID;

public class SprinklerGeoModel extends GeoModel {
    @Override
    public Identifier getModelResource(GeoRenderState geoRenderState) {
        return Identifier.of(MOD_ID, "geckolib/models/sprinkler.geo.json");
    }

    @Override
    public Identifier getTextureResource(GeoRenderState geoRenderState) {
        return Identifier.of(MOD_ID, "textures/block/sprinkler.png");
    }

    @Override
    public Identifier getAnimationResource(GeoAnimatable geoAnimatable) {
        return Identifier.of(MOD_ID, "geckolib/animations/sprinkler.animation.json");
    }
}
