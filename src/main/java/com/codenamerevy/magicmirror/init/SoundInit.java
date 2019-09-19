package com.codenamerevy.magicmirror.init;

import com.codenamerevy.magicmirror.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

import java.util.ArrayList;
import java.util.List;

public class SoundInit
{
    public static final List<SoundEvent> SOUNDS = new ArrayList<SoundEvent>();

    public static final SoundEvent SOUND_TELEPORT = new SoundEvent(location("teleport")).setRegistryName("teleport");

    private static ResourceLocation location(String name)
    {
        return new ResourceLocation(Reference.MODID, name);
    }
}
