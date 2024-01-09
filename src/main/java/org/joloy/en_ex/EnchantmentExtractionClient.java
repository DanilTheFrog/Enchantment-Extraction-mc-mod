package org.joloy.en_ex;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import org.joloy.en_ex.screen.EnchantmentExtractionTableScreen;
import org.joloy.en_ex.screen.ModScreenHandlers;

public class EnchantmentExtractionClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ModScreenHandlers.ENCHANTMENT_EXTRACTION_TABLE_SCREEN_HANDLER,
                EnchantmentExtractionTableScreen::new);
    }
}
