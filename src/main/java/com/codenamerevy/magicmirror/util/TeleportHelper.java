/**
 * @author CodenameRevy
 */

package com.codenamerevy.magicmirror.util;

import com.codenamerevy.magicmirror.init.SoundInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.server.TicketType;

public class TeleportHelper
{
    private static PlayerEntity player;
    private static ServerWorld serverWorld;
    private static Entity ridingEntity;

    public static void travelHome(PlayerEntity player)
    {
        ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;

        DimensionType prevDimension = player.dimension;
        DimensionType transDimension = prevDimension == player.dimension ? DimensionType.OVERWORLD : player.dimension;

        serverPlayer.teleport(player.getServer().getWorld(transDimension), serverPlayer.serverPosX, serverPlayer.serverPosY, serverPlayer.serverPosZ, serverPlayer.rotationYaw, serverPlayer.rotationPitch);
    }

    public static void setPositionAndUpdate(LivingEntity entity, World world, BlockPos bedPos)
    {
        serverWorld = (ServerWorld) world;
        player = (ServerPlayerEntity) entity;
        ChunkPos pos = new ChunkPos(new BlockPos(bedPos));

        serverWorld.getChunkProvider().registerTicket(TicketType.POST_TELEPORT, pos, 1, entity.getEntityId());
        entity.stopRiding();
        player.sendStatusMessage(new TranslationTextComponent("chat.magicmirror.teleport"), true);
        entity.setPositionAndUpdate(bedPos.getX() + 0.5f, bedPos.getY() + 0.6f, bedPos.getZ() + 0.5f);
        entity.fallDistance = 0;
        world.playSound(null, bedPos.getX(), bedPos.getY(), bedPos.getZ(), SoundInit.TELEPORT, SoundCategory.PLAYERS, 1f, 1f);
    }
}
