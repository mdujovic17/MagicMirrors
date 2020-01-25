package com.codenamerevy.magicmirror.util.handler;

import com.codenamerevy.magicmirror.config.Config;
import com.codenamerevy.magicmirror.init.ItemInit;
import com.codenamerevy.magicmirror.util.Ref;
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
        registerMirrors(event.getRegistry());
        registerDimensionals(event.getRegistry());
        registerCrystals(event.getRegistry());
        registerIngredients(event.getRegistry());
    }

    public static void registerMirrors(IForgeRegistry<Item> registry)
    {
        registry.register(ItemInit.MAGIC_MIRROR);
        registry.register(ItemInit.ICE_MIRROR);
        registry.register(ItemInit.MAGIC_MIRROR_CARTOGRAPHER);
        registry.register(ItemInit.MAGIC_MIRROR_DESERT);
        registry.register(ItemInit.MAGIC_MIRROR_JUNGLE);
        registry.register(ItemInit.MAGIC_MIRROR_LIBRARY);
        registry.register(ItemInit.MAGIC_MIRROR_OCEAN);
    }
    public static void registerDimensionals(IForgeRegistry<Item> registry)
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

    public static void registerCrystals(IForgeRegistry<Item> registry)
    {
        registry.register(ItemInit.DIMENSION_CRYSTAL);
    }

    public static void registerIngredients(IForgeRegistry<Item> registry)
    {
        registry.register(ItemInit.ENCHANTED_MIRROR);
        registry.register(ItemInit.MIRROR_FRAME);
    }
}
