package com.enhancedfarming.interfaces;

import net.minecraft.block.AbstractBlock;

public interface BlockSettings {
    static AbstractBlock.Settings getSettings() {
        return AbstractBlock.Settings.create();
    }
}
