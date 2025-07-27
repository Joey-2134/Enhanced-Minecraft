package com.enhancedfarming.items;

import com.enhancedfarming.items.settings.FertilizerSettings;
import com.enhancedfarming.items.settings.RottenAppleSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Function;

import static com.enhancedfarming.EnhancedFarming.MOD_ID;

public class ModItems {


    public static final Item FERTILIZER = register("fertilizer", FertilizerItem::new, FertilizerSettings.getSettings());
    public static final Item ROTTEN_APPLE = register("rotten_apple", RottenAppleItem::new, RottenAppleSettings.getSettings());

    public static final RegistryKey<ItemGroup> ENHANCED_FARMING_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MOD_ID, "item_group"));
    public static final ItemGroup ENHANCED_FARMING_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.FERTILIZER))
            .displayName(Text.translatable("itemGroup.enhanced-farming-group"))
            .build();

    private static final List<Item> ENHANCED_FARMING_ITEMS = List.of(
            FERTILIZER,
            ROTTEN_APPLE
    );

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }

    public static void initialize() {
        addModItemsToCustomModGroup();
        CompostingChanceRegistry.INSTANCE.add(ROTTEN_APPLE, 0.3f);
    }

    private static void addModItemsToCustomModGroup() {
        Registry.register(Registries.ITEM_GROUP, ENHANCED_FARMING_GROUP_KEY, ENHANCED_FARMING_GROUP);
        ItemGroupEvents.modifyEntriesEvent(ENHANCED_FARMING_GROUP_KEY)
                .register(itemGroup -> ModItems.ENHANCED_FARMING_ITEMS.forEach(itemGroup::add));
    }

}
