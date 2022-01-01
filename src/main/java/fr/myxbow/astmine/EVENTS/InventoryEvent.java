package fr.myxbow.astmine.EVENTS;

import fr.myxbow.astmine.AstMine;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class InventoryEvent implements Listener {

    private final AstMine main = AstMine.getInstance();

    //CLIQUE DANS LE GUI DES SELECTIONS DES MINES VIP
    @EventHandler
    public void OnClickOnZoneVIP(InventoryClickEvent e){
        if(e.getView().getTitle().equals("§a§lMine des Déchus & Anges")) {
            if (e.getCurrentItem() == null) return;
            e.setCancelled(true);
            if (e.getCurrentItem().getType().equals(Material.QUARTZ)) {
                if (e.getWhoClicked().hasPermission("quartz")) {

                    Location quartz = Objects.requireNonNull(Bukkit.getWorld("quartz")).getSpawnLocation();

                    e.getWhoClicked().teleport(quartz);

                } else {
                    e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §c§lVous n'avez pas le niveau requis.");
                }
            }
            if (e.getCurrentItem().getType().equals(Material.ANCIENT_DEBRIS)) {
                if (e.getWhoClicked().hasPermission("netherite")) {

                    Location netherite = Objects.requireNonNull(Bukkit.getWorld("netherite")).getSpawnLocation();

                    e.getWhoClicked().teleport(netherite);

                } else {
                    e.getWhoClicked().sendMessage("§7§lMiner§e§lJob§e§l §e§l» §c§lVous n'avez pas le niveau requis.");
                }
            }
        }
    }

    //CLIQUE DANS LE GUI POUR VENDRE SES RESSOURCES
    @EventHandler
    public void OnClickOnShopMinerais(InventoryClickEvent e) {
        if (e.getCurrentItem() == null) return;

        Inventory inv = e.getClickedInventory();
        Entity p = e.getWhoClicked();

        if (e.getView().getTitle().equals("§d§lMinerais")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null) {
                if (Objects.requireNonNull(e.getCurrentItem()).getType().equals(Material.STONE)) {
                    if (e.getClick().isLeftClick()) {
                        if (e.getWhoClicked().getInventory().contains(Material.STONE)) {
                            ItemStack c = new ItemStack(Material.STONE, 1);
                            e.getWhoClicked().getInventory().removeItem(c);
                            main.eco.depositPlayer((OfflinePlayer) e.getWhoClicked(), 00.50);
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre de la §7§lroche §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            p.sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    } else {
                        e.getWhoClicked().openInventory(main.getGUIServer().GuiShopMultiplerStone());
                    }
                }
                if (Objects.requireNonNull(e.getCurrentItem()).getType().equals(Material.COBBLESTONE)) {
                    e.setCancelled(true);
                    if (e.getClick().isLeftClick()) {
                        if (e.getWhoClicked().getInventory().contains(Material.COBBLESTONE, 1)) {
                            ItemStack cobble = new ItemStack(Material.COBBLESTONE, 1);
                            e.getWhoClicked().getInventory().removeItem(cobble);
                            main.eco.depositPlayer((OfflinePlayer) e.getWhoClicked(), 00.20);
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre de la §7§lPierre taillée §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            p.sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    } else {
                        e.getWhoClicked().openInventory(main.getGUIServer().GuiShopMultiplerCobble());
                    }
                }
                if (e.getCurrentItem().getType().equals(Material.COAL)) {
                    e.setCancelled(true);
                    if (e.getClick().isLeftClick()) {
                        if (e.getWhoClicked().getInventory().contains(Material.COAL)) {
                            ItemStack c = new ItemStack(Material.COAL, 1);
                            e.getWhoClicked().getInventory().removeItem(c);
                            main.eco.depositPlayer((OfflinePlayer) e.getWhoClicked(), 5);
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre du §8§lcharbon §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            p.sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    } else {
                        e.getWhoClicked().openInventory(main.getGUIServer().GuiShopMultiplerCoal());
                    }
                }
                if (e.getCurrentItem().getType().equals(Material.IRON_INGOT)) {
                    e.setCancelled(true);
                    if (e.getClick().isLeftClick()) {
                        if (e.getWhoClicked().getInventory().contains(Material.IRON_INGOT)) {
                            ItemStack ir = new ItemStack(Material.IRON_INGOT, 1);
                            e.getWhoClicked().getInventory().removeItem(ir);
                            main.eco.depositPlayer((OfflinePlayer) e.getWhoClicked(), 12);
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre du §7§lfer §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            p.sendMessage("§7§lMiner§e§lJob§e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    } else {
                        e.getWhoClicked().openInventory(main.getGUIServer().GuiShopMultiplerIron());
                    }
                }
                if (e.getCurrentItem().getType().equals(Material.GOLD_INGOT)) {
                    e.setCancelled(true);
                    if (e.getClick().isLeftClick()) {
                        if (e.getWhoClicked().getInventory().contains(Material.GOLD_INGOT)) {
                            ItemStack g = new ItemStack(Material.GOLD_INGOT, 1);
                            e.getWhoClicked().getInventory().removeItem(g);
                            main.eco.depositPlayer((OfflinePlayer) e.getWhoClicked(), 22);
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre de l'§e§lor §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            p.sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    } else {
                        e.getWhoClicked().openInventory(main.getGUIServer().GuiShopMultiplerGold());
                    }
                }

                if (e.getCurrentItem().getType().equals(Material.REDSTONE)) {
                    e.setCancelled(true);
                    if (e.getClick().isLeftClick()) {
                        if (e.getWhoClicked().getInventory().contains(Material.REDSTONE)) {
                            ItemStack r = new ItemStack(Material.REDSTONE, 1);
                            e.getWhoClicked().getInventory().removeItem(r);
                            main.eco.depositPlayer((OfflinePlayer) e.getWhoClicked(), 38);
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre de la §c§lredstone §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            p.sendMessage("§7§lMiner§e§lJob§e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    } else {
                        e.getWhoClicked().openInventory(main.getGUIServer().GuiShopMultiplerRedstone());
                    }
                }

                if (e.getCurrentItem().getType().equals(Material.LAPIS_LAZULI)) {
                    e.setCancelled(true);
                    if (e.getClick().isLeftClick()) {
                        if (e.getWhoClicked().getInventory().contains(Material.LAPIS_LAZULI)) {
                            ItemStack c = new ItemStack(Material.LAPIS_LAZULI, 1);
                            e.getWhoClicked().getInventory().removeItem(c);
                            main.eco.depositPlayer((OfflinePlayer) e.getWhoClicked(), 45);
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre du §3§lLapis §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            p.sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    } else {
                        e.getWhoClicked().openInventory(main.getGUIServer().GuiShopMultiplerLapis());
                    }
                }

                if (e.getCurrentItem().getType().equals(Material.DIAMOND)) {
                    e.setCancelled(true);
                    if (e.getClick().isLeftClick()) {
                        if (e.getWhoClicked().getInventory().contains(Material.DIAMOND)) {
                            ItemStack c = new ItemStack(Material.DIAMOND, 1);
                            e.getWhoClicked().getInventory().removeItem(c);
                            main.eco.depositPlayer((OfflinePlayer) e.getWhoClicked(), 55);
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre du §b§ldimant §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            p.sendMessage("§7§lMiner§e§lJob§e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    } else {
                        e.getWhoClicked().openInventory(main.getGUIServer().GuiShopMultiplerDiamond());
                    }
                }

                if (e.getCurrentItem().getType().equals(Material.EMERALD)) {
                    e.setCancelled(true);
                    if (e.getClick().isLeftClick()) {
                        if (e.getWhoClicked().getInventory().contains(Material.EMERALD)) {
                            ItemStack c = new ItemStack(Material.EMERALD, 1);
                            e.getWhoClicked().getInventory().removeItem(c);
                            main.eco.depositPlayer((OfflinePlayer) e.getWhoClicked(), 65);
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre de l'§a§lémeraude §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            p.sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    } else {
                        e.getWhoClicked().openInventory(main.getGUIServer().GuiShopMultiplerEmerald());
                    }
                }

                if (e.getCurrentItem().getType().equals(Material.ANCIENT_DEBRIS)) {
                    e.setCancelled(true);
                    if (e.getClick().isLeftClick()) {
                        if (e.getWhoClicked().getInventory().contains(Material.ANCIENT_DEBRIS)) {
                            ItemStack c = new ItemStack(Material.ANCIENT_DEBRIS, 1);
                            e.getWhoClicked().getInventory().removeItem(c);
                            main.eco.depositPlayer((OfflinePlayer) e.getWhoClicked(), 80);
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre du §7§lnetherite §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            p.sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    } else {
                        e.getWhoClicked().openInventory(main.getGUIServer().GuiShopMultiplerNetherite());
                    }
                }

                if (e.getCurrentItem().getType().equals(Material.QUARTZ)) {
                    e.setCancelled(true);
                    if (e.getClick().isLeftClick()) {
                        if (e.getWhoClicked().getInventory().contains(Material.QUARTZ)) {
                            ItemStack c = new ItemStack(Material.QUARTZ, 1);
                            e.getWhoClicked().getInventory().removeItem(c);
                            main.eco.depositPlayer((OfflinePlayer) e.getWhoClicked(), 75);
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre du §f§lquartz §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            p.sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    } else {
                        e.getWhoClicked().openInventory(main.getGUIServer().GuiShopMultiplerQuartz());
                    }
                }
            }
        }
    }

    //CLIQUE DANS LE GUI POUR ACHETER DES PIOCHES
    @EventHandler
    public void OnClickOnShopPioches(InventoryClickEvent e){
        if (e.getCurrentItem() == null) return;

        Inventory inv = e.getClickedInventory();
        Entity p = e.getWhoClicked();

        if (e.getView().getTitle().equals("§a§lLes pioches")) {
            e.setCancelled(true);
            if (p instanceof Player) {
                e.setCancelled(true);
                if (e.getCurrentItem() != null) {
                    if (Objects.requireNonNull(e.getCurrentItem()).getType().equals(Material.GOLDEN_PICKAXE)) {
                        if (main.eco.getBalance((OfflinePlayer) e.getWhoClicked()) >= 180) {

                            ItemStack or = new ItemStack(Material.GOLDEN_PICKAXE);
                            ItemMeta orMeta = or.getItemMeta();
                            orMeta.setDisplayName("§e§lPioche en or");
                            or.setItemMeta(orMeta);

                            e.getWhoClicked().getInventory().addItem(or);
                            main.eco.withdrawPlayer((OfflinePlayer) p, 180);
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez assez d'argent");
                        }
                    }
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§b§lPioche en diamant (320 AstCoins)")) {
                        e.setCancelled(true);
                        if (main.eco.getBalance((OfflinePlayer) e.getWhoClicked()) >= 320) {
                            ItemStack diams1 = new ItemStack(Material.DIAMOND_PICKAXE);
                            ItemMeta diams1Meta = diams1.getItemMeta();
                            diams1Meta.setDisplayName("§b§lPioche en diamant");
                            diams1.setItemMeta(diams1Meta);
                            e.getWhoClicked().getInventory().addItem(diams1);
                            main.eco.withdrawPlayer((OfflinePlayer) p, 320);
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez assez d'argent");
                        }
                    }
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§b§lPioche en diamant V2 (780 AstCoins)")) {
                        e.setCancelled(true);
                        if (main.eco.getBalance((OfflinePlayer) e.getWhoClicked()) >= 780) {
                            ItemStack diams2 = new ItemStack(Material.DIAMOND_PICKAXE);
                            ItemMeta diams2Meta = diams2.getItemMeta();
                            diams2Meta.setDisplayName("§b§lPioche en diamant V2");
                            diams2Meta.addEnchant(Enchantment.DIG_SPEED, 3, true);
                            diams2.setItemMeta(diams2Meta);
                            e.getWhoClicked().getInventory().addItem(diams2);
                            main.eco.withdrawPlayer((OfflinePlayer) p, 780);
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez assez d'argent");
                        }
                    }
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§b§lPioche en diamant V3 (830 AstCoins)")) {
                        e.setCancelled(true);
                        if (main.eco.getBalance((OfflinePlayer) e.getWhoClicked()) >= 830) {
                            e.setCancelled(true);
                            ItemStack diams3 = new ItemStack(Material.DIAMOND_PICKAXE);
                            ItemMeta diams3Meta = diams3.getItemMeta();
                            diams3Meta.setDisplayName("§b§lPioche en diamant V3");
                            diams3Meta.addEnchant(Enchantment.DIG_SPEED, 4, true);
                            diams3.setItemMeta(diams3Meta);
                            e.getWhoClicked().getInventory().addItem(diams3);
                            main.eco.withdrawPlayer((OfflinePlayer) p, 830);
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez assez d'argent");
                        }
                    }
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lPioche en netherite (1020 AstCoins)")) {
                        e.setCancelled(true);
                        if (main.eco.getBalance((OfflinePlayer) e.getWhoClicked()) >= 1020) {
                            ItemStack netherite = new ItemStack(Material.NETHERITE_PICKAXE);
                            ItemMeta netheriteMeta = netherite.getItemMeta();
                            netheriteMeta.setDisplayName("§7§lPioche en netherite");
                            netherite.setItemMeta(netheriteMeta);
                            e.getWhoClicked().getInventory().addItem(netherite);
                            main.eco.withdrawPlayer((OfflinePlayer) p, 1020);
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez assez d'argent");
                        }
                    }
                }
            }
        }
    }

    //CLIQUE DANS LE GUI POUR CHOISIR LA PARTIE DU MAGASIN
    @EventHandler
    public void OnClickOnShopCentral(InventoryClickEvent e){
        if (e.getCurrentItem() == null) return;

        Inventory inv = e.getClickedInventory();
        Entity p = e.getWhoClicked();

        if (e.getView().getTitle().equals("§a§lLe magasin")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null) {
                if (e.getCurrentItem().getType().equals(Material.COBBLESTONE)) {
                    e.setCancelled(true);
                    e.getWhoClicked().openInventory(main.getGUIServer().GUISellMinerais());
                }
                if (e.getCurrentItem().getType().equals(Material.IRON_PICKAXE)) {
                    e.setCancelled(true);
                    e.getWhoClicked().openInventory(main.getGUIServer().GUIShopPioche());
                }
            }
        }
    }

    //GUI CLIQUE DANS LES MULTIPLIER
    @EventHandler
    public void OnClickOnMultiplier(InventoryClickEvent e) {
        if (e.getCurrentItem() == null) return;

        if (e.getView().getTitle().equals("§a§lVendre du charbon")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null) {
                Entity p = e.getWhoClicked();
                if (p instanceof Player) {
                    ItemStack coal10 = new ItemStack(Material.COAL, 10);
                    ItemMeta coal10meta = coal10.getItemMeta();
                    coal10meta.setDisplayName("§a§lVendre par 10");
                    coal10.setItemMeta(coal10meta);

                    ItemStack coal32 = new ItemStack(Material.COAL, 32);
                    ItemMeta coal32meta = coal32.getItemMeta();
                    coal32meta.setDisplayName("§a§lVendre par 32");
                    coal32.setItemMeta(coal32meta);

                    ItemStack coal64 = new ItemStack(Material.COAL, 64);
                    ItemMeta coal64meta = coal64.getItemMeta();
                    coal64meta.setDisplayName("§a§lVendre par 64");
                    coal64.setItemMeta(coal64meta);

                    if (Objects.equals(e.getCurrentItem(), coal10)) {
                        if (((Player) p).getInventory().contains(Material.COAL, 10)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 50);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.COAL, 10));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre du §8§lcharbon §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                    if (e.getCurrentItem().equals(coal32)) {
                        if (e.getWhoClicked().getInventory().contains(Material.COAL, 32)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 160);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.COAL, 32));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre du §8§lcharbon §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                    if (e.getCurrentItem().equals(coal64)) {
                        if (e.getWhoClicked().getInventory().contains(Material.COAL, 64)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 320);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.COAL, 64));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre du §8§lcharbon §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                }
            }
        }
        if (e.getView().getTitle().equals("§a§lVendre du fer")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null) {
                Entity p = e.getWhoClicked();
                if (p instanceof Player) {
                    ItemStack coal10 = new ItemStack(Material.IRON_INGOT, 10);
                    ItemMeta coal10meta = coal10.getItemMeta();
                    coal10meta.setDisplayName("§a§lVendre par 10");
                    coal10.setItemMeta(coal10meta);

                    ItemStack coal32 = new ItemStack(Material.IRON_INGOT, 32);
                    ItemMeta coal32meta = coal32.getItemMeta();
                    coal32meta.setDisplayName("§a§lVendre par 32");
                    coal32.setItemMeta(coal32meta);

                    ItemStack coal64 = new ItemStack(Material.IRON_INGOT, 64);
                    ItemMeta coal64meta = coal64.getItemMeta();
                    coal64meta.setDisplayName("§a§lVendre par 64");
                    coal64.setItemMeta(coal64meta);

                    if (Objects.equals(e.getCurrentItem(), coal10)) {
                        if (((Player) p).getInventory().contains(Material.IRON_INGOT, 10)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 120);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.IRON_INGOT, 10));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre du §7§lfer §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                    if (e.getCurrentItem().equals(coal32)) {
                        if (e.getWhoClicked().getInventory().contains(Material.IRON_INGOT, 32)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 384);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.IRON_INGOT, 32));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre du §7§lfer §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                    if (e.getCurrentItem().equals(coal64)) {
                        if (e.getWhoClicked().getInventory().contains(Material.IRON_INGOT, 64)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 768);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.IRON_INGOT, 64));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre du §7§lfer §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                }
            }
        }
        if (e.getView().getTitle().equals("§a§lVendre de l'or")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null) {
                Entity p = e.getWhoClicked();
                if (p instanceof Player) {
                    ItemStack coal10 = new ItemStack(Material.GOLD_INGOT, 10);
                    ItemMeta coal10meta = coal10.getItemMeta();
                    coal10meta.setDisplayName("§a§lVendre par 10");
                    coal10.setItemMeta(coal10meta);

                    ItemStack coal32 = new ItemStack(Material.GOLD_INGOT, 32);
                    ItemMeta coal32meta = coal32.getItemMeta();
                    coal32meta.setDisplayName("§a§lVendre par 32");
                    coal32.setItemMeta(coal32meta);

                    ItemStack coal64 = new ItemStack(Material.GOLD_INGOT, 64);
                    ItemMeta coal64meta = coal64.getItemMeta();
                    coal64meta.setDisplayName("§a§lVendre par 64");
                    coal64.setItemMeta(coal64meta);

                    if (Objects.equals(e.getCurrentItem(), coal10)) {
                        if (e.getWhoClicked().getInventory().contains(Material.GOLD_INGOT, 10)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 220);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.GOLD_INGOT, 10));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre de l'§e§lor §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                    if (e.getCurrentItem().equals(coal32)) {
                        if (e.getWhoClicked().getInventory().contains(Material.GOLD_INGOT, 32)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 704);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.GOLD_INGOT, 32));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob§e§l» §7Vous venez de vendre de l'§e§lor §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                    if (e.getCurrentItem().equals(coal64)) {
                        if (e.getWhoClicked().getInventory().contains(Material.GOLD_INGOT, 64)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 1408);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.GOLD_INGOT, 64));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre de l'§e§lor §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                }
            }
        }
        if (e.getView().getTitle().equals("§a§lVendre de la redstone")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null) {
                Entity p = e.getWhoClicked();
                if (p instanceof Player) {
                    ItemStack coal10 = new ItemStack(Material.REDSTONE, 10);
                    ItemMeta coal10meta = coal10.getItemMeta();
                    coal10meta.setDisplayName("§a§lVendre par 10");
                    coal10.setItemMeta(coal10meta);

                    ItemStack coal32 = new ItemStack(Material.REDSTONE, 32);
                    ItemMeta coal32meta = coal32.getItemMeta();
                    coal32meta.setDisplayName("§a§lVendre par 32");
                    coal32.setItemMeta(coal32meta);

                    ItemStack coal64 = new ItemStack(Material.REDSTONE, 64);
                    ItemMeta coal64meta = coal64.getItemMeta();
                    coal64meta.setDisplayName("§a§lVendre par 64");
                    coal64.setItemMeta(coal64meta);

                    if (Objects.equals(e.getCurrentItem(), coal10)) {
                        if (e.getWhoClicked().getInventory().contains(Material.REDSTONE, 10)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 380);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.REDSTONE, 10));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre de la §c§lredstone §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                    if (e.getCurrentItem().equals(coal32)) {
                        if (e.getWhoClicked().getInventory().contains(Material.REDSTONE, 32)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 1216);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.REDSTONE, 32));
                            e.getWhoClicked().sendMessage("§7§lBalthazar §e§l» §7Vous venez de vendre de la §c§lredstone §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                    if (e.getCurrentItem().equals(coal64)) {
                        if (e.getWhoClicked().getInventory().contains(Material.REDSTONE, 64)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 2432);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.REDSTONE, 64));
                            e.getWhoClicked().sendMessage("§7§lBalthazar §e§l» §7Vous venez de vendre de la §c§lredstone §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                }
            }
        }
        if (e.getView().getTitle().equals("§a§lVendre du lapis")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null) {
                Entity p = e.getWhoClicked();
                if (p instanceof Player) {
                    ItemStack coal10 = new ItemStack(Material.LAPIS_LAZULI, 10);
                    ItemMeta coal10meta = coal10.getItemMeta();
                    coal10meta.setDisplayName("§a§lVendre par 10");
                    coal10.setItemMeta(coal10meta);

                    ItemStack coal32 = new ItemStack(Material.LAPIS_LAZULI, 32);
                    ItemMeta coal32meta = coal32.getItemMeta();
                    coal32meta.setDisplayName("§a§lVendre par 32");
                    coal32.setItemMeta(coal32meta);

                    ItemStack coal64 = new ItemStack(Material.LAPIS_LAZULI, 64);
                    ItemMeta coal64meta = coal64.getItemMeta();
                    coal64meta.setDisplayName("§a§lVendre par 64");
                    coal64.setItemMeta(coal64meta);

                    if (Objects.equals(e.getCurrentItem(), coal10)) {
                        if (e.getWhoClicked().getInventory().contains(Material.LAPIS_LAZULI, 10)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 450);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.LAPIS_LAZULI, 10));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre du §3§llapis §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                    if (e.getCurrentItem().equals(coal32)) {
                        if (e.getWhoClicked().getInventory().contains(Material.LAPIS_LAZULI, 32)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 1440);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.LAPIS_LAZULI, 32));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre du §3§llapis §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                    if (e.getCurrentItem().equals(coal64)) {
                        if (e.getWhoClicked().getInventory().contains(Material.LAPIS_LAZULI, 64)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 2880);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.LAPIS_LAZULI, 64));
                            e.getWhoClicked().sendMessage("§7§lBalthazar §e§l» §7Vous venez de vendre du §3§llapis §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                }
            }
        }
        if (e.getView().getTitle().equals("§a§lVendre du diamant")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null) {
                Entity p = e.getWhoClicked();
                if (p instanceof Player) {
                    ItemStack coal10 = new ItemStack(Material.DIAMOND, 10);
                    ItemMeta coal10meta = coal10.getItemMeta();
                    coal10meta.setDisplayName("§a§lVendre par 10");
                    coal10.setItemMeta(coal10meta);

                    ItemStack coal32 = new ItemStack(Material.DIAMOND, 32);
                    ItemMeta coal32meta = coal32.getItemMeta();
                    coal32meta.setDisplayName("§a§lVendre par 32");
                    coal32.setItemMeta(coal32meta);

                    ItemStack coal64 = new ItemStack(Material.DIAMOND, 64);
                    ItemMeta coal64meta = coal64.getItemMeta();
                    coal64meta.setDisplayName("§a§lVendre par 64");
                    coal64.setItemMeta(coal64meta);

                    if (Objects.equals(e.getCurrentItem(), coal10)) {
                        if (e.getWhoClicked().getInventory().contains(Material.DIAMOND, 10)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 550);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.DIAMOND, 10));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre du §b§diamant §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                    if (e.getCurrentItem().equals(coal32)) {
                        if (e.getWhoClicked().getInventory().contains(Material.DIAMOND, 32)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 1760);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.DIAMOND, 32));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre du §b§diamant §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                    if (e.getCurrentItem().equals(coal64)) {
                        if (((Player) p).getInventory().contains(Material.DIAMOND, 64)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 3520);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.DIAMOND, 64));
                            e.getWhoClicked().sendMessage("§7§lBalthazar §e§l» §7Vous venez de vendre du §b§diamant §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                }
            }
        }
        if (e.getView().getTitle().equals("§a§lVendre de l'émeraude")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null) {
                Entity p = e.getWhoClicked();
                if (p instanceof Player) {
                    ItemStack coal10 = new ItemStack(Material.EMERALD, 10);
                    ItemMeta coal10meta = coal10.getItemMeta();
                    coal10meta.setDisplayName("§a§lVendre par 10");
                    coal10.setItemMeta(coal10meta);

                    ItemStack coal32 = new ItemStack(Material.EMERALD, 32);
                    ItemMeta coal32meta = coal32.getItemMeta();
                    coal32meta.setDisplayName("§a§lVendre par 32");
                    coal32.setItemMeta(coal32meta);

                    ItemStack coal64 = new ItemStack(Material.EMERALD, 64);
                    ItemMeta coal64meta = coal64.getItemMeta();
                    coal64meta.setDisplayName("§a§lVendre par 64");
                    coal64.setItemMeta(coal64meta);

                    if (Objects.equals(e.getCurrentItem(), coal10)) {
                        if (e.getWhoClicked().getInventory().contains(Material.EMERALD, 10)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 650);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.EMERALD, 10));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre de l'§a§lémeraude §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                    if (e.getCurrentItem().equals(coal32)) {
                        if (e.getWhoClicked().getInventory().contains(Material.EMERALD, 32)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 2080);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.EMERALD, 32));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre de l'§a§lémeraude §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                    if (e.getCurrentItem().equals(coal64)) {
                        if (e.getWhoClicked().getInventory().contains(Material.EMERALD, 64)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 4160);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.EMERALD, 64));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre de l'§a§lémeraude §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                }
            }
        }
        if (e.getView().getTitle().equals("§a§lVendre du quartz")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null) {
                Entity p = e.getWhoClicked();
                if (p instanceof Player) {
                    ItemStack coal10 = new ItemStack(Material.QUARTZ, 10);
                    ItemMeta coal10meta = coal10.getItemMeta();
                    coal10meta.setDisplayName("§a§lVendre par 10");
                    coal10.setItemMeta(coal10meta);

                    ItemStack coal32 = new ItemStack(Material.QUARTZ, 32);
                    ItemMeta coal32meta = coal32.getItemMeta();
                    coal32meta.setDisplayName("§a§lVendre par 32");
                    coal32.setItemMeta(coal32meta);

                    ItemStack coal64 = new ItemStack(Material.QUARTZ, 64);
                    ItemMeta coal64meta = coal64.getItemMeta();
                    coal64meta.setDisplayName("§a§lVendre par 64");
                    coal64.setItemMeta(coal64meta);

                    if (Objects.equals(e.getCurrentItem(), coal10)) {
                        if (e.getWhoClicked().getInventory().contains(Material.QUARTZ, 10)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 750);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.QUARTZ, 10));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob§e§l» §7Vous venez de vendre du du §f§lquartz §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                    if (e.getCurrentItem().equals(coal32)) {
                        if (e.getWhoClicked().getInventory().contains(Material.QUARTZ, 32)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 2400);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.QUARTZ, 32));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre du §f§lquartz §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            p.sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                    if (e.getCurrentItem().equals(coal64)) {
                        if (e.getWhoClicked().getInventory().contains(Material.QUARTZ, 64)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 4800);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.QUARTZ, 64));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre du du §f§lquartz §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                }
            }
        }
        if (e.getView().getTitle().equals("§a§lVendre de la netherite")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null) {
                Entity p = e.getWhoClicked();
                if (p instanceof Player) {
                    ItemStack coal10 = new ItemStack(Material.ANCIENT_DEBRIS, 10);
                    ItemMeta coal10meta = coal10.getItemMeta();
                    coal10meta.setDisplayName("§a§lVendre par 10");
                    coal10.setItemMeta(coal10meta);

                    ItemStack coal32 = new ItemStack(Material.ANCIENT_DEBRIS, 32);
                    ItemMeta coal32meta = coal32.getItemMeta();
                    coal32meta.setDisplayName("§a§lVendre par 32");
                    coal32.setItemMeta(coal32meta);

                    ItemStack coal64 = new ItemStack(Material.ANCIENT_DEBRIS, 64);
                    ItemMeta coal64meta = coal64.getItemMeta();
                    coal64meta.setDisplayName("§a§lVendre par 64");
                    coal64.setItemMeta(coal64meta);

                    if (Objects.equals(e.getCurrentItem(), coal10)) {
                        if (e.getWhoClicked().getInventory().contains(Material.ANCIENT_DEBRIS, 10)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 800);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.ANCIENT_DEBRIS, 10));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre de la §7§lnetherite §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                    if (e.getCurrentItem().equals(coal32)) {
                        if (e.getWhoClicked().getInventory().contains(Material.ANCIENT_DEBRIS, 32)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 2560);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.ANCIENT_DEBRIS, 32));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre de la §7§lnetherite §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                    if (e.getCurrentItem().equals(coal64)) {
                        if (e.getWhoClicked().getInventory().contains(Material.ANCIENT_DEBRIS, 64)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 5120);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.ANCIENT_DEBRIS, 64));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre de la §7§lnetherite §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                }
            }
        }
        if (e.getView().getTitle().equals("§a§lVendre de la roche")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null) {
                Entity p = e.getWhoClicked();
                if (p instanceof Player) {
                    ItemStack coal10 = new ItemStack(Material.STONE, 10);
                    ItemMeta coal10meta = coal10.getItemMeta();
                    coal10meta.setDisplayName("§a§lVendre par 10");
                    coal10.setItemMeta(coal10meta);

                    ItemStack coal32 = new ItemStack(Material.STONE, 32);
                    ItemMeta coal32meta = coal32.getItemMeta();
                    coal32meta.setDisplayName("§a§lVendre par 32");
                    coal32.setItemMeta(coal32meta);

                    ItemStack coal64 = new ItemStack(Material.STONE, 64);
                    ItemMeta coal64meta = coal64.getItemMeta();
                    coal64meta.setDisplayName("§a§lVendre par 64");
                    coal64.setItemMeta(coal64meta);

                    if (Objects.equals(e.getCurrentItem(), coal10)) {
                        if (e.getWhoClicked().getInventory().contains(Material.STONE, 10)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 5);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.STONE, 10));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre de la §7§lroche §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                    if (e.getCurrentItem().equals(coal32)) {
                        if (e.getWhoClicked().getInventory().contains(Material.STONE, 32)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 16);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.STONE, 32));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre de la §7§lroche §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                    if (e.getCurrentItem().equals(coal64)) {
                        if (e.getWhoClicked().getInventory().contains(Material.STONE, 64)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 32);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.STONE, 64));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre de la §7§lroche §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                }
            }
        }
        if (e.getView().getTitle().equals("§a§lVendre de la pierre taillé")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null) {
                Entity p = e.getWhoClicked();
                if (p instanceof Player) {
                    ItemStack coal10 = new ItemStack(Material.COBBLESTONE, 10);
                    ItemMeta coal10meta = coal10.getItemMeta();
                    coal10meta.setDisplayName("§a§lVendre par 10");
                    coal10.setItemMeta(coal10meta);

                    ItemStack coal32 = new ItemStack(Material.COBBLESTONE, 32);
                    ItemMeta coal32meta = coal32.getItemMeta();
                    coal32meta.setDisplayName("§a§lVendre par 32");
                    coal32.setItemMeta(coal32meta);

                    ItemStack coal64 = new ItemStack(Material.COBBLESTONE, 64);
                    ItemMeta coal64meta = coal64.getItemMeta();
                    coal64meta.setDisplayName("§a§lVendre par 64");
                    coal64.setItemMeta(coal64meta);

                    if (Objects.equals(e.getCurrentItem(), coal10)) {
                        if (e.getWhoClicked().getInventory().contains(Material.COBBLESTONE, 10)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 5);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.COBBLESTONE, 10));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre de la §8§lpierre taillé §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                    if (e.getCurrentItem().equals(coal32)) {
                        if (e.getWhoClicked().getInventory().contains(Material.COBBLESTONE, 32)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 16);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.COBBLESTONE, 32));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre de la §8§lpierre taillé §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                    if (e.getCurrentItem().equals(coal64)) {
                        if (e.getWhoClicked().getInventory().contains(Material.COBBLESTONE, 64)) {
                            main.eco.depositPlayer((OfflinePlayer) p, 32);
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.COBBLESTONE, 64));
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §7Vous venez de vendre de la §8§lpierre taillé §7vous avez §b" + main.eco.getBalance((OfflinePlayer) e.getWhoClicked()));
                        } else {
                            e.getWhoClicked().sendMessage("§7§lMiner§e§lJobr §e§l» §cVous n'avez pas la ressource demandée.");
                        }
                    }
                }
            }
        }
    }

    //GUI CLIQUE DANS LE SELECTEUR DE MINES
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getCurrentItem() == null) return;

        Inventory inv = e.getClickedInventory();
        Entity p = e.getWhoClicked();
        Location coal = Objects.requireNonNull(Bukkit.getWorld("coal")).getSpawnLocation();
        Location iron = Objects.requireNonNull(Bukkit.getWorld("iron")).getSpawnLocation();
        Location gold = Objects.requireNonNull(Bukkit.getWorld("gold")).getSpawnLocation();
        Location redstone = Objects.requireNonNull(Bukkit.getWorld("redstone")).getSpawnLocation();
        Location lapis = Objects.requireNonNull(Bukkit.getWorld("lapis")).getSpawnLocation();
        Location diamant = Objects.requireNonNull(Bukkit.getWorld("diamant")).getSpawnLocation();
        Location emeraude = Objects.requireNonNull(Bukkit.getWorld("emeraude")).getSpawnLocation();

        if (e.getView().getTitle().equals("§a§lLes zones")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null) {
                if (Objects.requireNonNull(e.getCurrentItem()).getType().equals(Material.COAL)) {
                    e.getWhoClicked().teleport(coal);
                }
                if (e.getCurrentItem().getType().equals(Material.IRON_INGOT)) {
                    if (e.getWhoClicked().hasPermission("iron")) {
                        e.getWhoClicked().teleport(iron);
                    } else {
                        e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §c§lVous n'avez pas le niveau requis.");
                    }
                }
                if (e.getCurrentItem().getType().equals(Material.GOLD_INGOT)) {
                    if (e.getWhoClicked().hasPermission("gold")) {
                        e.getWhoClicked().teleport(gold);
                    } else {
                        e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §c§lVous n'avez pas le niveau requis.");
                    }
                }
                if (e.getCurrentItem().getType().equals(Material.REDSTONE)) {
                    if (e.getWhoClicked().hasPermission("redstone")) {
                        e.getWhoClicked().teleport(redstone);
                    } else {
                        e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §c§lVous n'avez pas le niveau requis.");
                    }
                }
                if (e.getCurrentItem().getType().equals(Material.LAPIS_LAZULI)) {
                    ;
                    if (e.getWhoClicked().hasPermission("lapis")) {
                        e.getWhoClicked().teleport(lapis);
                    } else {
                        e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §c§lVous n'avez pas le niveau requis.");
                    }
                }
                if (e.getCurrentItem().getType().equals(Material.DIAMOND)) {
                    if (e.getWhoClicked().hasPermission("diamant")) {
                        e.getWhoClicked().teleport(diamant);
                    } else {
                        e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §c§lVous n'avez pas le niveau requis.");
                    }
                }
                if (e.getCurrentItem().getType().equals(Material.EMERALD)) {
                    if (e.getWhoClicked().hasPermission("emeraude")) {
                        e.getWhoClicked().teleport(emeraude);
                    } else {
                        e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §c§lVous n'avez pas le niveau requis.");
                    }
                }
                if (e.getCurrentItem().getType().equals(Material.IRON_SWORD)) {
                    if (e.getWhoClicked().hasPermission("vip")) {
                        e.getWhoClicked().openInventory(main.getGUIServer().GUIZoneVIP());
                    } else {
                        e.getWhoClicked().sendMessage(("§7§lMiner§e§lJob §e§l» §c§lVous n'êtes pas déchu, ange ou ange suprême !"));
                    }
                }
            }
        }
    }

    //ACHETER DES MINES
    @EventHandler
    public void onClique(InventoryClickEvent e){
        if (e.getCurrentItem() == null) return;

        Inventory inv = e.getClickedInventory();
        ItemStack i = e.getCurrentItem();
        Player p = (Player) e.getWhoClicked();

        if(e.getView().getTitle().equals("§2§lAcheter une zone")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null) {
                if (Objects.requireNonNull(e.getCurrentItem()).getType().equals(Material.IRON_INGOT)) {
                    if (!(e.getWhoClicked().hasPermission("iron"))) {
                        if (main.eco.getBalance((Player) e.getWhoClicked()) >= 1000) {
                            main.perm.playerAdd(null, (OfflinePlayer) e.getWhoClicked(), "iron");
                            p.sendMessage("§7§lMiner§e§lJob §e§l» §aopus venez de débloquer la mine du §7§lFer §a!");
                            Bukkit.broadcastMessage("§7§lMiner§e§lJob §e§l» §b§l" + p.getDisplayName() + " §aviens de débloquer la mine du §7§lFer §a!");
                            main.eco.withdrawPlayer((Player) e.getWhoClicked(), 1000);
                        } else {
                            p.sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas assez d'argent !");
                        }
                    } else {
                        e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous avez déjà cette mine !");
                    }
                }
                if (e.getCurrentItem().getType().equals(Material.GOLD_INGOT)) {
                    if (!(e.getWhoClicked().hasPermission(""))) {
                        if (main.eco.getBalance((Player) e.getWhoClicked()) >= 5000) {
                            main.perm.playerAdd(null, (OfflinePlayer) e.getWhoClicked(), "gold");
                            p.sendMessage("§7§lMiner§e§lJob §e§l» §aVous venez de débloquer la mine de l'§e§lOr §a!");
                            Bukkit.broadcastMessage("§7§lMiner§e§lJob §e§l» §b§l" + p.getDisplayName() + " §aviens de débloquer la mine de l'§e§lOr §a!");
                            main.eco.withdrawPlayer((Player) e.getWhoClicked(), 5000);
                        } else {
                            p.sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas assez d'argent !");
                        }
                    } else {
                        e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous avez déjà cette mine !");
                    }
                }

                if (e.getCurrentItem().getType().equals(Material.REDSTONE)) {
                    if (!(e.getWhoClicked().hasPermission("redstone"))) {
                        if (main.eco.getBalance((Player) e.getWhoClicked()) >= 12000) {
                            main.perm.playerAdd(null, (OfflinePlayer) e.getWhoClicked(), "redstone");
                            p.sendMessage("§7§lMiner§e§lJob §e§l» §aVous venez de débloquer la mine de la §c§lRedStone §a!");
                            Bukkit.broadcastMessage("§7§lMiner§e§lJobr §e§l» §b§l" + p.getDisplayName() + " §aviens de débloquer la mine de la §c§lRedstone §a!");
                            main.eco.withdrawPlayer((Player) e.getWhoClicked(), 12000);
                        } else {
                            p.sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas assez d'argent !");
                        }
                    } else {
                        e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous avez déjà cette mine !");
                    }
                }
                if (e.getCurrentItem().getType().equals(Material.LAPIS_LAZULI)) {
                    if (!(e.getWhoClicked().hasPermission("lapis"))) {
                        if (main.eco.getBalance((Player) e.getWhoClicked()) >= 39000) {
                            main.perm.playerAdd(null, (OfflinePlayer) e.getWhoClicked(), "lapis");
                            p.sendMessage("§7§lMiner§e§lJob §e§l» §aVous venez de débloquer la mine du §3§lLapis §a!");
                            Bukkit.broadcastMessage("§7§lMiner§e§lJob §e§l» §b§l" + p.getDisplayName() + " §aviens de débloquer la mine du §3§lLapis §a!");
                            main.eco.withdrawPlayer((Player) e.getWhoClicked(), 39000);
                        } else {
                            p.sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas assez d'argent !");
                        }
                    } else {
                        e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous avez déjà cette mine !");
                    }
                }
                if (e.getCurrentItem().getType().equals(Material.DIAMOND)) {
                    if (!(e.getWhoClicked().hasPermission("diamant"))) {
                        if (main.eco.getBalance((Player) e.getWhoClicked()) >= 58000) {
                            main.perm.playerAdd(null, (OfflinePlayer) e.getWhoClicked(), "diamant");
                            p.sendMessage("§7§lMiner§e§lJob §e§l» §aVous venez de débloquer la mine du §b§lDiamant §a!");
                            Bukkit.broadcastMessage("§7§lMiner§e§lJob §e§l» §b§l" + p.getDisplayName() + " §aviens de débloquer la mine du §b§lDiamant §a!");
                            main.eco.withdrawPlayer((Player) e.getWhoClicked(), 58000);
                        } else {
                            p.sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas assez d'argent !");
                        }
                    } else {
                        e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous avez déjà cette mine !");
                    }
                }
                if (e.getCurrentItem().getType().equals(Material.EMERALD)) {
                    if (!(e.getWhoClicked()).hasPermission("emeraude")) {
                        if (main.eco.getBalance((Player) e.getWhoClicked()) >= 70000) {
                            main.perm.playerAdd(null, (OfflinePlayer) e.getWhoClicked(), "emeraude");
                            p.sendMessage("§7§lMiner§e§lJob §e§l» §aVous venez de débloquer la mine des §2§lÉmeraudes §a!");
                            Bukkit.broadcastMessage("§7§lMiner§e§lJob §e§l» §b§l" + p.getDisplayName() + " §aviens de débloquer la mine des §2§lÉmeraudes §a!");
                            main.eco.withdrawPlayer((Player) e.getWhoClicked(), 70000);
                        } else {
                            p.sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas assez d'argent !");
                        }
                    } else {
                        e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous avez déjà cette mine !");
                    }
                }
                if (e.getCurrentItem().getType().equals(Material.ANCIENT_DEBRIS)) {
                    if (!(e.getWhoClicked()).hasPermission("netherite")) {
                        if (main.eco.getBalance((Player) e.getWhoClicked()) >= 350000) {
                            main.perm.playerAdd(null, (OfflinePlayer) e.getWhoClicked(), "netherite");
                            p.sendMessage("§7§lBalthazar §e§l» §aVous venez de débloquer la mine des §7§lNetherite §a!");
                            Bukkit.broadcastMessage("§7§lBalthazar §e§l» §b§l" + p.getDisplayName() + " §aviens de débloquer la mine des §7§lNetherite §a!");
                            main.eco.withdrawPlayer((Player) e.getWhoClicked(), 350000);
                        } else {
                            p.sendMessage("§7§lBalthazar §e§l» §cVous n'avez pas assez d'argent !");
                        }
                    } else {
                        e.getWhoClicked().sendMessage("§7§lBalthazar §e§l» §cVous avez déjà cette mine !");
                    }
                }
                if (e.getCurrentItem().getType().equals(Material.QUARTZ)) {
                    if (!(e.getWhoClicked()).hasPermission("quartz")) {
                        if (main.eco.getBalance((Player) e.getWhoClicked()) >= 120000) {
                            main.perm.playerAdd(null, (OfflinePlayer) e.getWhoClicked(), "quartz");
                            p.sendMessage("§7§lMiner§e§lJob §e§l» §aVous venez de débloquer la mine du §f§lQuartz §a!");
                            Bukkit.broadcastMessage("§7§lMiner§e§lJob §e§l» §b§l" + p.getDisplayName() + " §aviens de débloquer la mine des §f§lQuartz §a!");
                            main.eco.withdrawPlayer((Player) e.getWhoClicked(), 120000);
                        } else {
                            p.sendMessage("§7§lMiner§e§lJob §e§l» §cVous n'avez pas assez d'argent !");
                        }
                    } else {
                        e.getWhoClicked().sendMessage("§7§lMiner§e§lJob §e§l» §cVous avez déjà cette mine !");
                    }
                }
            }
        }
    }


}
