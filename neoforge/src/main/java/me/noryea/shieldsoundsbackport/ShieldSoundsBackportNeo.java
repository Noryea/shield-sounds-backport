package me.noryea.shieldsoundsbackport;

import me.noryea.shieldsoundsbackport.handler.PlayerHurt;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.LivingShieldBlockEvent;

@Mod("shieldsoundsbackport")
public class ShieldSoundsBackportNeo {
    public ShieldSoundsBackportNeo() {
        NeoForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onLivingEntityHurt(LivingShieldBlockEvent event) {
        if (event.getEntity() instanceof Player player) {
            PlayerHurt.onHurt(player, event.getDamageSource(), event.getOriginalBlockedDamage());
        }
        event.setCanceled(false);
    }
}
