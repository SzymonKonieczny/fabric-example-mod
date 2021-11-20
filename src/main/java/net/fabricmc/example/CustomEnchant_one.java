package net.fabricmc.example;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

import java.util.Random;

public class CustomEnchant_one extends Enchantment {
    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {

       if(attacker instanceof  LivingEntity)
       {
           ((LivingEntity) attacker).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,20*level*2,level));
           Random random = new Random();
           int random_value = random.nextInt(100);
           if(random_value >50) ((LivingEntity) attacker).addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER,20*level*2,level*10));
           ((LivingEntity) attacker).takeKnockback(1, user.getPos().x-attacker.getPos().x  , user.getPos().z - attacker.getPos().z);
       }
        super.onUserDamaged(user, attacker, level);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public int getMaxPower(int level) {
        return 30;
    }

    @Override
    public int getMinPower(int level) {
        return level * 2;
    }



    protected CustomEnchant_one(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {



        super(weight, type, slotTypes);
    }
}
