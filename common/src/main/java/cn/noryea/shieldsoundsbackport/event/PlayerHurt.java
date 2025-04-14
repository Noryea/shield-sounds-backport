package cn.noryea.shieldsoundsbackport.event;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class PlayerHurt {
    public static void onHurt(final Player player, DamageSource source, float amount) {
        if (!player.isDamageSourceBlocked(source) || !(amount > 0)) return;
        ServerLevel serverLevel = (ServerLevel) player.level();
        if (!source.is(DamageTypeTags.IS_PROJECTILE) && source.getDirectEntity() instanceof LivingEntity livingEntity) {
            if (livingEntity.canDisableShield()) {
                serverLevel.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SHIELD_BREAK, player.getSoundSource(), 0.8F, 0.8F + serverLevel.random.nextFloat() * 0.4F);
                return;
            }
        }
        serverLevel.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SHIELD_BLOCK, player.getSoundSource(), 1.0F, 0.8F + serverLevel.random.nextFloat() * 0.4F);

    }
}
