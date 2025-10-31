package net.davebalda.morestuff.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class RestorationWandItem extends Item {
    public RestorationWandItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if(world.isClient())
            return ActionResult.PASS;

        user.addStatusEffect(new StatusEffectInstance(
                StatusEffects.REGENERATION,
                200,
                1
        ));

        ItemStack itemStack = user.getStackInHand(hand);

        itemStack.damage(
                1,
                user
        );

        user.getItemCooldownManager().set(itemStack, 180);

        return ActionResult.SUCCESS;
    }


}
