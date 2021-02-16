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

package com.codenamerevy.magicmirror.content.items;

import com.codenamerevy.magicmirror.init.SoundInit;
import com.codenamerevy.magicmirror.util.SpawnWarp;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ItemDimensionalMirror extends ItemMagicMirror
{
    public ItemDimensionalMirror(Properties properties)
    {
        super(properties);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity entity)
    {
        if (world.isRemote) { return super.onItemUseFinish(stack, world, entity); }

        ServerPlayerEntity player = (ServerPlayerEntity) entity; //casting serverPlayer to entity
        BlockPos spawnPos = player.func_241140_K_(); //Gets user's respawn position
        RegistryKey<World> spawnWorldKey = player.func_241141_L_(); //Gets the respawn dimension
        BlockPos currentPos = player.getPosition();

        if (spawnPos != null)
        {
            if (world.getDimensionKey() != spawnWorldKey) {
                SpawnWarp.teleportHome(player);
            }
            else {
                SpawnWarp.setPosAndUpdate(player, world, spawnPos);
            }
            world.playSound(null, currentPos.getX(), currentPos.getY(), currentPos.getZ(), SoundInit.TELEPORT.get(), SoundCategory.PLAYERS, 1f, 1f);
            world.playSound(null, spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), SoundInit.TELEPORT.get(), SoundCategory.PLAYERS, 1f, 1f);
        }
        else
        {
            player.sendStatusMessage(new TranslationTextComponent("info.magicmirror.spawnNotFound"), true);
            world.playSound(null, currentPos.getX(), currentPos.getY(), currentPos.getZ(), SoundInit.MIRROR_DISCHARGE.get(), SoundCategory.PLAYERS, 1f, 1f);
        }
        return stack;
    }

    @Override
    public Rarity getRarity(ItemStack stack)
    {
        return Rarity.EPIC;
    }
}