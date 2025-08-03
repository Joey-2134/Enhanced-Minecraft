package com.enhancedfarming.block;

import com.enhancedfarming.EnhancedFarming;
import com.enhancedfarming.block.blocks.FertilizedFarmlandBlock;
import com.enhancedfarming.block.settings.FertilizedFarmlandBlockSettings;
import com.enhancedfarming.block.settings.FertilizedFarmlandItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.List;

import static com.enhancedfarming.EnhancedFarming.MOD_ID;

public class ModBlocks {

    public static final Block FERTILIZED_FARMLAND_BLOCK = registerBlock(
            new FertilizedFarmlandBlock(FertilizedFarmlandBlockSettings.getSettings()),
            FertilizedFarmlandBlock.IDENTIFIER
    );

    /**
     * Add all mod blocks here
     */
    public static final List<Block> ENHANCED_FARMING_BLOCKS = List.of(
            FERTILIZED_FARMLAND_BLOCK
    );

    private static Block registerBlock(Block block, Identifier identifier) {
        //Register BlockItem
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, FertilizedFarmlandItemSettings.getSettings()));

        //Register Block
        return Registry.register(Registries.BLOCK, identifier, block);
    }


    public static void registerModBlocks() {
        EnhancedFarming.LOGGER.info("Registering Mod Blocks for " + MOD_ID);
        ENHANCED_FARMING_BLOCKS.forEach((block) -> {

        });
    }

}
