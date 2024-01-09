package org.joloy.en_ex.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import org.joloy.en_ex.EnchantmentExtraction;

public class ModScreenHandlers {

    public static ScreenHandlerType<EnchantmentExtractionTableScreenHandler> ENCHANTMENT_EXTRACTION_TABLE_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(
                    new Identifier(EnchantmentExtraction.MOD_ID, "enchantment_extraction_table"),
                    EnchantmentExtractionTableScreenHandler::new);
}
