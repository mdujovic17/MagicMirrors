package com.codenamerevy.magicmirror.util;

import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.IExtensibleEnum;

//TODO: Make usage of this :P
public enum ModRarity implements IExtensibleEnum
{
    TRASH(TextFormatting.GRAY),
    LEGENDARY(TextFormatting.GREEN),
    ULTIMATE(TextFormatting.LIGHT_PURPLE),
    DEMONIC(TextFormatting.DARK_RED),
    GODLY(TextFormatting.GOLD);


    public final TextFormatting color;

    ModRarity(TextFormatting formatting)
    {
        this.color = formatting;
    }

    public static ModRarity create(String name, TextFormatting formatting)
    {
        throw new IllegalStateException("Enum not Extended!");
    }
}
