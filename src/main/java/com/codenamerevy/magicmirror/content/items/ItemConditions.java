/*MIT License

Copyright (c) 2021 Marko Dujović

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.*/

//package com.codenamerevy.magicmirror.content.items;
//
//import com.codenamerevy.magicmirror.MagicMirror;
//import com.codenamerevy.magicmirror.config.Config;
//import com.google.gson.JsonObject;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.common.crafting.conditions.ICondition;
//import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
//
//public class ItemConditions implements ICondition
//{
//    public static final ResourceLocation NAME = new ResourceLocation(MagicMirror.MODID, "items");
//    public static String object;
//
//    public ItemConditions (String object)
//    {
//        this.object = object;
//    }
//
//    @Override
//    public ResourceLocation getID()
//    {
//        return NAME;
//    }
//
//    @Override
//    public boolean test()
//    {
//        if(object.equals("ingredients"))        return Config.GENERAL.enableIngredients.get();
//        if(object.equals("dimensionals"))       return Config.GENERAL.enableDimensionalMirrors.get();
//        return false;
//    }
//
//    public static class Serializer implements IConditionSerializer<ItemConditions> {
//        public static final ItemConditions.Serializer INSTANCE = new ItemConditions.Serializer();
//
//        @Override
//        public void write(JsonObject json, ItemConditions value) {
//
//        }
//
//        @Override
//        public ItemConditions read(JsonObject json) {
//            return new ItemConditions(json.get("object").getAsString());
//        }
//
//        @Override
//        public ResourceLocation getID() {
//            return NAME;
//        }
//    }
//}