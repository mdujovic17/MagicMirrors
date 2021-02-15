package com.codenamerevy.magicmirror.init;

import com.codenamerevy.magicmirror.MagicMirror;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

public class ParticleInit
{
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, MagicMirror.MODID);

    public static final RegistryObject<BasicParticleType> MIRROR_PARTICLE = PARTICLES.register("mirror_particle", () -> new BasicParticleType(false));
}
