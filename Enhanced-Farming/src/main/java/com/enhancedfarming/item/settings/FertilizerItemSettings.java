package com.enhancedfarming.item.settings;

import com.enhancedfarming.interfaces.ItemSettings;
import net.minecraft.item.Item;

public class FertilizerItemSettings implements ItemSettings {
    public static Item.Settings getSettings() {
        return new Item.Settings();
    }
}
