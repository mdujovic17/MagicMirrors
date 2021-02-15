package com.codenamerevy.magicmirror.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.server.TicketType;

public class SpawnWarp {
    /**
     * Teleports a player over dimensions to their spawn point, but can be used to teleport a player in a single dimension.
     **/
    public static void teleportHome(PlayerEntity playerEntity)
    {
        ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) playerEntity; //cast player to serverPlayer
        BlockPos spawn = serverPlayerEntity.func_241140_K_(); //Gets players spawn coordinates
        //checks what dimension the player is in
        RegistryKey<World> dimensionType = serverPlayerEntity.func_241141_L_();

        //Dismounts and teleports player to a provided dimension and coords
        //If player is mounted, the game will crash
        serverPlayerEntity.stopRiding();
        serverPlayerEntity.teleport(playerEntity.getServer().getWorld(dimensionType), spawn.getX() + 0.5f, spawn.getY() + 0.6f, spawn.getZ() + 0.5f, serverPlayerEntity.rotationYaw, serverPlayerEntity.rotationPitch);

        //Equinox.LOGGER.debug("Teleported player to home dimension!");
    }

    /**
     * Teleports a player in a local dimension to their spawn point. Can only be used for local dimension travel, if used in other dimensions that don't contain
     * a spawn point, it will teleport the player to spawn coordinates in that dimension
     * (ex: 40 ,50, 60 spawn point in overworld, the player will be tp'd to that coords in Nether if used while in Nether)
     **/
    public static void setPosAndUpdate(LivingEntity entity, World world, BlockPos spawn)
    {
        ServerWorld serverWorld = (ServerWorld) world;
        ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) entity;
        ChunkPos pos = new ChunkPos(new BlockPos(spawn));

        serverWorld.getChunkProvider().registerTicket(TicketType.POST_TELEPORT, pos, 1, entity.getEntityId());
        serverPlayerEntity.stopRiding();
        serverPlayerEntity.setPositionAndUpdate(spawn.getX() + 0.5f, spawn.getY() + 0.6f, spawn.getZ() + 0.5f);

        serverPlayerEntity.fallDistance = 0.25f;
    }

}
