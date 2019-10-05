package com.codenamerevy.magicmirror.items;

import com.codenamerevy.magicmirror.init.ItemInit;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

public class ItemMirrorBase extends Item
{

    public ItemMirrorBase(Properties properties) {
        super(properties);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.RARE;
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
