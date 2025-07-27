package com.enhancedfarming.interfaces;

import net.minecraft.item.Item;

public interface ItemSettings {
    public static Item.Settings getSettings() {
        return new Item.Settings();
    }
}
