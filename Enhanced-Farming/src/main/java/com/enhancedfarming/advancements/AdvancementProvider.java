package com.enhancedfarming.advancements;

import com.enhancedfarming.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static com.enhancedfarming.EnhancedFarming.MOD_ID;

public class AdvancementProvider extends FabricAdvancementProvider {

    // Advancements
    public static final String GET_FERTILIZER_TITLE = "text.enhanced-farming.get_fertilizer.title";
    public static final String GET_FERTILIZER_DESCRIPTION = "text.enhanced-farming.get_fertilizer.description";

    public AdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup registryLookup, Consumer<AdvancementEntry> consumer) {
        AdvancementEntry getFertilizer = Advancement.Builder.create()
                .display(
                        ModItems.FERTILIZER_ITEM,
                        Text.translatable(GET_FERTILIZER_TITLE), // Title
                        Text.translatable(GET_FERTILIZER_DESCRIPTION), // Description
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("got_fertilizer", InventoryChangedCriterion.Conditions.items(ModItems.FERTILIZER_ITEM))
                // Give the advancement an id
                .build(consumer, MOD_ID + ":get_fertilizer");
    }
}
