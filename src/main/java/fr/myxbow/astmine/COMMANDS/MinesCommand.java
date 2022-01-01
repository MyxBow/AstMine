package fr.myxbow.astmine.COMMANDS;

import fr.myxbow.astmine.AstMine;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MinesCommand implements CommandExecutor {

    private final AstMine main = AstMine.getInstance();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player player = (Player) sender;

        if(player instanceof Player){
            player.openInventory(main.getGUIServer().GUIMine());
        }

        return false;
    }
}
