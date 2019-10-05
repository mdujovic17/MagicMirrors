package com.codenamerevy.magicmirror.init;

import com.codenamerevy.magicmirror.MagicMirror;
import com.codenamerevy.magicmirror.items.ItemBase;
import com.codenamerevy.magicmirror.items.ItemDimensionalMirror;
import com.codenamerevy.magicmirror.items.ItemMagicMirror;
import com.codenamerevy.magicmirror.items.ItemMirrorBase;
import com.codenamerevy.magicmirror.util.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class ItemInit
{
    public static final List<Item> ITEMS = new ArrayList<Item>();

    //Regular Mirrors
    public static final Item MAGIC_MIRROR = new ItemMagicMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("magic_mirror"));
    public static final Item ICE_MIRROR = new ItemMagicMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("ice_mirror"));
    public static final Item MAGIC_MIRROR_JUNGLE = new ItemMagicMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("magic_mirror_jungle"));
    public static final Item MAGIC_MIRROR_DESERT = new ItemMagicMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("magic_mirror_desert"));
    public static final Item MAGIC_MIRROR_OCEAN = new ItemMagicMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("magic_mirror_ocean"));
    public static final Item MAGIC_MIRROR_CARTOGRAPHER = new ItemMagicMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("magic_mirror_cartographer"));
    //public static final Item MAGIC_MIRROR_MANSION = new ItemMagicMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("magic_mirror_mansion"));
    public static final Item MAGIC_MIRROR_LIBRARY = new ItemMagicMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("magic_mirror_library"));

    //Dimensional Mirrors
    public static final Item DIMENSIONAL_MIRROR = new ItemDimensionalMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("dimensional_mirror"));
    public static final Item DIMENSIONAL_MIRROR_ICE = new ItemDimensionalMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("dimensional_mirror_ice"));
    public static final Item DIMENSIONAL_MIRROR_JUNGLE = new ItemDimensionalMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("dimensional_mirror_jungle"));
    public static final Item DIMENSIONAL_MIRROR_DESERT = new ItemDimensionalMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("dimensional_mirror_desert"));
    public static final Item DIMENSIONAL_MIRROR_OCEAN = new ItemDimensionalMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("dimensional_mirror_ocean"));
    public static final Item DIMENSIONAL_MIRROR_CARTOGRAPHER = new ItemDimensionalMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("dimensional_mirror_cartographer"));
    //No idea for mansion textures and already 8 mirror versions, probably going to remove this in the future.
    //public static final Item DIMENSIONAL_MIRROR_MANSION = new ItemDimensionalMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("dimensional_mirror_mansion"));
    public static final Item DIMENSIONAL_MIRROR_LIBRARY = new ItemDimensionalMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("dimensional_mirror_library"));
    public static final Item DIMENSIONAL_MIRROR_END = new ItemDimensionalMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("dimensional_mirror_end"));

    //Materials
    public static final Item DIMENSION_CRYSTAL = new ItemBase(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS)).setRegistryName(location("dimension_crystal"));
    /**
     * TODO: Add Config files
     * - Add Textures
     * - Add to creative tab
     * - With this method, only the main magic mirror can be crafted
     * **/
    public static final Item MIRROR_FRAME = new ItemBase(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS)).setRegistryName(location("mirror_frame"));
    public static final Item ENCHANTED_MIRROR = new ItemMirrorBase(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS)).setRegistryName(location("enchanted_mirror"));
    public static final Item BROKEN_MIRROR = new ItemBase(new Item.Properties()).setRegistryName(location("broken_mirror"));
    public static final Item BROKEN_MIRROR_DIMENSIONAL = new ItemBase(new Item.Properties()).setRegistryName(location("broken_mirror_dimensional"));

    private static ResourceLocation location(String name)
    {
        return new ResourceLocation(Reference.MODID, name);
    }
}
