/**
 * @author CodenameRevy
 */

package com.codenamerevy.magicmirror.content.items;

import com.codenamerevy.magicmirror.init.ParticleInit;
import com.codenamerevy.magicmirror.init.SoundInit;
import com.codenamerevy.magicmirror.util.TeleportHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.ParametersAreNonnullByDefault;
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
            entity.world.addParticle(ParticleInit.MIRROR_PARTICLE, entity.lastTickPosX + (rand.nextBoolean() ? -1 : 1) * Math.pow(rand.nextFloat(), 2) * 2, entity.lastTickPosY + rand.nextFloat() * 3 - 2, entity.lastTickPosZ + (rand.nextBoolean() ? -1 : 1) * Math.pow(rand.nextFloat(), 2) * 2, -1, -0.105D, -1);
        }
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity entity)
    {
        if (!world.isRemote)
        {
            PlayerEntity player = (PlayerEntity) entity;
            BlockPos bedPos = player.getBedLocation(player.dimension);
            BlockPos backPos = bedPos;
            BlockPos currentPos = player.getPosition();

            if(!world.dimension.isSurfaceWorld())
            {
                world.playSound(null, currentPos.getX(), currentPos.getY(), currentPos.getZ(), SoundInit.MIRROR_DISCHARGE, SoundCategory.PLAYERS, 1f, 1f);
                player.sendStatusMessage(new TranslationTextComponent("chat.magicmirror.power"), true);
                return stack;
            }
            if (bedPos == null)
            {
                world.playSound(null, currentPos.getX(), currentPos.getY(), currentPos.getZ(), SoundInit.MIRROR_DISCHARGE, SoundCategory.PLAYERS, 1f, 1f);
                player.sendStatusMessage(new TranslationTextComponent("chat.magicmirror.bednotfound"), true);
                return stack;
            }

            TeleportHelper.setPositionAndUpdate(entity, world, bedPos);
        }
        return stack;
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