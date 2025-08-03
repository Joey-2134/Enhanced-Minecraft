package com.enhancedfarming.recipes;

import com.enhancedfarming.blocks.ModBlocks;
import com.enhancedfarming.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

import static com.enhancedfarming.EnhancedFarming.MOD_ID;
import static com.enhancedfarming.EnhancedFarming.MOD_NAME;

public class RecipeProvider extends FabricRecipeProvider {
    public RecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                // Items
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
                createShaped(RecipeCategory.MISC, ModItems.FERTILIZER, 4)
                        .pattern("AB")
                        .pattern("C ")
                        .input('A', Items.CLAY_BALL)
                        .input('B', ItemTags.SAPLINGS)
                        .input('C', Items.BONE_MEAL)
                        .criterion(hasItem(Items.BONE_MEAL), conditionsFromItem(Items.BONE_MEAL))
                        .group(MOD_NAME)
                        .offerTo(exporter);

                // Blocks
                RegistryWrapper.Impl<Block> blockLookup = registries.getOrThrow(RegistryKeys.BLOCK);
                createShaped(RecipeCategory.MISC, ModBlocks.SPRINKLER, 1)
                        .pattern(" W ")
                        .pattern("MLM")
                        .pattern(" L ")
                        .input('W', Items.WATER_BUCKET)
                        .input('M', Blocks.STONE)
                        .input('L', ItemTags.LOGS)
                        .criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET))
                        .group(MOD_NAME)
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return MOD_ID + "-recipe-provider";
    }
}
