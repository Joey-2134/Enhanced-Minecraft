package com.enhancedfarming.items;

import com.enhancedfarming.EnhancedFarming;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static com.enhancedfarming.items.settings.RottenAppleSettings.POISON_FOOD_COMPONENT;
import static com.enhancedfarming.items.settings.RottenAppleSettings.POISON_FOOD_CONSUMABLE_COMPONENT;

public class ModItems {

    public static final Item FERTILIZER = register("fertilizer", FertilizerItem::new, new Item.Settings());
    public static final Item ROTTEN_APPLE = register("rotten_apple", RottenAppleItem::new, new Item.Settings()
            .food(POISON_FOOD_COMPONENT, POISON_FOOD_CONSUMABLE_COMPONENT));


    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(EnhancedFarming.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(FERTILIZER));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                        .register((itemGroup) -> itemGroup.add(ROTTEN_APPLE));

        FuelRegistryEvents.BUILD.register((builder, context) -> {
//            builder.add(FERTILIZER, 30 * 20); // EXAMPLE
        });

        CompostingChanceRegistry.INSTANCE.add(ROTTEN_APPLE, 0.3f);
    }

}
