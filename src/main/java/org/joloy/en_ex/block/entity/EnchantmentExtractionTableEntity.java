package org.joloy.en_ex.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.joloy.en_ex.item.ModItems;
import org.joloy.en_ex.item.inventory.ImplementedInventory;
import org.joloy.en_ex.screen.EnchantmentExtractionTableScreenHandler;

import java.util.Map;

public class EnchantmentExtractionTableEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {

    public static final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(5, ItemStack.EMPTY);

    public EnchantmentExtractionTableEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ENCHANTMENT_EXTRACTION_TABLE, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return new LiteralText("Enchantment Extracting");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new EnchantmentExtractionTableScreenHandler(syncId, inv, this);
    }


    @Override
    protected void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inventory);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
    }

    public static void tick(World world, BlockPos pos, BlockState state, EnchantmentExtractionTableEntity entity) {
        if(hasRecipe(entity) && hasNotReachedStackLimit(entity)) {
            craftItem(entity);
        }
    }


    private static void craftItem(EnchantmentExtractionTableEntity entity) {
        ItemStack inputItem = entity.getStack(0);

        StringBuilder data = new StringBuilder();
        Map<Enchantment, Integer> enchantments = EnchantmentHelper.get(inputItem);

        EnchantmentLevelEntry extracted = null;

        for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
            extracted = new EnchantmentLevelEntry(entry.getKey(), entry.getValue());
            enchantments.remove(entry.getKey());
            break;
        }
        if(extracted == null) return;


        EnchantmentHelper.set(enchantments, inputItem);
        ItemStack resultItem = inputItem.copy();

        entity.removeStack(0, 1);
        entity.removeStack(1, 1);
        entity.removeStack(2, 1);
        entity.setStack(3, resultItem);

        ItemStack resulBook = new ItemStack(Items.ENCHANTED_BOOK);
        EnchantedBookItem.addEnchantment(resulBook, extracted);
        entity.setStack(4, resulBook);

    }

    private static boolean hasRecipe(EnchantmentExtractionTableEntity entity) {
        boolean hasItemInFirstSlot = !entity.getStack(0).isEmpty() &&
                entity.getStack(0).getItem() != Items.ENCHANTED_BOOK;
        boolean hasItemInSecondSlot = entity.getStack(1).getItem() == ModItems.CRYSTALLITE;
        boolean hasItemInThirdSlot = entity.getStack(2).getItem() == Items.BOOK;

        return hasItemInFirstSlot && hasItemInSecondSlot && hasItemInThirdSlot;
    }

    private static boolean hasNotReachedStackLimit(EnchantmentExtractionTableEntity entity) {
        return entity.getStack(3).getCount() < entity.getStack(3).getMaxCount() &&
                entity.getStack(4).getCount() < entity.getStack(4).getMaxCount();
    }
}
