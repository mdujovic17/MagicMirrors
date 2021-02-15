package com.codenamerevy.magicmirror.content.items;

import com.codenamerevy.magicmirror.init.ParticleInit;
import com.codenamerevy.magicmirror.init.SoundInit;
import com.codenamerevy.magicmirror.util.SpawnWarp;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class ItemMagicMirror extends Item {

    private static int duration = 25;

    public ItemMagicMirror(Properties properties) {
        super(properties);

    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        player.setActiveHand(hand);
        return new ActionResult<ItemStack>(ActionResultType.SUCCESS, stack);
    }

    @Override
    public void onUsingTick (ItemStack stack, LivingEntity entity,int count)
    {
        Random rand = entity.world.rand;
        for(int a = 0; a < 25; a++) {
            entity.world.addParticle(ParticleInit.MIRROR_PARTICLE, entity.lastTickPosX + (rand.nextBoolean() ? -0.5 : 0.5) * Math.pow(rand.nextFloat(), 2) * 2, entity.lastTickPosY + rand.nextFloat() * 3 - 2, entity.lastTickPosZ + (rand.nextBoolean() ? -0.5 : 0.5) * Math.pow(rand.nextFloat(), 2) * 2, -1, -0.105D, -1);
        }
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity entity)
    {
        if (world.isRemote) { return super.onItemUseFinish(stack, world, entity); }

        ServerWorld serverWorld = (ServerWorld) world;
        ServerPlayerEntity player = (ServerPlayerEntity) entity; //casting serverPlayer to entity
        BlockPos spawnPos = player.func_241140_K_(); //Gets user's respawn position
        RegistryKey<World> spawnWorldKey = player.func_241141_L_(); //Gets the respawn dimension
        BlockPos currentPos = player.getPosition();

        if (spawnPos != null)
        {
            if (world.getDimensionKey() == spawnWorldKey) {
                SpawnWarp.setPosAndUpdate(player, world, spawnPos);
                world.playSound(null, currentPos.getX(), currentPos.getY(), currentPos.getZ(), SoundInit.TELEPORT, SoundCategory.PLAYERS, 1f, 1f);
            }
            else {
                player.sendStatusMessage(new TranslationTextComponent("info.magicmirror.power"), true);
                world.playSound(null, currentPos.getX(), currentPos.getY(), currentPos.getZ(), SoundInit.MIRROR_DISCHARGE, SoundCategory.PLAYERS, 1f, 1f);
            }
        }
        else
        {
            player.sendStatusMessage(new TranslationTextComponent("info.equinox.spawnNotFound"), true);
            world.playSound(null, currentPos.getX(), currentPos.getY(), currentPos.getZ(), SoundInit.MIRROR_DISCHARGE, SoundCategory.PLAYERS, 1f, 1f);
            return super.onItemUseFinish(stack, world, entity);
        }
//        {
//            PlayerEntity player = (PlayerEntity) entity;
//            BlockPos bedPos = player.getBedLocation(player.dimension);
//            BlockPos backPos = bedPos;
//            BlockPos currentPos = player.getPosition();
//
//            if(!world.dimension.isSurfaceWorld())
//            {
//                world.playSound(null, currentPos.getX(), currentPos.getY(), currentPos.getZ(), SoundInit.MIRROR_DISCHARGE, SoundCategory.PLAYERS, 1f, 1f);
//                player.sendStatusMessage(new TranslationTextComponent("chat.magicmirror.power"), true);
//                return stack;
//            }
//            if (bedPos == null)
//            {
//                world.playSound(null, currentPos.getX(), currentPos.getY(), currentPos.getZ(), SoundInit.MIRROR_DISCHARGE, SoundCategory.PLAYERS, 1f, 1f);
//                player.sendStatusMessage(new TranslationTextComponent("chat.magicmirror.bednotfound"), true);
//                return stack;
//            }
//
//            TeleportHelper.setPositionAndUpdate(entity, world, bedPos);
//        }
        return super.onItemUseFinish(stack, world, entity);
    }

    @Override
    public UseAction getUseAction (ItemStack stack)
    {
        return UseAction.BOW;
    }

    @Override
    public int getUseDuration(ItemStack stack)
    {
        return duration;
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.RARE;
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}