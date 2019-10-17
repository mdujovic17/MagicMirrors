package com.codenamerevy.magicmirror.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.nio.file.Path;

@Mod.EventBusSubscriber
public class ItemConfig
{
    private static final ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec SERVER_CONFIG;

    static {
        init(SERVER_BUILDER);

        SERVER_CONFIG = SERVER_BUILDER.build();
    }

    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();

        configData.load();

        spec.setConfig(configData);
    }

    public static ForgeConfigSpec.BooleanValue enableIngredients;
    public static ForgeConfigSpec.BooleanValue enableDimensionalMirrors;
    public static ForgeConfigSpec.BooleanValue enableDimensionCrystal;
    public static ForgeConfigSpec.BooleanValue enableMagicMirrors;

    public static void init(ForgeConfigSpec.Builder SERVER_BUILDER)
    {
        SERVER_BUILDER.comment("Ingredients");
        enableIngredients = SERVER_BUILDER.comment("Enable / Disable Magic Mirror Ingredients [true / false]").define("ingredientsEnabled", false);

        SERVER_BUILDER.comment("Dimensional Mirrors");
        enableDimensionalMirrors = SERVER_BUILDER.comment("Enable / Disable Dimensional Mirrors [true / false]").define("dimensionalMirrorsEnabled", true);

        SERVER_BUILDER.comment("Dimension Crystal");
        enableDimensionCrystal = SERVER_BUILDER.comment("Enable / Disable Dimension Crystal (NO TOUCHY PLZ) [true / false]").define("dimensionCrystalEnabled", true);

        SERVER_BUILDER.comment("Disable All Items");
        enableMagicMirrors = SERVER_BUILDER.comment("Enable / Disable Magic Mirrors [true / false]").define("magicmirrors", true);
    }

}
