package chai.divinen.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class ModFoodComponents {
    // Food Items setup
    public static final FoodComponent DIVINE_FOOD_COMPONENT = new FoodComponent.Builder().alwaysEdible().build();
    public static final ConsumableComponent AMBROSIA_COMPONENT = ConsumableComponents.drink()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 6 * 20, 1), 1.0f))
            .build();
}
