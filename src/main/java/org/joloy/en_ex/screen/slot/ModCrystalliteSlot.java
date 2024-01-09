package org.joloy.en_ex.screen.slot;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import org.joloy.en_ex.item.ModItems;

public class ModCrystalliteSlot extends Slot {
    public ModCrystalliteSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return stack.isOf(ModItems.CRYSTALLITE);
    }
}
