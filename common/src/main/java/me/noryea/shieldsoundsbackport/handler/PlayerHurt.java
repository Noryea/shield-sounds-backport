package me.noryea.shieldsoundsbackport.handler;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public interface PlayerHurt {
    static void onHurt(ServerPlayer player, DamageSource source, float amount) {
        if (player.level().isClientSide) return;
        if (!player.isDamageSourceBlocked(source) || !(amount > 0)) return;
        ServerLevel serverLevel = player.serverLevel();
        if (!source.is(DamageTypeTags.IS_PROJECTILE) && source.getDirectEntity() instanceof LivingEntity livingEntity && livingEntity.canDisableShield()) {
            serverLevel.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.SHIELD_BREAK, player.getSoundSource(), 0.8F, 0.8F + serverLevel.random.nextFloat() * 0.4F);
        } else if (player.hurtTime == 0 || source.getEntity() instanceof Player) {
            serverLevel.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.SHIELD_BLOCK, player.getSoundSource(), 1.0F, 0.8F + serverLevel.random.nextFloat() * 0.4F);
        }
    }
}
