package com.codenamerevy.magicmirror.util;

import com.codenamerevy.magicmirror.config.MagicMirrorsConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ref
{
    public static final String MODID = "magicmirror";
    public static final Logger LOGGER = LogManager.getLogger();

    private Ref()
    {
        if(MagicMirrorsConfig.CategoryDeveloper.enableLogger.get()) {
            LOGGER.info("Reference called!");
        }
    }
}
