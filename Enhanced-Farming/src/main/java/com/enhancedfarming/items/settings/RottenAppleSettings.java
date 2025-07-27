package com.enhancedfarming.items.settings;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class RottenAppleSettings {

    public static final ConsumableComponent POISON_FOOD_CONSUMABLE_COMPONENT = ConsumableComponent.builder()
            .consumeEffect(
                    new ApplyEffectsConsumeEffect(
                            new StatusEffectInstance(StatusEffects.POISON, 10),
                            1))
            .build();

    public static final FoodComponent POISON_FOOD_COMPONENT = new FoodComponent.Builder()
            .saturationModifier(2)
            .nutrition(4)
            .build();
}
