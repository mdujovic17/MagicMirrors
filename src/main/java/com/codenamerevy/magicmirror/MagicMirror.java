package com.codenamerevy.magicmirror;

import com.codenamerevy.magicmirror.config.Config;
import com.codenamerevy.magicmirror.tabs.MirrorsItemGroup;
import com.codenamerevy.magicmirror.util.Ref;
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

@Mod(Ref.MODID)
public class MagicMirror
{
    public static final ItemGroup MAGIC_MIRRORS = new MirrorsItemGroup("magic_mirrors");

    public MagicMirror()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public void commonSetup (final FMLCommonSetupEvent event)
    {
        MinecraftForge.EVENT_BUS.register(RegistryHandler.class);
        MinecraftForge.EVENT_BUS.register(EventHandler.class);
        MinecraftForge.EVENT_BUS.register(LootHandler.class);
    }

    @SubscribeEvent
    public void clientSetup(final FMLClientSetupEvent event)
    {
        MinecraftForge.EVENT_BUS.register(SoundHandler.class);
        MinecraftForge.EVENT_BUS.register(ParticleHandler.class);
        MinecraftForge.EVENT_BUS.register(ParticleFactoryHandler.class);
    }
}

