package org.joloy.en_ex.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.joloy.en_ex.EnchantmentExtraction;

public class ModItems {

    public static final Item CRYSTALLITE= registerItem("crystallite",
            new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(EnchantmentExtraction.MOD_ID, name), item);
    }


    public static void register() {
        EnchantmentExtraction.LOGGER.debug("Registering items for: " + EnchantmentExtraction.MOD_ID);
    }
}
