package com.codenamerevy.magicmirror.util.handler;

import com.codenamerevy.magicmirror.init.ParticleInit;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleHandler
{
    @SubscribeEvent
    public static void registerParticleTypes(RegistryEvent.Register<ParticleType<?>> event)
    {
        event.getRegistry().registerAll(ParticleInit.MIRROR_PARTICLE);
    }
}
