package com.enhancedfarming.tags;

import com.enhancedfarming.blocks.FertilizedFarmland;
import com.enhancedfarming.blocks.ModBlocks;
import com.enhancedfarming.items.FertilizerItem;
import com.enhancedfarming.items.ModItems;
import com.enhancedfarming.items.RottenAppleItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static com.enhancedfarming.EnhancedFarming.ENHANCED_FARMING_GROUP_KEY;
import static com.enhancedfarming.EnhancedFarming.MOD_NAME;

public class EnglishLangProvider extends FabricLanguageProvider {
    public EnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        // Item Group
        translationBuilder.add(ENHANCED_FARMING_GROUP_KEY, MOD_NAME);
        
        // Blocks
        translationBuilder.add(ModBlocks.FERTILIZED_FARMLAND, FertilizedFarmland.NAME);

        // Blocks (as Item)
        translationBuilder.add(ModBlocks.FERTILIZED_FARMLAND.asItem(), FertilizedFarmland.NAME);

        // Items
        translationBuilder.add(ModItems.FERTILIZER, FertilizerItem.NAME);
        translationBuilder.add(ModItems.ROTTEN_APPLE, RottenAppleItem.NAME);

        // Tooltips
        translationBuilder.add("item.enhanced-farming.rotten_apple.tooltip", "No longer edible, can be composted");
        translationBuilder.add("item.enhanced-farming.fertilizer.tooltip", "Speeds up crop growth");

    }
}
