package net.fabricmc.example;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CreeperHeartItem extends Item {
    public CreeperHeartItem (Settings settings)
    {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(hand == Hand.OFF_HAND)
        {

            System.out.println("SSSSSSS");
        }

        return super.use(world, user, hand);
    }
}
