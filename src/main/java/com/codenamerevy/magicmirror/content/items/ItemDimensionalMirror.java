/**
 * @author CodenameRevy
 */

package com.codenamerevy.magicmirror.content.items;

import com.codenamerevy.magicmirror.init.SoundInit;
import com.codenamerevy.magicmirror.util.TeleportHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class ItemDimensionalMirror extends ItemMagicMirror
{
    private PlayerEntity player;
    private BlockPos bedPos;
    private BlockPos currentPos;

    public ItemDimensionalMirror(Properties properties)
    {
        super(properties);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity entity)
    {
        if(!world.isRemote())
        {
            player = (ServerPlayerEntity) entity;
            currentPos = player.getPosition();

            if(world.getDimension().getType() != DimensionType.OVERWORLD)
            {
                player.sendStatusMessage(new TranslationTextComponent("chat.magicmirror.dimension"), true);
                TeleportHelper.travelHome(player);
            }

            bedPos = player.getBedLocation(player.dimension);

            if (bedPos == null) {
                world.playSound(null, currentPos.getX(), currentPos.getY(), currentPos.getZ(), SoundInit.MIRROR_DISCHARGE, SoundCategory.PLAYERS, 1f, 1f);
                player.sendStatusMessage(new TranslationTextComponent("chat.magicmirror.bednotfound"), true);
                return stack;
            }
            TeleportHelper.setPositionAndUpdate(entity, world, bedPos);
        }
        return stack;
    }

    @Override
    public Rarity getRarity(ItemStack stack)
    {
        return Rarity.EPIC;
    }
}