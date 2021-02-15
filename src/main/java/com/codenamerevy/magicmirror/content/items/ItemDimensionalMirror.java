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
import net.minecraft.world.server.ServerWorld;

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

        ServerWorld serverWorld = (ServerWorld) world;
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

        }
        else
        {
            player.sendStatusMessage(new TranslationTextComponent("info.magicmirror.spawnNotFound"), true);
            world.playSound(null, currentPos.getX(), currentPos.getY(), currentPos.getZ(), SoundInit.MIRROR_DISCHARGE.get(), SoundCategory.PLAYERS, 1f, 1f);
        }
        return super.onItemUseFinish(stack, world, entity);
    }

    @Override
    public Rarity getRarity(ItemStack stack)
    {
        return Rarity.EPIC;
    }
}