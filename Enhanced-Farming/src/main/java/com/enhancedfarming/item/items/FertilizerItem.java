package com.enhancedfarming.item.items;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import static com.enhancedfarming.EnhancedFarming.MOD_ID;

public class FertilizerItem extends Item {
    public static final String NAME = "Fertilizer";
    public static final String KEY = "fertilizer";
    public static final String TOOLTIP_KEY = "item.enhanced-farming.fertilizer.tooltip";
    public static final Identifier IDENTIFIER = Identifier.of(MOD_ID, KEY);

    public FertilizerItem(Settings settings) {
        super(settings);
    }
}
