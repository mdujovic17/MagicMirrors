package com.codenamerevy.magicmirror.util.handler;

import com.codenamerevy.magicmirror.init.ParticleInit;
import com.codenamerevy.magicmirror.particle.MirrorParticle;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleFactoryHandler
{
    @SubscribeEvent
    public static void registerParticleTypes(ParticleFactoryRegisterEvent event)
    {
        Minecraft.getInstance().particles.registerFactory(ParticleInit.MIRROR_PARTICLE, MirrorParticle.Factory::new);
    }
}
