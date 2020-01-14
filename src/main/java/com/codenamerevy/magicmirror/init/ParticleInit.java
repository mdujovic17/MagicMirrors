package com.codenamerevy.magicmirror.init;

import com.codenamerevy.magicmirror.util.Ref;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Ref.MODID)
public class ParticleInit
{
    public static final BasicParticleType MIRROR_PARTICLE = createBasicParticleType(false, "mirror_particle");

    private static BasicParticleType createBasicParticleType(boolean alwaysShow, String name) {
        BasicParticleType particleType = new BasicParticleType(alwaysShow);
        particleType.setRegistryName(Ref.MODID, name);
        return particleType;
    }
}
