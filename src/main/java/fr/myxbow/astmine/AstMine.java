package fr.myxbow.astmine;

import fr.myxbow.astmine.COMMANDS.MineBuyCommand;
import fr.myxbow.astmine.COMMANDS.MinesCommand;
import fr.myxbow.astmine.EVENTS.EntityEvent;
import fr.myxbow.astmine.EVENTS.InventoryEvent;
import fr.myxbow.astmine.EVENTS.OtherEvent;
import fr.myxbow.astmine.GUI.Mines;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class AstMine extends JavaPlugin {

    public static Economy eco = null;
    public static Permission perm = null;

    private static AstMine instance;

    private Mines GuiMines;

    public static AstMine getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {

        instance = this;

        GuiMines = new Mines();

        if (!setupEconomy() ) {
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        setupPermission();
        setupEconomy();


        //Gui Mines
        getServer().getPluginManager().registerEvents(new Mines(), this);
        getServer().getPluginManager().registerEvents(new EntityEvent(), this);
        getServer().getPluginManager().registerEvents(new InventoryEvent(), this);
        getServer().getPluginManager().registerEvents(new OtherEvent(), this);

        getCommand("mine").setExecutor(new MinesCommand());
        getCommand("shop").setExecutor(new ShopCommand());
        getCommand("rankup").setExecutor(new MineBuyCommand());
    }


    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        eco = rsp.getProvider();
        return eco != null;
    }

    private boolean setupPermission() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perm = rsp.getProvider();
        return perm != null;
    }


    @Override
    public void onDisable() {
    }

    public Mines getGUIServer() {
        return GuiMines;
    }

}
