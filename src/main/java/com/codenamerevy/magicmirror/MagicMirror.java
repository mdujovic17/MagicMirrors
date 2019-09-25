package com.codenamerevy.magicmirror;

import com.codenamerevy.magicmirror.tabs.MirrorsItemGroup;
import com.codenamerevy.magicmirror.util.Reference;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MODID)
public class MagicMirror
{
    public static final ItemGroup MAGIC_MIRRORS = new MirrorsItemGroup("magic_mirrors");

    public MagicMirror()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup (final FMLCommonSetupEvent event) { }
}

