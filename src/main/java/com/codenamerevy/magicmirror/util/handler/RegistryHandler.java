package com.codenamerevy.magicmirror.util.handler;

import com.codenamerevy.magicmirror.config.MagicMirrorsConfig;
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
        registerItems(event.getRegistry());
        if(MagicMirrorsConfig.CategoryDeveloper.enableLogger.get()) {
            Ref.LOGGER.info("Registered item(s)!");
        }
    }

    public static void registerItems (IForgeRegistry<Item> registry) {
        //Mirrors
        if (MagicMirrorsConfig.CategoryDeveloper.enableLogger.get()) {
            Ref.LOGGER.info("Registering Items under configuration enableMagicMirrors (" + MagicMirrorsConfig.CategoryGeneral.enableMagicMirrors.get().toString() + ")");
        }
            if (MagicMirrorsConfig.CategoryGeneral.enableMagicMirrors.get()) {

            registry.register(ItemInit.MAGIC_MIRROR);
            registry.register(ItemInit.ICE_MIRROR);
            registry.register(ItemInit.MAGIC_MIRROR_CARTOGRAPHER);
            registry.register(ItemInit.MAGIC_MIRROR_DESERT);
            registry.register(ItemInit.MAGIC_MIRROR_JUNGLE);
            registry.register(ItemInit.MAGIC_MIRROR_LIBRARY);
            registry.register(ItemInit.MAGIC_MIRROR_OCEAN);
        }

        //Dimensionals
        if (MagicMirrorsConfig.CategoryDeveloper.enableLogger.get()) {
            Ref.LOGGER.info("Registering Items under configuration enableDimensionalMirrors (" + MagicMirrorsConfig.CategoryGeneral.enableDimensionalMirrors.get().toString() + ")");
        }
        if (MagicMirrorsConfig.CategoryGeneral.enableDimensionalMirrors.get()) {
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
        if (MagicMirrorsConfig.CategoryDeveloper.enableLogger.get()) {
            Ref.LOGGER.info("Registering Items under configuration enableDimensionCrystal (" + MagicMirrorsConfig.CategoryGeneral.enableDimensionCrystal.get().toString() + ")");

        }
        if(MagicMirrorsConfig.CategoryGeneral.enableDimensionCrystal.get())
        {
            registry.register(ItemInit.DIMENSION_CRYSTAL);
        }

        //Ingredients
        if(MagicMirrorsConfig.CategoryDeveloper.enableLogger.get()) {
            Ref.LOGGER.info("Registering Items under configuration enableIngredients (" + MagicMirrorsConfig.CategoryGeneral.enableIngredients.get().toString() + ")");
        }
        if(MagicMirrorsConfig.CategoryGeneral.enableIngredients.get())
        {
            registry.register(ItemInit.BROKEN_MIRROR);
            registry.register(ItemInit.BROKEN_MIRROR_DIMENSIONAL);
            registry.register(ItemInit.ENCHANTED_MIRROR);
            registry.register(ItemInit.MIRROR_FRAME);
        }
    }
}
