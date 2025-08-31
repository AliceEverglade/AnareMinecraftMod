package com.aliceeverglade.anare.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent MYTHRIL_DONUT = new FoodComponent.Builder().nutrition(10).saturationModifier(1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED,200,2),1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,200,5),1f)
            .alwaysEdible().build();
}
