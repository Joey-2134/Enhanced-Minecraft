package com.enhancedfarming.blocks;

import com.enhancedfarming.blocks.settings.FertilizedFarmlandSettings;
import com.enhancedfarming.blocks.settings.SprinklerSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Function;

import static com.enhancedfarming.EnhancedFarming.*;

public class ModBlocks {

    public static final Block FERTILIZED_FARMLAND = register("fertilized_farmland",
            FertilizedFarmland::new,
            FertilizedFarmlandSettings.getSettings(),
            true
    );

    public static final Block SPRINKLER = register("sprinkler",
            Sprinkler::new,
            SprinklerSettings.getSettings(),
            true
    );

    /**
     Add all mod blocks here
     */
    public static final List<Block> ENHANCED_FARMING_BLOCKS = List.of(
            FERTILIZED_FARMLAND,
            SPRINKLER
    );

    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        RegistryKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    public static void initialize() {

    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, name));
    }
}
