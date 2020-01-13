package com.codenamerevy.magicmirror.util.handler;

import com.codenamerevy.magicmirror.config.MagicMirrorsConfig;
import com.codenamerevy.magicmirror.util.Ref;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * OK a little about this class;
 * This class works as is, but its way to clunky.
 * If you want to use this class for your own projects, I HIGHLY recommend not to.
 * Reason for that is because there are way too much if() statements and it will slow down the code. A lot.
 * Until I find a better way to do this, it will stay like this.
 * (Although this way has a lot more control, I still don't recommend it)
 * THIS APPLIES TO COMMENTED CODE,, CURRENLTY TESTING OUT THE OLD MECHANIC WITH A FEW CHANGES
 *
 * @author CodenameRevy
 */

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
            if (MagicMirrorsConfig.CategoryDeveloper.enableLogger.get()) {
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
        if (MagicMirrorsConfig.CategoryDeveloper.enableLogger.get()) {
            Ref.LOGGER.info("Begin Injecting loot pool");
        }
            return LootPool.builder().addEntry(getInjectEntry(entry, 1)).bonusRolls(0, 1).name("mirrors_inject").build();
    }
    private static LootEntry.Builder getInjectEntry(String name, int weight)
    {

        if (MagicMirrorsConfig.CategoryDeveloper.enableLogger.get()) {
            Ref.LOGGER.info("Begin getting loot pool entries");
        }

        ResourceLocation table = new ResourceLocation(Ref.MODID, "inject/" + name);
        return TableLootEntry.builder(table).weight(weight);

    }

    /**
    public static final ResourceLocation MINESHAFT      = MagicMirror.getId("abandoned_mineshaft");
    public static final ResourceLocation BURIED         = MagicMirror.getId("buried_treasure");
    public static final ResourceLocation DESERT         = MagicMirror.getId("desert_pyramid");
    public static final ResourceLocation END            = MagicMirror.getId("end_city_treasure");
    public static final ResourceLocation IGLOO          = MagicMirror.getId("igloo_chest");
    public static final ResourceLocation JUNGLE         = MagicMirror.getId("jungle_temple");
    public static final ResourceLocation NETHER         = MagicMirror.getId("nether_bridge");
    public static final ResourceLocation SHIPWRECK      = MagicMirror.getId("shipwreck_treasure");
    public static final ResourceLocation STRONGHOLD     = MagicMirror.getId("simple_dungeon");
    public static final ResourceLocation CROSSING       = MagicMirror.getId("stronghold_crossing");
    public static final ResourceLocation LIBRARY        = MagicMirror.getId("stronghold_library");
    public static final ResourceLocation UNDERWATER     = MagicMirror.getId("underwater_ruin_big");
    public static final ResourceLocation CARTOGRAPHER   = MagicMirror.getId("village_cartographer");
    public static final ResourceLocation SNOWY_HOUSE    = MagicMirror.getId("village_snowy_house");

    private static final Map<ResourceLocation, Integer> ADD_MIRRORS_MINESHAFT       = ImmutableMap.<ResourceLocation, Integer>builder().put(LootTables.CHESTS_ABANDONED_MINESHAFT, 1).build();
    private static final Map<ResourceLocation, Integer> ADD_MIRRORS_BURIED          = ImmutableMap.<ResourceLocation, Integer>builder().put(LootTables.CHESTS_BURIED_TREASURE, 1).build();
    private static final Map<ResourceLocation, Integer> ADD_MIRRORS_DESERT          = ImmutableMap.<ResourceLocation, Integer>builder().put(LootTables.CHESTS_DESERT_PYRAMID, 1).build();
    private static final Map<ResourceLocation, Integer> ADD_MIRRORS_END             = ImmutableMap.<ResourceLocation, Integer>builder().put(LootTables.CHESTS_END_CITY_TREASURE, 1).build();
    private static final Map<ResourceLocation, Integer> ADD_MIRRORS_IGLOO           = ImmutableMap.<ResourceLocation, Integer>builder().put(LootTables.CHESTS_IGLOO_CHEST, 1).build();
    private static final Map<ResourceLocation, Integer> ADD_MIRRORS_JUNGLE          = ImmutableMap.<ResourceLocation, Integer>builder().put(LootTables.CHESTS_JUNGLE_TEMPLE, 1).build();
    private static final Map<ResourceLocation, Integer> ADD_MIRRORS_NETHER          = ImmutableMap.<ResourceLocation, Integer>builder().put(LootTables.CHESTS_NETHER_BRIDGE, 1).build();
    private static final Map<ResourceLocation, Integer> ADD_MIRRORS_SHIPWRECK       = ImmutableMap.<ResourceLocation, Integer>builder().put(LootTables.CHESTS_SHIPWRECK_TREASURE, 1).build();
    private static final Map<ResourceLocation, Integer> ADD_MIRRORS_STRONGHOLD      = ImmutableMap.<ResourceLocation, Integer>builder().put(LootTables.CHESTS_SIMPLE_DUNGEON, 1).build();
    private static final Map<ResourceLocation, Integer> ADD_MIRRORS_CROSSING        = ImmutableMap.<ResourceLocation, Integer>builder().put(LootTables.CHESTS_STRONGHOLD_CROSSING, 1).build();
    private static final Map<ResourceLocation, Integer> ADD_MIRRORS_LIBRARY         = ImmutableMap.<ResourceLocation, Integer>builder().put(LootTables.CHESTS_STRONGHOLD_LIBRARY, 1).build();
    private static final Map<ResourceLocation, Integer> ADD_MIRRORS_UNDERWATER      = ImmutableMap.<ResourceLocation, Integer>builder().put(LootTables.CHESTS_UNDERWATER_RUIN_BIG, 1).build();
    private static final Map<ResourceLocation, Integer> ADD_MIRRORS_CARTOGRAPHER    = ImmutableMap.<ResourceLocation, Integer>builder().put(LootTables.CHESTS_VILLAGE_VILLAGE_CARTOGRAPHER, 1).build();
    private static final Map<ResourceLocation, Integer> ADD_MIRRORS_SNOWY_HOUSE     = ImmutableMap.<ResourceLocation, Integer>builder().put(LootTables.CHESTS_VILLAGE_VILLAGE_SNOWY_HOUSE, 1).build();

    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event)
    {
        ResourceLocation tableName = event.getName();
        if(ADD_MIRRORS_MINESHAFT.keySet().contains(tableName))
        {
            addToTableMineshaft(event, ADD_MIRRORS_MINESHAFT.get(tableName));
        }
        if(ADD_MIRRORS_BURIED.keySet().contains(tableName))
        {
            addToTableBuried(event, ADD_MIRRORS_BURIED.get(tableName));
        }
        if(ADD_MIRRORS_DESERT.keySet().contains(tableName))
        {
            addToTableDesert(event, ADD_MIRRORS_DESERT.get(tableName));
        }
        if(ADD_MIRRORS_END.keySet().contains(tableName))
        {
            addToTableEnd(event, ADD_MIRRORS_END.get(tableName));
        }
        if(ADD_MIRRORS_IGLOO.keySet().contains(tableName))
        {
            addToTableIgloo(event, ADD_MIRRORS_IGLOO.get(tableName));
        }
        if(ADD_MIRRORS_JUNGLE.keySet().contains(tableName))
        {
            addToTableJungle(event, ADD_MIRRORS_JUNGLE.get(tableName));
        }
        if(ADD_MIRRORS_NETHER.keySet().contains(tableName))
        {
            addToTableNether(event, ADD_MIRRORS_NETHER.get(tableName));
        }
        if(ADD_MIRRORS_SHIPWRECK.keySet().contains(tableName))
        {
            addToTableShipwreck(event, ADD_MIRRORS_SHIPWRECK.get(tableName));
        }
        if(ADD_MIRRORS_STRONGHOLD.keySet().contains(tableName))
        {
            addToTableStronghold(event, ADD_MIRRORS_STRONGHOLD.get(tableName));
        }
        if(ADD_MIRRORS_CROSSING.keySet().contains(tableName))
        {
            addToTableCrossing(event, ADD_MIRRORS_CROSSING.get(tableName));
        }
        if(ADD_MIRRORS_LIBRARY.keySet().contains(tableName))
        {
            addToTableLibrary(event, ADD_MIRRORS_LIBRARY.get(tableName));
        }
        if(ADD_MIRRORS_UNDERWATER.keySet().contains(tableName))
        {
            addToTableUnderwater(event, ADD_MIRRORS_UNDERWATER.get(tableName));
        }
        if(ADD_MIRRORS_CARTOGRAPHER.keySet().contains(tableName))
        {
            addToTableCartographer(event, ADD_MIRRORS_CARTOGRAPHER.get(tableName));
        }
        if(ADD_MIRRORS_SNOWY_HOUSE.keySet().contains(tableName))
        {
            addToTableSnowyHouse(event, ADD_MIRRORS_SNOWY_HOUSE.get(tableName));
        }
    }

    private static void addToTableMineshaft(LootTableLoadEvent event, int maxRolls) {
        if (hasLootPool(event.getTable(), event.getName().toString())) return;

        Reference.LOGGER.info("Add mirrors to loot table {} ({} rolls)", event.getName(), maxRolls);
        event.getTable().addPool((new LootPool.Builder()).name("mineshaft_added").rolls(new RandomValueRange(1, maxRolls)).addEntry(TableLootEntry.builder(MINESHAFT).weight(10).acceptFunction(SetCount.builder(new RandomValueRange(0, 1)))).build());
    }

    private static void addToTableBuried(LootTableLoadEvent event, int maxRolls)
    {
        if (hasLootPool(event.getTable(), event.getName().toString())) return;

        Reference.LOGGER.info("Add mirrors to loot table {} ({} rolls)", event.getName(), maxRolls);
        event.getTable().addPool((new LootPool.Builder()).name("buried_added").rolls(new RandomValueRange(1, maxRolls)).addEntry(TableLootEntry.builder(BURIED).weight(10).acceptFunction(SetCount.builder(new RandomValueRange(0, 1)))).build());
    }
    private static void addToTableDesert(LootTableLoadEvent event, int maxRolls)
    {
        if (hasLootPool(event.getTable(), event.getName().toString())) return;

        Reference.LOGGER.info("Add mirrors to loot table {} ({} rolls)", event.getName(), maxRolls);
        event.getTable().addPool((new LootPool.Builder()).name("desert_added").rolls(new RandomValueRange(1, maxRolls)).addEntry(TableLootEntry.builder(DESERT).weight(10).acceptFunction(SetCount.builder(new RandomValueRange(0, 1)))).build());

    }
    private static void addToTableEnd(LootTableLoadEvent event, int maxRolls)
    {
        if (hasLootPool(event.getTable(), event.getName().toString())) return;

        Reference.LOGGER.info("Add mirrors to loot table {} ({} rolls)", event.getName(), maxRolls);
        event.getTable().addPool((new LootPool.Builder()).name("end_added").rolls(new RandomValueRange(1, maxRolls)).addEntry(TableLootEntry.builder(END).weight(10).acceptFunction(SetCount.builder(new RandomValueRange(0, 1)))).build());

    }
    private static void addToTableIgloo(LootTableLoadEvent event, int maxRolls)
    {
        if (hasLootPool(event.getTable(), event.getName().toString())) return;

        Reference.LOGGER.info("Add mirrors to loot table {} ({} rolls)", event.getName(), maxRolls);
        event.getTable().addPool((new LootPool.Builder()).name("igloo_added").rolls(new RandomValueRange(1, maxRolls)).addEntry(TableLootEntry.builder(IGLOO).weight(10).acceptFunction(SetCount.builder(new RandomValueRange(0, 1)))).build());

    }
    private static void addToTableJungle(LootTableLoadEvent event, int maxRolls)
    {
        if (hasLootPool(event.getTable(), event.getName().toString())) return;

        Reference.LOGGER.info("Add mirrors to loot table {} ({} rolls)", event.getName(), maxRolls);
        event.getTable().addPool((new LootPool.Builder()).name("jungle_added").rolls(new RandomValueRange(1, maxRolls)).addEntry(TableLootEntry.builder(JUNGLE).weight(10).acceptFunction(SetCount.builder(new RandomValueRange(0, 1)))).build());

    }
    private static void addToTableNether(LootTableLoadEvent event, int maxRolls)
    {
        if (hasLootPool(event.getTable(), event.getName().toString())) return;

        Reference.LOGGER.info("Add mirrors to loot table {} ({} rolls)", event.getName(), maxRolls);
        event.getTable().addPool((new LootPool.Builder()).name("nether_added").rolls(new RandomValueRange(1, maxRolls)).addEntry(TableLootEntry.builder(NETHER).weight(10).acceptFunction(SetCount.builder(new RandomValueRange(0, 1)))).build());

    }
    private static void addToTableShipwreck(LootTableLoadEvent event, int maxRolls)
    {
        if (hasLootPool(event.getTable(), event.getName().toString())) return;

        Reference.LOGGER.info("Add mirrors to loot table {} ({} rolls)", event.getName(), maxRolls);
        event.getTable().addPool((new LootPool.Builder()).name("shipwreck_added").rolls(new RandomValueRange(1, maxRolls)).addEntry(TableLootEntry.builder(SHIPWRECK).weight(10).acceptFunction(SetCount.builder(new RandomValueRange(0, 1)))).build());

    }
    private static void addToTableStronghold(LootTableLoadEvent event, int maxRolls)
    {
        if (hasLootPool(event.getTable(), event.getName().toString())) return;

        Reference.LOGGER.info("Add mirrors to loot table {} ({} rolls)", event.getName(), maxRolls);
        event.getTable().addPool((new LootPool.Builder()).name("stronghold_added").rolls(new RandomValueRange(1, maxRolls)).addEntry(TableLootEntry.builder(STRONGHOLD).weight(10).acceptFunction(SetCount.builder(new RandomValueRange(0, 1)))).build());

    }
    private static void addToTableCrossing(LootTableLoadEvent event, int maxRolls)
    {
        if (hasLootPool(event.getTable(), event.getName().toString())) return;

        Reference.LOGGER.info("Add mirrors to loot table {} ({} rolls)", event.getName(), maxRolls);
        event.getTable().addPool((new LootPool.Builder()).name("crossing_added").rolls(new RandomValueRange(1, maxRolls)).addEntry(TableLootEntry.builder(CROSSING).weight(10).acceptFunction(SetCount.builder(new RandomValueRange(0, 1)))).build());

    }
    private static void addToTableLibrary(LootTableLoadEvent event, int maxRolls)
    {
        if (hasLootPool(event.getTable(), event.getName().toString())) return;

        Reference.LOGGER.info("Add mirrors to loot table {} ({} rolls)", event.getName(), maxRolls);
        event.getTable().addPool((new LootPool.Builder()).name("library_added").rolls(new RandomValueRange(1, maxRolls)).addEntry(TableLootEntry.builder(LIBRARY).weight(10).acceptFunction(SetCount.builder(new RandomValueRange(0, 1)))).build());

    }
    private static void addToTableUnderwater(LootTableLoadEvent event, int maxRolls)
    {
        if (hasLootPool(event.getTable(), event.getName().toString())) return;

        Reference.LOGGER.info("Add mirrors to loot table {} ({} rolls)", event.getName(), maxRolls);
        event.getTable().addPool((new LootPool.Builder()).name("underwater_added").rolls(new RandomValueRange(1, maxRolls)).addEntry(TableLootEntry.builder(UNDERWATER).weight(10).acceptFunction(SetCount.builder(new RandomValueRange(0, 1)))).build());

    }
    private static void addToTableCartographer(LootTableLoadEvent event, int maxRolls)
    {
        if (hasLootPool(event.getTable(), event.getName().toString())) return;

        Reference.LOGGER.info("Add mirrors to loot table {} ({} rolls)", event.getName(), maxRolls);
        event.getTable().addPool((new LootPool.Builder()).name("cartographer_added").rolls(new RandomValueRange(1, maxRolls)).addEntry(TableLootEntry.builder(CARTOGRAPHER).weight(10).acceptFunction(SetCount.builder(new RandomValueRange(0, 1)))).build());

    }
    private static void addToTableSnowyHouse(LootTableLoadEvent event, int maxRolls)
    {
        if (hasLootPool(event.getTable(), event.getName().toString())) return;

        Reference.LOGGER.info("Add mirrors to loot table {} ({} rolls)", event.getName(), maxRolls);
        event.getTable().addPool((new LootPool.Builder()).name("snowy_house_added").rolls(new RandomValueRange(1, maxRolls)).addEntry(TableLootEntry.builder(SNOWY_HOUSE).weight(10).acceptFunction(SetCount.builder(new RandomValueRange(0, 1)))).build());

    }

    @SuppressWarnings("ConstantConditions")
    private static boolean hasLootPool(LootTable table, String poolName) {
        return table.getPool(poolName) != null;
    }
    **/
}