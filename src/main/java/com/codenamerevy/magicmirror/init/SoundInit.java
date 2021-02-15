package com.codenamerevy.magicmirror.init;

import com.codenamerevy.magicmirror.MagicMirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit
{
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MagicMirror.MODID);

    public static final RegistryObject<SoundEvent> TELEPORT = SOUNDS.register("teleport", () -> new SoundEvent(new ResourceLocation(MagicMirror.MODID, "teleport")));
    public static final RegistryObject<SoundEvent> MIRROR_DISCHARGE = SOUNDS.register("mirror_discharge", () -> new SoundEvent(new ResourceLocation(MagicMirror.MODID, "mirror_discharge")));
}
