package com.enhancedfarming.block.settings;

import com.enhancedfarming.interfaces.ItemSettings;
import net.minecraft.item.Item;

public class FertilizedFarmlandItemSettings implements ItemSettings {
    public static Item.Settings getSettings() {
        return new Item.Settings();
    }
}
