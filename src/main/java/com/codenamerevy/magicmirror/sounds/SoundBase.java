package com.codenamerevy.magicmirror.sounds;

import com.codenamerevy.magicmirror.init.SoundInit;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class SoundBase extends SoundEvent
{

    public SoundBase(ResourceLocation name) {
        super(name);

        SoundInit.SOUNDS.add(this);
    }
}
