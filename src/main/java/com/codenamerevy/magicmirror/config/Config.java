package com.codenamerevy.magicmirror.config;

import com.codenamerevy.magicmirror.util.Ref;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import static net.minecraftforge.fml.Logging.CORE;
import static net.minecraftforge.fml.loading.LogMarkers.FORGEMOD;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {

    private static final Builder COMMON_BUILDER = new Builder();
    private static final Builder CLIENT_BUILDER = new Builder();

    public static final CategoryGeneral GENERAL = new CategoryGeneral();
    public static final CategoryDeveloper DEVELOPER = new CategoryDeveloper();

    public static final class CategoryGeneral {

        public static ForgeConfigSpec.BooleanValue enableIngredients;
        public static ForgeConfigSpec.BooleanValue enableDimensionalMirrors;

        private CategoryGeneral() {
            COMMON_BUILDER.comment("General Settings (COMMON)").push("GENERAL");

            COMMON_BUILDER.comment("Magic Mirror recipe");
            enableIngredients = COMMON_BUILDER
                    .comment("Enable magic mirror recipe")
                    .translation("magicmirror.config.recipe_mirror")
                    .define("ingredientsEnabled", false);

            COMMON_BUILDER.comment("Dimensional Mirrors");
            enableDimensionalMirrors = COMMON_BUILDER
                    .comment("Enable recipes for dimensional mirrors")
                    .translation("magicmirror.config.recipe_dim")
                    .define("dimensionalMirrorsEnabled", true);

            COMMON_BUILDER.pop();
        }
    }

    public static final class CategoryDeveloper {

        public static ForgeConfigSpec.BooleanValue enableLogger;

        private CategoryDeveloper(){
            COMMON_BUILDER.comment("Developer Settings").push("DEVELOPER");

            enableLogger = COMMON_BUILDER
                    .comment("Enable / Disable LogManager logging (DEV)")
                    .translation("codenamerevy.config.logging")
                    .define("logger", false);
            COMMON_BUILDER.pop();
        }
    }

    public static final ForgeConfigSpec COMMON_CONFIG = COMMON_BUILDER.build();
    public static final ForgeConfigSpec CLIENT_CONFIG = CLIENT_BUILDER.build();

    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent) {
        Ref.LOGGER.debug(FORGEMOD, "Loaded {} config file {}", Ref.MODID, configEvent.getConfig().getFileName());
    }

    @SubscribeEvent
    public static void onFileChange(final ModConfig.Reloading configEvent) {
        Ref.LOGGER.fatal(CORE, "{} config just got changed on the file system!", Ref.MODID);
    }
}
