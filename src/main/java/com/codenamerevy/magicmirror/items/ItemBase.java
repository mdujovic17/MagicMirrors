package com.codenamerevy.magicmirror.items;

import com.codenamerevy.magicmirror.init.ItemInit;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

public class ItemBase extends Item
{

    public ItemBase(Properties properties)
    {
        super(properties);

        ItemInit.ITEMS.add(this);
    }
}
