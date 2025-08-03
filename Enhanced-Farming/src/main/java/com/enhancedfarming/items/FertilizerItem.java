package com.enhancedfarming.items;

import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;

import static net.minecraft.item.BoneMealItem.useOnFertilizable;
import static net.minecraft.item.BoneMealItem.useOnGround;

public class FertilizerItem extends Item {

    public static final String FERTILIZER_ITEM_NAME = "Fertilizer";
    public static final String FERTILIZER_TOOLTIP = "item.enhanced-farming.fertilizer.tooltip";

    public FertilizerItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockPos blockPos2 = blockPos.offset(context.getSide());

        if (useOnFertilizable(context.getStack(), world, blockPos)) {
            if (!world.isClient) {
                context.getPlayer().emitGameEvent(GameEvent.ITEM_INTERACT_FINISH);
                world.syncWorldEvent(WorldEvents.BONE_MEAL_USED, blockPos, 15);
            }

            return ActionResult.SUCCESS;
        } else {
            BlockState blockState = world.getBlockState(blockPos);
            boolean bl = blockState.isSideSolidFullSquare(world, blockPos, context.getSide());
            if (bl && useOnGround(context.getStack(), world, blockPos2, context.getSide())) {
                if (!world.isClient) {
                    context.getPlayer().emitGameEvent(GameEvent.ITEM_INTERACT_FINISH);
                    world.syncWorldEvent(WorldEvents.BONE_MEAL_USED, blockPos2, 15);
                }

                return ActionResult.SUCCESS;
            } else {
                return ActionResult.PASS;
            }
        }
    }
}