package org.joloy.en_ex.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.joloy.en_ex.EnchantmentExtraction;

public class ModEnchantments {


    public static Enchantment LIGHTNING_STRIKER = register("lightning_striker",
            new LightningStrikerEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(EnchantmentExtraction.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantment() {
        System.out.println("Registering Enchantments for " + EnchantmentExtraction.MOD_ID);
    }
}
