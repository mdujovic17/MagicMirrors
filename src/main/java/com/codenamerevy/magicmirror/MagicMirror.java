package com.codenamerevy.magicmirror;

import com.codenamerevy.magicmirror.config.Config;
import com.codenamerevy.magicmirror.init.ItemInit;
import com.codenamerevy.magicmirror.tabs.MirrorsItemGroup;
import com.codenamerevy.magicmirror.util.handler.*;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MagicMirror.MODID)
public class MagicMirror
{
    public static final String MODID = "magicmirror";
    public static final Logger LOGGER = LogManager.getLogger();

    public static final ItemGroup MAGIC_MIRRORS = new MirrorsItemGroup("magic_mirrors");

    public MagicMirror()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);

        ItemInit.ITEMS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public void commonSetup (final FMLCommonSetupEvent event)
    {
        MinecraftForge.EVENT_BUS.register(EventHandler.class);
    }

    @SubscribeEvent
    public void clientSetup(final FMLClientSetupEvent event)
    {
        MinecraftForge.EVENT_BUS.register(SoundHandler.class);
        MinecraftForge.EVENT_BUS.register(ParticleHandler.class);
        MinecraftForge.EVENT_BUS.register(ParticleFactoryHandler.class);
    }
}

