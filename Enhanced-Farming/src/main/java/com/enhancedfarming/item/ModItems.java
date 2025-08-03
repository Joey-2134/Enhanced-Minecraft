package com.enhancedfarming.item;

import com.enhancedfarming.EnhancedFarming;
import com.enhancedfarming.item.items.FertilizerItem;
import com.enhancedfarming.item.settings.FertilizerItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.List;

import static com.enhancedfarming.EnhancedFarming.MOD_ID;

public class ModItems {

    public static final Item FERTILIZER_ITEM = registerItem(
            new FertilizerItem(FertilizerItemSettings.getSettings()),
            FertilizerItem.IDENTIFIER
    );

    /**
     * Add all mod items here
     */
    public static final List<Item> ENHANCED_FARMING_ITEMS = List.of(
            FERTILIZER_ITEM
    );

    private static Item registerItem(Item item, Identifier identifier) {
        return Registry.register(Registries.ITEM, identifier, item);
    }

    public static void registerModItems() {
        EnhancedFarming.LOGGER.info("Registering Mod Items for " + MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(FERTILIZER_ITEM);
        });
    }
}
