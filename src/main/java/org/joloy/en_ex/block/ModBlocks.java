package org.joloy.en_ex.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.joloy.en_ex.EnchantmentExtraction;
import org.joloy.en_ex.block.custom.EnchantmentExtractionTable;
import org.joloy.en_ex.item.ModItemGroup;

public class ModBlocks {

    public static final Block ENCHANTMENT_EXTRACTION_TABLE = registerBlock("enchantment_extraction_table",
            new EnchantmentExtractionTable(FabricBlockSettings.of(Material.STONE).strength(6f)), ModItemGroup.MYTHRIL);


    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(EnchantmentExtraction.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(EnchantmentExtraction.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }
    public static void registerModBlocks() {
        EnchantmentExtraction.LOGGER.info("Registering ModBlocks for: " + EnchantmentExtraction.MOD_ID);
    }
}
