package com.codenamerevy.magicmirror.init;

import com.codenamerevy.magicmirror.items.ItemMagicMirror;
import com.codenamerevy.magicmirror.util.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class ItemInit
{
    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static final Item MAGIC_MIRROR = new ItemMagicMirror(new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("magic_mirror"));

    private static ResourceLocation location(String name)
    {
        return new ResourceLocation(Reference.MODID, name);
    }
}
