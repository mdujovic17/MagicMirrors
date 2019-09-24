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
                case "abandoned_mineshaft":
                case "buried_treasure":
                case "desert_pyramid":
                case "end_city_treasure":
                case "igloo_chest":
                case "jungle_temple":
                //case "jungle_temple_dispenser":
                case "nether_bridge":
                //case "pillager_outpost":
                //case "shipwreck_map":
                //case "shipwreck_supply":
                case "shipwreck_treasure":
                case "simple_dungeon":
                //case "spawn_bonus_chest":
                case "stronghold_corridor":
                case "stronghold_crossing":
                case "stronghold_library":
                case "underwater_ruin_big":
                //case "underwater_ruin_small":
                //case "village_armorer":
                //case "village_weaponsmith":
                //case "village_butcher":
                case "village_cartographer":
                //case "village_mason":
                //case "village_shepherd":
                //case "village_tannery":
                //case "village_desert_house":
                //case "village_plains_house":
                //case "village_savanna_house":
                case "village_snowy_house":
                //case "village_taiga_house":
                case "woodland_mansion":      evt.getTable().addPool(getInjectPool(file)); Reference.LOGGER.info(file + "Loot Table Loaded!"); break;
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
