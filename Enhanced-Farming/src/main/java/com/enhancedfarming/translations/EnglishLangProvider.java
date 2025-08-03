package com.enhancedfarming.translations;

import com.enhancedfarming.block.ModBlocks;
import com.enhancedfarming.block.blocks.FertilizedFarmlandBlock;
import com.enhancedfarming.item.ModItems;
import com.enhancedfarming.item.items.FertilizerItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static com.enhancedfarming.EnhancedFarming.ENHANCED_FARMING_GROUP_KEY;
import static com.enhancedfarming.EnhancedFarming.MOD_NAME;
import static com.enhancedfarming.advancements.AdvancementProvider.GET_FERTILIZER_DESCRIPTION;
import static com.enhancedfarming.advancements.AdvancementProvider.GET_FERTILIZER_TITLE;

public class EnglishLangProvider extends FabricLanguageProvider {

    public EnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        // Item Group
        translationBuilder.add(ENHANCED_FARMING_GROUP_KEY, MOD_NAME);
        
        // Blocks
        translationBuilder.add(ModBlocks.FERTILIZED_FARMLAND_BLOCK, FertilizedFarmlandBlock.NAME);

        // Items
        translationBuilder.add(ModItems.FERTILIZER_ITEM, FertilizerItem.NAME);

        // Tooltips
        translationBuilder.add(FertilizerItem.TOOLTIP_KEY, "Speeds up crop growth");

        //Advancements
        translationBuilder.add(GET_FERTILIZER_TITLE, "Fertilizer");
        translationBuilder.add(GET_FERTILIZER_DESCRIPTION, "Acquire fertilizer to speed up crop growth");

    }
}
