package com.codenamerevy.magicmirror.client.particle;

import com.codenamerevy.magicmirror.init.ParticleInit;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ParticleHandler {

	@SubscribeEvent
	public static void registerParticleFactory(ParticleFactoryRegisterEvent event)
	{
		Minecraft.getInstance().particles.registerFactory(ParticleInit.MIRROR_PARTICLE.get(), MirrorParticle.Factory::new);
	}
}
