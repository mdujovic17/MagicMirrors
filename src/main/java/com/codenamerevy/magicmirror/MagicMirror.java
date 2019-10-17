package com.codenamerevy.magicmirror;

import com.codenamerevy.magicmirror.config.ItemConfig;
import com.codenamerevy.magicmirror.tabs.MirrorsItemGroup;
import com.codenamerevy.magicmirror.util.Reference;
import com.codenamerevy.magicmirror.util.handler.EventHandler;
import com.codenamerevy.magicmirror.util.handler.LootHandler;
import com.codenamerevy.magicmirror.util.handler.RegistryHandler;
import com.codenamerevy.magicmirror.util.handler.SoundHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(Reference.MODID)
public class MagicMirror
{
    public static final ItemGroup MAGIC_MIRRORS = new MirrorsItemGroup("magic_mirrors");

    public MagicMirror()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        MinecraftForge.EVENT_BUS.addListener(LootHandler::onLootTableLoad);
        MinecraftForge.EVENT_BUS.addListener(EventHandler::registerRecipeSerializers);
        MinecraftForge.EVENT_BUS.addListener(RegistryHandler::onItemRegistry);
        MinecraftForge.EVENT_BUS.addListener(SoundHandler::registerSounds);

        MinecraftForge.EVENT_BUS.register(this);

        ItemConfig.loadConfig(ItemConfig.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("magicmirrors-items.toml"));
    }

    private void setup (final FMLCommonSetupEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new LootHandler());
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        MinecraftForge.EVENT_BUS.register(new RegistryHandler());
        MinecraftForge.EVENT_BUS.register(new SoundHandler());
    }

    public static ResourceLocation getId(String path) {
        return new ResourceLocation(Reference.MODID, path);
    }
}

