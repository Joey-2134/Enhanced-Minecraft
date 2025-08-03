package com.enhancedfarming.items.settings;

import com.enhancedfarming.interfaces.ItemSettings;
import net.minecraft.item.Item;

public class SprinklerItemSettings implements ItemSettings {
    public static Item.Settings getSettings() {
        return new Item.Settings();
    }
}
