package com.codenamerevy.magicmirror;

import com.codenamerevy.magicmirror.client.particle.MirrorParticle;
import com.codenamerevy.magicmirror.client.particle.ParticleHandler;
import com.codenamerevy.magicmirror.config.Config;
import com.codenamerevy.magicmirror.init.ItemInit;
import com.codenamerevy.magicmirror.init.ParticleInit;
import com.codenamerevy.magicmirror.init.SoundInit;
import com.codenamerevy.magicmirror.tabs.MirrorsItemGroup;
import com.codenamerevy.magicmirror.util.handler.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.IAnimatedSprite;
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

import java.awt.*;

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

        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::commonSetup);

        ItemInit.ITEMS.register(eventBus);

        eventBus.addListener(ParticleHandler::registerParticleFactory);
        ParticleInit.PARTICLES.register(eventBus);
        SoundInit.SOUNDS.register(eventBus);

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

    }
}

