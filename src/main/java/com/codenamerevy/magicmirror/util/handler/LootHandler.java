package com.codenamerevy.magicmirror.util.handler;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.TableLootEntry;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.codenamerevy.magicmirror.util.Reference;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public final class LootHandler
{
    @SubscribeEvent
    public static void lootLoad(LootTableLoadEvent evt)
    {
        String prefix = "minecraft:chests/";
        String name = evt.getName().toString();

        if(name.startsWith(prefix))
        {
            String file = name.substring(name.indexOf(prefix) + prefix.length());
            switch(file)
            {
                case "abandoned_mineshaft":     //TODO: Add Loot Table
                case "desert_pyramid": evt.getTable().addPool(getInjectPool(file)); break;
                case "jungle_temple":           //TODO: Add Loot Table
                case "simple_dungeon":          //TODO: Add Loot Table
                case "spawn_bonus_chest":       //TODO: Add Loot Table
                case "stronghold_corridor":     //TODO: Add Loot Table
                case "village_blacksmith":      //TODO: ADD
                default: break;
            }
        }
    }

    private static LootPool getInjectPool(String entryName)
    {
        return LootPool.builder().addEntry(getInjectEntry(entryName, 1)).bonusRolls(0, 1).build();
    }

    private static LootEntry.Builder getInjectEntry(String name, int weight)
    {
        ResourceLocation table = new ResourceLocation(Reference.MODID, "inject/" + name);
        return TableLootEntry.builder(table).weight(weight);
    }
}
