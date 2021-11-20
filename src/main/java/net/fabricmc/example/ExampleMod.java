package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.example.CreeperHeartItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("MyFirstModAttempt");
	private static final Item CREEPER_HEART = new CreeperHeartItem(new Item.Settings().group(ItemGroup.BREWING).maxCount(16));
	private static final Enchantment CUSTOM_ENCHANT_ONE = new CustomEnchant_one(Enchantment.Rarity.RARE,
			EnchantmentTarget.ARMOR_CHEST,
			new EquipmentSlot[] {EquipmentSlot.CHEST, EquipmentSlot.MAINHAND});

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM , new Identifier("mymod", "creeper_heart"), CREEPER_HEART);
		Registry.register(Registry.ENCHANTMENT,new Identifier("mymod","frosty_defender"),CUSTOM_ENCHANT_ONE );
		Registry.register(Registry.ENCHANTMENT, new Identifier("mymod", "frost_protection"), new FrostProtectionEnchantment());
		Registry.register(Registry.ITEM , new Identifier("mymod", "throwable_slime_ball"), new ThrowableSlimeBall());

		LOGGER.info("Hello Fabric world!");
	}
}
