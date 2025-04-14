package me.noryea.shieldsoundsbackport;

import me.noryea.shieldsoundsbackport.handler.PlayerHurt;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(value = "shieldsoundsbackport")
public class ShieldSoundsBackportForge {
    public ShieldSoundsBackportForge() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onLivingEntityHurt(ShieldBlockEvent event) {
        if (event.getEntity() instanceof Player player) {
            PlayerHurt.onHurt(player, event.getDamageSource(), event.getOriginalBlockedDamage());
        }
        event.setCanceled(false);
    }
}
