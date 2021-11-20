package net.fabricmc.example;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

public class FrostProtectionEnchantment extends Enchantment {

    @Override
    public int getProtectionAmount(int level, DamageSource source) {


        return super.getProtectionAmount(1, DamageSource.ON_FIRE);
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {

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
    protected FrostProtectionEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.ARMOR, new EquipmentSlot[] {EquipmentSlot.LEGS, EquipmentSlot.HEAD,EquipmentSlot.CHEST, EquipmentSlot.FEET });
    }
}
