package org.joloy.en_ex;

import net.fabricmc.api.ModInitializer;
import org.joloy.en_ex.block.ModBlocks;
import org.joloy.en_ex.block.entity.ModBlockEntities;
import org.joloy.en_ex.enchantment.ModEnchantments;
import org.joloy.en_ex.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnchantmentExtraction implements ModInitializer {
	public static final String MOD_ID = "en_ex";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.register();
		ModBlocks.registerModBlocks();
		ModEnchantments.registerModEnchantment();
		ModBlockEntities.registerAllBlockEntities();
	}
}
