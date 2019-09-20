package com.codenamerevy.magicmirror.util.handler;

import com.codenamerevy.magicmirror.init.ItemInit;
import com.codenamerevy.magicmirror.util.Reference;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHandler
{
    @SubscribeEvent
    public static void onItemRegistry(final RegistryEvent.Register<Item> itemRegisterEvent)
    {
        for(Item item : ItemInit.ITEMS)
        {
            itemRegisterEvent.getRegistry().register(item);
        }
        Reference.LOGGER.info("Registered item(s)!");
    }

    /**@SubscribeEvent
    public void onRegisterSounds(RegistryEvent.Register<SoundEvent> event)
    {
        for(SoundEvent sound : SoundInit.SOUNDS)
        {
            event.getRegistry().register(sound);
        }
        Reference.LOGGER.info("Registered sound(s)!");
    }
    **/
}
