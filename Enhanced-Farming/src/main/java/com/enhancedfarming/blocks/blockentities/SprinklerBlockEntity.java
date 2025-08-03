package com.enhancedfarming.blocks.blockentities;

import com.enhancedfarming.blocks.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;

public class SprinklerBlockEntity extends BlockEntity {
    private boolean isOn = false;



    public SprinklerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SPRINKLER_BLOCK_ENTITY, pos, state);
    }


    public boolean isOn() {
        return isOn;
    }

    public void setOn() {
        isOn = !isOn;
        markDirty();
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {

    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {

    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registries) {
        return createNbt(registries);
    }
}