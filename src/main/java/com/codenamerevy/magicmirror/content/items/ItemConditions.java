package com.codenamerevy.magicmirror.content.items;

import com.codenamerevy.magicmirror.config.ItemConfig;
import com.codenamerevy.magicmirror.util.Reference;
import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ItemConditions implements ICondition
{
    public static final ResourceLocation NAME = new ResourceLocation(Reference.MODID, "items");
    public static String object;

    public ItemConditions (String object)
    {
        this.object = object;
    }

    @Override
    public ResourceLocation getID()
    {
        return NAME;
    }

    @Override
    public boolean test()
    {
        if(object.equals("magic_mirrors"))      return ItemConfig.enableMagicMirrors.get();
        if(object.equals("dimension_crystals")) return ItemConfig.enableDimensionCrystal.get();
        if(object.equals("ingredients"))        return ItemConfig.enableIngredients.get();
        if(object.equals("dimensionals"))       return ItemConfig.enableDimensionalMirrors.get();
        return false;
    }

    public static class Serializer implements IConditionSerializer<ItemConditions> {
        public static final ItemConditions.Serializer INSTANCE = new ItemConditions.Serializer();

        @Override
        public void write(JsonObject json, ItemConditions value) {

        }

        @Override
        public ItemConditions read(JsonObject json) {
            return new ItemConditions(json.get("object").getAsString());
        }

        @Override
        public ResourceLocation getID() {
            return NAME;
        }
    }
}