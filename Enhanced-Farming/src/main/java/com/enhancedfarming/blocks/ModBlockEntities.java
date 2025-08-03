package com.enhancedfarming.blocks;

import com.enhancedfarming.blocks.blockentities.SprinklerBlockEntity;
import com.enhancedfarming.blocks.blocks.Sprinkler;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.enhancedfarming.EnhancedFarming.MOD_ID;

public class ModBlockEntities {

    public static final BlockEntityType<SprinklerBlockEntity> SPRINKLER_BLOCK_ENTITY = register(
            Sprinkler.SPRINKLER_BLOCK_IDENTIFIER,
            SprinklerBlockEntity::new,
            ModBlocks.SPRINKLER
    );

    private static <T extends BlockEntity> BlockEntityType<T> register(
            String name,
            FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory,
            Block... blocks
    ) {
        Identifier id = Identifier.of(MOD_ID, name);
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }

    public static void initialize() {}
}
