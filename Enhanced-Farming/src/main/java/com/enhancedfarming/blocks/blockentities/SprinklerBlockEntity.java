package com.enhancedfarming.blocks.blockentities;

import com.enhancedfarming.blocks.ModBlockEntities;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.math.BlockPos;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.animatable.processing.AnimationController;
import software.bernie.geckolib.animatable.processing.AnimationTest;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class SprinklerBlockEntity extends BlockEntity implements GeoBlockEntity {
    private boolean isOn = false;

    protected static final RawAnimation DEPLOY_ANIM = RawAnimation.begin().thenLoop("animation");
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

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
    protected void writeData(WriteView view) {
        view.put("isOn", Codec.BOOL, isOn);
        super.writeData(view);
    }

    @Override
    protected void readData(ReadView view) {
        super.readData(view);
        isOn = view.getBoolean("isOn", false);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registries) {
        return createNbt(registries);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this::deployAnimController));
    }

    private PlayState deployAnimController(AnimationTest<GeoAnimatable> geoAnimatableAnimationTest) {
        return geoAnimatableAnimationTest.setAndContinue(DEPLOY_ANIM);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}