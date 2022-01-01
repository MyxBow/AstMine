package fr.myxbow.astmine.EVENTS;

import fr.myxbow.astmine.AstMine;
import io.papermc.paper.event.entity.EntityMoveEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class EntityEvent implements Listener {

    private final AstMine main = AstMine.getInstance();

    @EventHandler
    public void onEntityMove(EntityMoveEvent e) {
        Entity t = e.getEntity();
        if (t instanceof Villager) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onClickOnVillager(PlayerInteractAtEntityEvent e) {

        Entity t = e.getRightClicked();
        Player p = e.getPlayer();

        if (t instanceof Villager) {
            if (t.getName().equals("Léo")) {
                e.setCancelled(true);
                p.openInventory((main.getGUIServer().GUIMine()));
            }

            if (t.getName().equals("Thomas")) {
                e.setCancelled(true);
                p.openInventory(main.getGUIServer().GUIShop());
            }

            if(t.getName().equals("Julien")){
                e.setCancelled(true);
                p.openInventory(main.getGUIServer().GUIBuyMine());
            }

        }

    }


}
