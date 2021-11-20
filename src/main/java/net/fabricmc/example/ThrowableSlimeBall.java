package net.fabricmc.example;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ThrowableSlimeBall extends Item {


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if(!world.isClient)
        {
            ThrowableSlimeballEntity slimeballEntity = new ThrowableSlimeballEntity(world, user);
            slimeballEntity.setItem(itemStack);
            slimeballEntity.setProperties(user, user.getPitch(), user.getYaw(), 0.0f, 2f, 0.1f);
            world.spawnEntity(slimeballEntity);
        }
        itemStack.decrement(1);


        return super.use(world, user, hand);
    }

    public ThrowableSlimeBall() {
        super(new Settings().group(ItemGroup.COMBAT).maxCount(16));
    }

}
