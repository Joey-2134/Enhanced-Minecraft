package com.enhancedfarming.items;

import com.enhancedfarming.blocks.ModBlocks;
import com.enhancedfarming.items.settings.FertilizerSettings;
import com.enhancedfarming.items.settings.RottenAppleSettings;
import com.enhancedfarming.items.settings.SprinklerItemSettings;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Function;

import static com.enhancedfarming.EnhancedFarming.*;

public class ModItems {


    public static final Item FERTILIZER = register("fertilizer", FertilizerItem::new, FertilizerSettings.getSettings());
    public static final Item ROTTEN_APPLE = register("rotten_apple", RottenAppleItem::new, RottenAppleSettings.getSettings());
    public static final Item SPRINKLER_ITEM = register("sprinkler_item", settings -> new SprinklerItem(ModBlocks.SPRINKLER, settings), SprinklerItemSettings.getSettings());

    /**
        Add all mod items here
     */
    public static final List<Item> ENHANCED_FARMING_ITEMS = List.of(
            FERTILIZER,
            ROTTEN_APPLE,
            SPRINKLER_ITEM
    );

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }

    public static void initialize() {
        CompostingChanceRegistry.INSTANCE.add(ROTTEN_APPLE, 0.3f);
    }

}
