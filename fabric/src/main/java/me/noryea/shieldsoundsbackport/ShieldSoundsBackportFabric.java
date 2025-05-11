package me.noryea.shieldsoundsbackport;

import me.noryea.shieldsoundsbackport.handler.PlayerHurt;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.server.level.ServerPlayer;

public class ShieldSoundsBackportFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((livingEntity, damageSource, v) -> {
            if (livingEntity instanceof ServerPlayer player) {
                PlayerHurt.onHurt(player, damageSource, v);
            }
            return true;
        });
    }
}
