package org.joloy.en_ex.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.joloy.en_ex.EnchantmentExtraction;

public class ModItemGroup {
    public static final ItemGroup MYTHRIL = FabricItemGroupBuilder.build(
            new Identifier(EnchantmentExtraction.MOD_ID, "enex"),
            () -> new ItemStack(ModItems.CRYSTALLITE)
    );
}
