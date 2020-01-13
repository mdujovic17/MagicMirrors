package com.codenamerevy.magicmirror.util.handler;

import com.codenamerevy.magicmirror.config.MagicMirrorsConfig;
import com.codenamerevy.magicmirror.util.Ref;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import static com.codenamerevy.magicmirror.init.SoundInit.TELEPORT;
import static com.codenamerevy.magicmirror.init.SoundInit.MIRROR_DISCHARGE;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SoundHandler
{
    @SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> event)
    {
        TELEPORT = registerSound("teleport");
        MIRROR_DISCHARGE = registerSound("mirror_discharge");
        if (MagicMirrorsConfig.CategoryDeveloper.enableLogger.get()) {
            Ref.LOGGER.info("Registered sound(s)!");
        }
    }

    private static SoundEvent registerSound(String name)
    {
        ResourceLocation location = new ResourceLocation(Ref.MODID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(location);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}
