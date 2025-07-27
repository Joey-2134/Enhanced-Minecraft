package com.enhancedfarming.items.settings;

import com.enhancedfarming.interfaces.ItemSettings;
import net.minecraft.item.Item;

public class FertilizerSettings implements ItemSettings {
    public static Item.Settings getSettings() {
        return new Item.Settings();
    }
}
