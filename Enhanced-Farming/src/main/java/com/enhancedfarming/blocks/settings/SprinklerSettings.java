package com.enhancedfarming.blocks.settings;

import com.enhancedfarming.interfaces.BlockSettings;
import net.minecraft.block.AbstractBlock;

public class SprinklerSettings implements BlockSettings {
    public static AbstractBlock.Settings getSettings() {
        return AbstractBlock.Settings.create().nonOpaque();
    }
}
