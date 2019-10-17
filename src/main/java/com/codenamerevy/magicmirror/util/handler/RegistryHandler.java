package com.codenamerevy.magicmirror.util.handler;

import com.codenamerevy.magicmirror.config.ItemConfig;
import com.codenamerevy.magicmirror.init.ItemInit;
import com.codenamerevy.magicmirror.util.Reference;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHandler
{
    @SubscribeEvent
    public static void onItemRegistry(final RegistryEvent.Register<Item> event)
    {
        registerItems(event.getRegistry());
        Reference.LOGGER.info("Registered item(s)!");
    }

    public static void registerItems (IForgeRegistry<Item> registry)
    {
        //Mirrors
        if(ItemConfig.enableMagicMirrors.get())
        {
            registry.register(ItemInit.MAGIC_MIRROR);
            registry.register(ItemInit.ICE_MIRROR);
            registry.register(ItemInit.MAGIC_MIRROR_CARTOGRAPHER);
            registry.register(ItemInit.MAGIC_MIRROR_DESERT);
            registry.register(ItemInit.MAGIC_MIRROR_JUNGLE);
            registry.register(ItemInit.MAGIC_MIRROR_LIBRARY);
            registry.register(ItemInit.MAGIC_MIRROR_OCEAN);
        }

        //Dimensionals
        if(ItemConfig.enableDimensionalMirrors.get())
        {
            registry.register(ItemInit.DIMENSIONAL_MIRROR);
            registry.register(ItemInit.DIMENSIONAL_MIRROR_ICE);
            registry.register(ItemInit.DIMENSIONAL_MIRROR_CARTOGRAPHER);
            registry.register(ItemInit.DIMENSIONAL_MIRROR_DESERT);
            registry.register(ItemInit.DIMENSIONAL_MIRROR_JUNGLE);
            registry.register(ItemInit.DIMENSIONAL_MIRROR_LIBRARY);
            registry.register(ItemInit.DIMENSIONAL_MIRROR_OCEAN);
            registry.register(ItemInit.DIMENSIONAL_MIRROR_END);
        }

        //Dimension Crystal
        if(ItemConfig.enableDimensionCrystal.get())
        {
            registry.register(ItemInit.DIMENSION_CRYSTAL);
        }

        //Ingredients
        if(ItemConfig.enableIngredients.get())
        {
            registry.register(ItemInit.BROKEN_MIRROR);
            registry.register(ItemInit.BROKEN_MIRROR_DIMENSIONAL);
            registry.register(ItemInit.ENCHANTED_MIRROR);
            registry.register(ItemInit.MIRROR_FRAME);
        }
    }
}
