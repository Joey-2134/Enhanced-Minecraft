package com.enhancedfarming.translations;

import com.enhancedfarming.blocks.FertilizedFarmland;
import com.enhancedfarming.blocks.ModBlocks;
import com.enhancedfarming.blocks.Sprinkler;
import com.enhancedfarming.items.FertilizerItem;
import com.enhancedfarming.items.ModItems;
import com.enhancedfarming.items.RottenAppleItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static com.enhancedfarming.EnhancedFarming.ENHANCED_FARMING_GROUP_KEY;
import static com.enhancedfarming.EnhancedFarming.MOD_NAME;
import static com.enhancedfarming.advancements.AdvancementProvider.GET_FERTILIZER_DESCRIPTION;
import static com.enhancedfarming.advancements.AdvancementProvider.GET_FERTILIZER_TITLE;
import static com.enhancedfarming.items.FertilizerItem.FERTILIZER_TOOLTIP;
import static com.enhancedfarming.items.RottenAppleItem.ROTTEN_APPLE_TOOLTIP;

public class EnglishLangProvider extends FabricLanguageProvider {

    public EnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        // Item Group
        translationBuilder.add(ENHANCED_FARMING_GROUP_KEY, MOD_NAME);
        
        // Blocks
        translationBuilder.add(ModBlocks.FERTILIZED_FARMLAND, FertilizedFarmland.FERTILIZED_FARMLAND_BLOCK_NAME);
        translationBuilder.add(ModBlocks.SPRINKLER, Sprinkler.SPRINKLER_BLOCK_NAME);

        // Blocks (as Item)
        translationBuilder.add(ModBlocks.FERTILIZED_FARMLAND.asItem(), FertilizedFarmland.FERTILIZED_FARMLAND_BLOCK_NAME);
        translationBuilder.add(ModBlocks.SPRINKLER.asItem(), Sprinkler.SPRINKLER_BLOCK_NAME);

        // Items
        translationBuilder.add(ModItems.FERTILIZER, FertilizerItem.FERTILIZER_ITEM_NAME);
        translationBuilder.add(ModItems.ROTTEN_APPLE, RottenAppleItem.ROTTEN_APPLE_ITEM_NAME);

        // Tooltips
        translationBuilder.add(ROTTEN_APPLE_TOOLTIP, "No longer edible, can be composted");
        translationBuilder.add(FERTILIZER_TOOLTIP, "Speeds up crop growth");

        //Advancements
        translationBuilder.add(GET_FERTILIZER_TITLE, "Fertilizer");
        translationBuilder.add(GET_FERTILIZER_DESCRIPTION, "Acquire fertilizer to speed up crop growth");

    }
}
