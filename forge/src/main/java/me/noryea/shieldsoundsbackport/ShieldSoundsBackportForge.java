package me.noryea.shieldsoundsbackport;

import me.noryea.shieldsoundsbackport.handler.PlayerHurt;
import net.minecraft.server.level.ServerPlayer;
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
    public void onShieldBlock(ShieldBlockEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            PlayerHurt.onHurt(player, event.getDamageSource(), event.getOriginalBlockedDamage());
        }
        event.setCanceled(false);
    }
}
