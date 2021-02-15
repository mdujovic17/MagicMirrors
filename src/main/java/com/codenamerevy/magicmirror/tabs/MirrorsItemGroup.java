package com.codenamerevy.magicmirror.tabs;

import com.codenamerevy.magicmirror.init.ItemInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MirrorsItemGroup extends ItemGroup
{
    public MirrorsItemGroup(String label) {
        super(label);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemInit.MAGIC_MIRROR.get());
    }
}
