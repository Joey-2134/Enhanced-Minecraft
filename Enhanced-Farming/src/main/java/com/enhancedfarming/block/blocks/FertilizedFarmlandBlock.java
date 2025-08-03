package com.enhancedfarming.block.blocks;

import net.minecraft.block.FarmlandBlock;
import net.minecraft.util.Identifier;

import static com.enhancedfarming.EnhancedFarming.MOD_ID;

public class FertilizedFarmlandBlock extends FarmlandBlock {

    public static final String NAME = "Fertilized Farmland";
    public static final String KEY = "fertilized_farmland";
    public static final Identifier IDENTIFIER = Identifier.of(MOD_ID, KEY);

    public FertilizedFarmlandBlock(Settings settings) {
        super(settings);
    }
}