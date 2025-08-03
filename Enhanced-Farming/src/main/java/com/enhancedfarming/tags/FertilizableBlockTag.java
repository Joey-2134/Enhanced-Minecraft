package com.enhancedfarming.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static com.enhancedfarming.EnhancedFarming.MOD_ID;

public class FertilizableBlockTag extends FabricTagProvider<Block> {
    public static final TagKey<Block> FERTILIZABLE_BLOCKS = TagKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, "fertilizable_blocks"));

    public FertilizableBlockTag(FabricDataOutput output, RegistryKey<? extends Registry<Block>> registryKey, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registryKey, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getTagBuilder(FERTILIZABLE_BLOCKS)
                .add(Identifier.ofVanilla("farmland"));
    }
}