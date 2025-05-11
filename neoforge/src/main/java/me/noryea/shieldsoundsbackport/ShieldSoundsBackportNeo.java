package me.noryea.shieldsoundsbackport;

import me.noryea.shieldsoundsbackport.handler.PlayerHurt;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.ShieldBlockEvent;

@Mod("shieldsoundsbackport")
public class ShieldSoundsBackportNeo {
    public ShieldSoundsBackportNeo() {
        NeoForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onShieldBlock(ShieldBlockEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            PlayerHurt.onHurt(player, event.getDamageSource(), event.getOriginalBlockedDamage());
        }
        event.setCanceled(false);
    }
}
