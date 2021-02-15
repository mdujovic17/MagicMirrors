package com.codenamerevy.magicmirror.init;

import com.codenamerevy.magicmirror.MagicMirror;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(MagicMirror.MODID)
public class ParticleInit
{
    public static final BasicParticleType MIRROR_PARTICLE = createBasicParticleType(false, "mirror_particle");

    private static BasicParticleType createBasicParticleType(boolean alwaysShow, String name) {
        BasicParticleType particleType = new BasicParticleType(alwaysShow);
        particleType.setRegistryName(MagicMirror.MODID, name);
        return particleType;
    }
}
