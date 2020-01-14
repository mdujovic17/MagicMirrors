package com.codenamerevy.magicmirror;

import com.codenamerevy.magicmirror.config.MagicMirrorsConfig;
import com.codenamerevy.magicmirror.init.ParticleInit;
import com.codenamerevy.magicmirror.tabs.MirrorsItemGroup;
import com.codenamerevy.magicmirror.util.Ref;
import com.codenamerevy.magicmirror.util.handler.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
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

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, MagicMirrorsConfig.SERVER_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MagicMirrorsConfig.COMMON_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, MagicMirrorsConfig.CLIENT_CONFIG);

    }
    @SubscribeEvent
    public void commonSetup (final FMLCommonSetupEvent event)
    {
        if(MagicMirrorsConfig.CategoryDeveloper.enableLogger.get()) {
            Ref.LOGGER.info("Doing Common Setup!");
        }
        MinecraftForge.EVENT_BUS.register(RegistryHandler.class);
        MinecraftForge.EVENT_BUS.register(SoundHandler.class);
        MinecraftForge.EVENT_BUS.register(EventHandler.class);
        MinecraftForge.EVENT_BUS.register(LootHandler.class);
    }

    @SubscribeEvent
    public void clientSetup(final FMLClientSetupEvent event)
    {
        if(MagicMirrorsConfig.CategoryDeveloper.enableLogger.get()) {
            Ref.LOGGER.info("Doing Client Setup!");
            Ref.LOGGER.info("STARTING MAGICMIRRORS MOD LOADING. IF YOU ARE NOT A DEVELOPER, PLEASE DISABLE INTERNAL LOGGING IN CONFIG");
        }
        MinecraftForge.EVENT_BUS.register(ParticleHandler.class);
        MinecraftForge.EVENT_BUS.register(ParticleFactoryHandler.class);
    }
}

