package fr.myxbow.astmine.EVENTS;

import fr.myxbow.astmine.AstMine;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerPortalEvent;

public class OtherEvent implements Listener {

    private final AstMine main = AstMine.getInstance();

    @EventHandler
    public void onPortal(PlayerPortalEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onAnnoucement(PlayerAchievementAwardedEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onSpawn(EntitySpawnEvent event){

        Entity e = event.getEntity();

        if(!(e instanceof Villager)){
            event.setCancelled(true);
        }
        if(!(e instanceof Player)){
            event.setCancelled(true);
        }

    }

}
