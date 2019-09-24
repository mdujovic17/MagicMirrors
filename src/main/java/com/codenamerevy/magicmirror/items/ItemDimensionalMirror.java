package com.codenamerevy.magicmirror.items;

import com.codenamerevy.magicmirror.init.ItemInit;
import com.codenamerevy.magicmirror.init.SoundInit;
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

/**
 * EXPERIMENTAL!!!
 */
public class ItemDimensionalMirror extends ItemMagicMirror
{
    private PlayerEntity player;
    private BlockPos bedPos;
    private BlockPos currentPos;

    public ItemDimensionalMirror(Properties properties)
    {
        super(properties);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity entity)
    {
        if(!world.isRemote())
        {
            player = (ServerPlayerEntity) entity;
            currentPos = player.getPosition();

            if(world.getDimension().getType() == DimensionType.THE_NETHER)
            {
                player.sendStatusMessage(new TranslationTextComponent("chat.magicmirror.dimension"), true);
                this.travelHomeFromNether(player);
            }

            if(world.getDimension().getType() == DimensionType.THE_END)
            {
                player.sendStatusMessage(new TranslationTextComponent("chat.magicmirror.dimension"), true);
                this.travelHomeFromEnd(player);
            }

            bedPos = player.getBedLocation(player.dimension);

            if (bedPos == null)
            {
                world.playSound(null, currentPos.getX(), currentPos.getY(), currentPos.getZ(), SoundInit.MIRROR_DISCHARGE, SoundCategory.PLAYERS, 1f, 1f);
                player.sendStatusMessage(new TranslationTextComponent("chat.magicmirror.bednotfound"), true);
                return stack;
            }

            if (entity.getRidingEntity() != null)
            {
                entity.stopRiding();
            }
            player.sendStatusMessage(new TranslationTextComponent("chat.magicmirror.teleport"), true);
            entity.setPositionAndUpdate(bedPos.getX() + 0.5f, bedPos.getY() + 0.6f, bedPos.getZ() + 0.5f);
            entity.fallDistance = 0;

            world.playSound(null, bedPos.getX(), bedPos.getY(), bedPos.getZ(), SoundInit.TELEPORT, SoundCategory.PLAYERS, 1f, 1f);
        }
        return stack;
    }

    private void travelHomeFromNether(PlayerEntity player)
    {
        ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;

        DimensionType prevDimension = player.dimension;
        DimensionType transDimension = prevDimension == DimensionType.THE_NETHER ? DimensionType.OVERWORLD : DimensionType.THE_NETHER;

        serverPlayer.teleport(player.getServer().getWorld(transDimension), serverPlayer.posX, serverPlayer.posY, serverPlayer.posZ, serverPlayer.rotationYaw, serverPlayer.rotationPitch);
    }

    private void travelHomeFromEnd(PlayerEntity player)
    {
        ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;

        DimensionType prevDimension = player.dimension;
        DimensionType transDimension = prevDimension == DimensionType.THE_END ? DimensionType.OVERWORLD : DimensionType.THE_END;

        serverPlayer.teleport(player.getServer().getWorld(transDimension), serverPlayer.posX, serverPlayer.posY, serverPlayer.posZ, serverPlayer.rotationYaw, serverPlayer.rotationPitch);
    }

    @Override
    public Rarity getRarity(ItemStack stack)
    {
        return Rarity.EPIC;
    }
}

