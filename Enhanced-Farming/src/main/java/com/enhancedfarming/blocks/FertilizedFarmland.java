package com.enhancedfarming.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.util.Identifier;

import static com.enhancedfarming.EnhancedFarming.MOD_ID;

public class FertilizedFarmland extends FarmlandBlock {
    public final static Identifier ID = Identifier.of(MOD_ID, "fertilized_farmland");

    public FertilizedFarmland(AbstractBlock.Settings settings) {
        super(settings);
    }
}