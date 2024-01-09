package org.joloy.en_ex.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.joloy.en_ex.EnchantmentExtraction;
import org.joloy.en_ex.block.ModBlocks;

public class ModBlockEntities {
    public static BlockEntityType<EnchantmentExtractionTableEntity> ENCHANTMENT_EXTRACTION_TABLE;

    public static void registerAllBlockEntities() {

        ENCHANTMENT_EXTRACTION_TABLE = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(EnchantmentExtraction.MOD_ID, "enchantment_extraction_table"),
                FabricBlockEntityTypeBuilder.create(EnchantmentExtractionTableEntity::new,
                        ModBlocks.ENCHANTMENT_EXTRACTION_TABLE).build(null));
    }

}
