package com.codenamerevy.magicmirror.util.handler;

import com.codenamerevy.magicmirror.config.Config;
import com.codenamerevy.magicmirror.util.Ref;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Ref.MODID)
public final class LootHandler
{
    @SubscribeEvent
    public static void lootLoad(LootTableLoadEvent event)
    {
        String prefix = "minecraft:chests/";
        String name = event.getName().toString();
        if(name.startsWith(prefix))
        {
            if (Config.CategoryDeveloper.enableLogger.get()) {
                Ref.LOGGER.info("Begin LootPool load");
            }
                String file = name.substring(name.indexOf(prefix) + prefix.length());
            switch(file)
            {
                case "abandoned_mineshaft":
                case "buried_treasure":
                case "desert_pyramid":
                case "end_city_treasure":
                case "igloo_chest":
                case "jungle_temple":
                case "nether_bridge":
                case "shipwreck_treasure":
                case "simple_dungeon":
                case "stronghold_crossing":
                case "stronghold_library":
                case "underwater_ruin_big":
                case "village_cartographer":
                case "village_snowy_house":event.getTable().addPool(getInjectPool(file));
                break;
                default:
                    break;
            }
        }
    }

    private static LootPool getInjectPool(String entry)
    {
        if (Config.CategoryDeveloper.enableLogger.get()) {
            Ref.LOGGER.info("Begin Injecting loot pool");
        }
            return LootPool.builder().addEntry(getInjectEntry(entry, 1)).bonusRolls(0, 1).name("mirrors_inject").build();
    }
    private static LootEntry.Builder getInjectEntry(String name, int weight)
    {

        if (Config.CategoryDeveloper.enableLogger.get()) {
            Ref.LOGGER.info("Begin getting loot pool entries");
        }

        ResourceLocation table = new ResourceLocation(Ref.MODID, "inject/" + name);
        return TableLootEntry.builder(table).weight(weight);

    }
}