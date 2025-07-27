package com.enhancedfarming.blocks.settings;

import com.enhancedfarming.interfaces.BlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;

public class FertilizedFarmlandSettings implements BlockSettings {
    public static AbstractBlock.Settings getSettings() {
        return AbstractBlock.Settings.copy(Blocks.FARMLAND);
    }
}
