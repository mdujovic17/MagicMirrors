/*MIT License

Copyright (c) 2021 Marko Dujović

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.*/

package com.codenamerevy.magicmirror.init;

import com.codenamerevy.magicmirror.MagicMirror;
import com.codenamerevy.magicmirror.content.items.ItemDimensionalMirror;
import com.codenamerevy.magicmirror.content.items.ItemMagicMirror;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit
{
    //Switched to deferred registers
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MagicMirror.MODID);

    public static final RegistryObject<Item> MAGIC_MIRROR = ITEMS.register("magic_mirror", () -> new ItemMagicMirror(new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> DIMENSIONAL_MIRROR = ITEMS.register("dimensional_mirror", () -> new ItemDimensionalMirror( new Item.Properties().group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> MIRROR_FRAME = ITEMS.register("mirror_frame", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> DIMENSION_CRYSTAL = ITEMS.register("dimension_crystal", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> ENCHANTED_MIRROR = ITEMS.register("enchanted_mirror", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

//    //Regular Mirrors
//    public static final Item MAGIC_MIRROR = new ItemMagicMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("magic_mirror"));
//    public static final Item ICE_MIRROR = new ItemMagicMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("ice_mirror"));
//    public static final Item MAGIC_MIRROR_JUNGLE = new ItemMagicMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("magic_mirror_jungle"));
//    public static final Item MAGIC_MIRROR_DESERT = new ItemMagicMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("magic_mirror_desert"));
//    public static final Item MAGIC_MIRROR_OCEAN = new ItemMagicMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("magic_mirror_ocean"));
//    public static final Item MAGIC_MIRROR_CARTOGRAPHER = new ItemMagicMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("magic_mirror_cartographer"));
//    public static final Item MAGIC_MIRROR_LIBRARY = new ItemMagicMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("magic_mirror_library"));
//
//    //Dimensional Mirrors
//    public static final Item DIMENSIONAL_MIRROR = new ItemDimensionalMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("dimensional_mirror"));
//    public static final Item DIMENSIONAL_MIRROR_ICE = new ItemDimensionalMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("dimensional_mirror_ice"));
//    public static final Item DIMENSIONAL_MIRROR_JUNGLE = new ItemDimensionalMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("dimensional_mirror_jungle"));
//    public static final Item DIMENSIONAL_MIRROR_DESERT = new ItemDimensionalMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("dimensional_mirror_desert"));
//    public static final Item DIMENSIONAL_MIRROR_OCEAN = new ItemDimensionalMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("dimensional_mirror_ocean"));
//    public static final Item DIMENSIONAL_MIRROR_CARTOGRAPHER = new ItemDimensionalMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("dimensional_mirror_cartographer"));
//    public static final Item DIMENSIONAL_MIRROR_LIBRARY = new ItemDimensionalMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("dimensional_mirror_library"));
//    public static final Item DIMENSIONAL_MIRROR_END = new ItemDimensionalMirror(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS).maxStackSize(1)).setRegistryName(location("dimensional_mirror_end"));
//
//    //Materials
//    public static final Item DIMENSION_CRYSTAL = new Item(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS)).setRegistryName(location("dimension_crystal"));
//
//    public static final Item MIRROR_FRAME = new Item(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS)).setRegistryName(location("mirror_frame"));
//    public static final Item ENCHANTED_MIRROR = new Item(new Item.Properties().group(MagicMirror.MAGIC_MIRRORS)).setRegistryName(location("enchanted_mirror"));
//    public static final Item BROKEN_MIRROR = new Item(new Item.Properties()).setRegistryName(location("broken_mirror"));
//    public static final Item BROKEN_MIRROR_DIMENSIONAL = new Item(new Item.Properties()).setRegistryName(location("broken_mirror_dimensional"));
//
//    private static ResourceLocation location(String name)
//    {
//        return new ResourceLocation(Ref.MODID, name);
//    }
}
