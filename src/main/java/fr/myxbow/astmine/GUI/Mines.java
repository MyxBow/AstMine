package fr.myxbow.astmine.GUI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Mines implements Listener {

    //GUI acheter une zone
    public Inventory GUIBuyMine() {

        Inventory gui = Bukkit.createInventory(null, 45, "§2§lAcheter une zone");

        //Niveau 1
        ItemStack coal = new ItemStack(Material.COAL, 1);
        ItemMeta coalMeta = coal.getItemMeta();
        coalMeta.setDisplayName("§8§lZone du charbon");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("§eNiveau 1, gratuit.");
        coalMeta.setLore(lore);
        coal.setItemMeta(coalMeta);

        //Niveau 2
        ItemStack iron = new ItemStack(Material.IRON_INGOT, 2);
        ItemMeta ironMeta = iron.getItemMeta();
        ironMeta.setDisplayName("§7§lZone du fer");
        ArrayList<String> ironLore = new ArrayList<String>();
        ironLore.add("§eNiveau 2, 1.000 AstCoins !");
        ironMeta.setLore(ironLore);
        iron.setItemMeta(ironMeta);

        //Niveau 3
        ItemStack gold = new ItemStack(Material.GOLD_INGOT, 3);
        ItemMeta goldMeta = gold.getItemMeta();
        goldMeta.setDisplayName("§e§lZone d'or");
        ArrayList<String> goldLore = new ArrayList<String>();
        goldLore.add("§eNiveau 3, 5.000 AstCoins !");
        goldMeta.setLore(goldLore);
        gold.setItemMeta(goldMeta);

        //Niveau 4
        ItemStack s = new ItemStack(Material.REDSTONE, 4);
        ItemMeta S = s.getItemMeta();
        S.setDisplayName("§c§lZone de la redstone");
        ArrayList<String> slore = new ArrayList<String>();
        slore.add("§eNiveau 4, 12.000 AstCoins !");
        S.setLore(slore);
        s.setItemMeta(S);

        //Niveau 6
        ItemStack l = new ItemStack(Material.LAPIS_LAZULI, 6);
        ItemMeta L = l.getItemMeta();
        L.setDisplayName("§3§lZone du lapis");
        ArrayList<String> ll = new ArrayList<String>();
        ll.add("§eNiveau 6, 39.000 AstCoins !");
        L.setLore(ll);
        l.setItemMeta(L);

        //Niveau 7
        ItemStack d = new ItemStack(Material.DIAMOND, 7);
        ItemMeta D = d.getItemMeta();
        D.setDisplayName("§b§lZone des diamants");
        ArrayList<String> dl = new ArrayList<String>();
        dl.add("§eNiveau 7, 58.000 AstCoins !");
        D.setLore(dl);
        d.setItemMeta(D);

        //Niveau 8
        ItemStack e = new ItemStack(Material.EMERALD, 8);
        ItemMeta E = e.getItemMeta();
        E.setDisplayName("§a§lZone des émeraudes");
        ArrayList<String> el = new ArrayList<String>();
        el.add("§eNiveau 8, 70.000 AstCoins !");
        E.setLore(el);
        e.setItemMeta(E);

        ItemStack quartz = new ItemStack(Material.QUARTZ);
        ItemMeta Quartz = quartz.getItemMeta();
        Quartz.setDisplayName("§f§lMine du quartz");
        ArrayList<String> QuartzLore = new ArrayList<String>();
        QuartzLore.add("§eNiveau 8, 120.000 AstCoins !");
        Quartz.setLore(QuartzLore);
        quartz.setItemMeta(Quartz);

        ItemStack netherite = new ItemStack(Material.ANCIENT_DEBRIS);
        ItemMeta Netherite = netherite.getItemMeta();
        Quartz.setDisplayName("§f§lMine du quartz");
        ArrayList<String> NetheriteLore = new ArrayList<String>();
        NetheriteLore.add("§eNiveau 8, 350.000 AstCoins !");
        Netherite.setLore(NetheriteLore);
        Netherite.setDisplayName("§7§lMine des netherites");
        netherite.setItemMeta(Netherite);

        gui.setItem(25, netherite);
        gui.setItem(23, quartz);
        gui.setItem(21, e);
        gui.setItem(19, d);
        gui.setItem(17, l);
        gui.setItem(15, s);
        gui.setItem(13, gold);
        gui.setItem(11, iron);
        gui.setItem(9, coal);

        return gui;
    }

    //GUI Zone VIP
    public @NotNull Inventory GUIZoneVIP(){
        Inventory GuiVIP = Bukkit.createInventory(null, 27, "§a§lMine des Déchus & Anges");

        ItemStack quartz = new ItemStack(Material.QUARTZ);
        ItemMeta Quartz = quartz.getItemMeta();
        Quartz.setDisplayName("§f§lMine du quartz");
        quartz.setItemMeta(Quartz);

        ItemStack netherite = new ItemStack(Material.ANCIENT_DEBRIS);
        ItemMeta Netherite = netherite.getItemMeta();
        Netherite.setDisplayName("§7§lMine des netherites");
        netherite.setItemMeta(Netherite);

        GuiVIP.setItem(0, quartz);
        GuiVIP.setItem(2, netherite);

        return GuiVIP;
    }

    //GUI Vendre ses minerais
    public Inventory GUISellMinerais() {

        Inventory gui = Bukkit.createInventory(null, 45, "§d§lMinerais");

        //Stone
        ItemStack Stone = new ItemStack(Material.STONE);
        ItemMeta StoneMeta = Stone.getItemMeta();
        StoneMeta.setDisplayName("§7§lRoche");
        ArrayList<String> StoneLore =  new ArrayList<String>();
        StoneLore.add("§e0.50/Unité");
        StoneMeta.setLore(StoneLore);
        Stone.setItemMeta(StoneMeta);

        //Cobblestone
        ItemStack Cobblestone = new ItemStack(Material.COBBLESTONE);
        ItemMeta CobblestoneMeta = Cobblestone.getItemMeta();
        CobblestoneMeta.setDisplayName("§8§lPierre taillé");
        ArrayList<String> CobblestoneLore =  new ArrayList<String>();
        CobblestoneLore.add("§e0.50/Unité");
        CobblestoneMeta.setLore(CobblestoneLore);
        Cobblestone.setItemMeta(CobblestoneMeta);

        //Coal
        ItemStack Coal = new ItemStack(Material.COAL);
        ItemMeta CoalMeta = Coal.getItemMeta();
        CoalMeta.setDisplayName("§8§lCharbon");
        ArrayList<String> CoalLore =  new ArrayList<String>();
        CoalLore.add("§e5/Unité");
        CoalMeta.setLore(CoalLore);
        Coal.setItemMeta(CoalMeta);

        //Iron
        ItemStack Iron = new ItemStack(Material.IRON_INGOT);
        ItemMeta IronMeta = Iron.getItemMeta();
        IronMeta.setDisplayName("§7§lFer");
        ArrayList<String> IronLore =  new ArrayList<String>();
        IronLore.add("§e12/Unité");
        IronMeta.setLore(IronLore);
        Iron.setItemMeta(IronMeta);

        //Gold
        ItemStack Gold = new ItemStack(Material.GOLD_INGOT);
        ItemMeta GoldMeta = Gold.getItemMeta();
        GoldMeta.setDisplayName("§6§lOr");
        ArrayList<String> GoldLore =  new ArrayList<String>();
        GoldLore.add("§e22/Unité");
        GoldMeta.setLore(GoldLore);
        Gold.setItemMeta(GoldMeta);

        //Redstone
        ItemStack Redstone = new ItemStack(Material.REDSTONE);
        ItemMeta RedstoneMeta = Redstone.getItemMeta();
        RedstoneMeta.setDisplayName("§c§lRedstone");
        ArrayList<String> RedstoneLore =  new ArrayList<String>();
        RedstoneLore.add("§e38/Unité");
        RedstoneMeta.setLore(RedstoneLore);
        Redstone.setItemMeta(RedstoneMeta);

        //Lapis
        ItemStack Lapis = new ItemStack(Material.LAPIS_LAZULI);
        ItemMeta LapisMeta = Lapis.getItemMeta();
        LapisMeta.setDisplayName("§3§lLapis");
        ArrayList<String> LapisLore =  new ArrayList<String>();
        LapisLore.add("§e45/Unité");
        LapisMeta.setLore(LapisLore);
        Lapis.setItemMeta(LapisMeta);

        //Diamond
        ItemStack Diamond = new ItemStack(Material.DIAMOND);
        ItemMeta DiamondMeta = Diamond.getItemMeta();
        DiamondMeta.setDisplayName("§b§lDiamant");
        ArrayList<String> DiamondLore =  new ArrayList<String>();
        DiamondLore.add("§e55/Unité");
        DiamondMeta.setLore(DiamondLore);
        Diamond.setItemMeta(DiamondMeta);

        //Emerald
        ItemStack Emerald = new ItemStack(Material.EMERALD);
        ItemMeta EmeraldMeta = Emerald.getItemMeta();
        EmeraldMeta.setDisplayName("§a§lÉmeraude");
        ArrayList<String> EmeraldLore =  new ArrayList<String>();
        EmeraldLore.add("§e65/Unité");
        EmeraldMeta.setLore(EmeraldLore);
        Emerald.setItemMeta(EmeraldMeta);

        //Ancient Debris
        ItemStack Ancien = new ItemStack(Material.ANCIENT_DEBRIS);
        ItemMeta AncienMeta = Ancien.getItemMeta();
        AncienMeta.setDisplayName("§8§lAncien Débris");
        ArrayList<String> AncienLore =  new ArrayList<String>();
        AncienLore.add("§e80/Unité");
        AncienMeta.setLore(AncienLore);
        Ancien.setItemMeta(AncienMeta);

        //Quartz
        ItemStack quartz = new ItemStack(Material.QUARTZ);
        ItemMeta QuartzMeta = quartz.getItemMeta();
        QuartzMeta .setDisplayName("§8§lAncien Débris");
        ArrayList<String> QuartzLore =  new ArrayList<String>();
        QuartzLore.add("§e75/Unité");
        QuartzMeta.setLore(QuartzLore);
        quartz.setItemMeta(QuartzMeta);

        gui.setItem(0, Stone);
        gui.setItem(2, Cobblestone);
        gui.setItem(4, Coal);
        gui.setItem(6, Iron);
        gui.setItem(8, Gold);
        gui.setItem(18, Redstone);
        gui.setItem(20, Lapis);
        gui.setItem(22, Diamond);
        gui.setItem(24,Emerald);
        gui.setItem(26, quartz);
        gui.setItem(36, Ancien);


        return gui;
    }

    //GUI Vendre par 10, 32 ou 64
    public Inventory GuiShopMultiplerCoal(){
        Inventory gui = Bukkit.createInventory(null, 27, "§a§lVendre du charbon");

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

        gui.setItem(10, coal10);
        gui.setItem(13, coal32);
        gui.setItem(16, coal64);

        return gui;
    }

    public Inventory GuiShopMultiplerIron(){
        Inventory gui = Bukkit.createInventory(null, 27, "§a§lVendre du fer");

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

        gui.setItem(10, coal10);
        gui.setItem(13, coal32);
        gui.setItem(16, coal64);

        return gui;
    }

    public Inventory GuiShopMultiplerGold(){
        Inventory gui = Bukkit.createInventory(null, 27, "§a§lVendre de l'or");

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

        gui.setItem(10, coal10);
        gui.setItem(13, coal32);
        gui.setItem(16, coal64);

        return gui;
    }

    public Inventory GuiShopMultiplerRedstone(){
        Inventory gui = Bukkit.createInventory(null, 27, "§a§lVendre de la redstone");

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

        gui.setItem(10, coal10);
        gui.setItem(13, coal32);
        gui.setItem(16, coal64);

        return gui;
    }

    public Inventory GuiShopMultiplerLapis(){
        Inventory gui = Bukkit.createInventory(null, 27, "§a§lVendre du lapis");

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

        gui.setItem(10, coal10);
        gui.setItem(13, coal32);
        gui.setItem(16, coal64);

        return gui;
    }

    public Inventory GuiShopMultiplerDiamond() {
        Inventory gui = Bukkit.createInventory(null, 27, "§a§lVendre du diamant");

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

        gui.setItem(10, coal10);
        gui.setItem(13, coal32);
        gui.setItem(16, coal64);

        return gui;
    }

    public Inventory GuiShopMultiplerEmerald(){
        Inventory gui = Bukkit.createInventory(null, 27, "§a§lVendre de l'émeraude");

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

        gui.setItem(10, coal10);
        gui.setItem(13, coal32);
        gui.setItem(16, coal64);

        return gui;
    }

    public Inventory GuiShopMultiplerQuartz(){
        Inventory gui = Bukkit.createInventory(null, 27, "§a§lVendre du quartz");

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

        gui.setItem(10, coal10);
        gui.setItem(13, coal32);
        gui.setItem(16, coal64);

        return gui;
    }

    public Inventory GuiShopMultiplerNetherite(){
        Inventory gui = Bukkit.createInventory(null, 27, "§a§lVendre de la netherite");

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

        gui.setItem(10, coal10);
        gui.setItem(13, coal32);
        gui.setItem(16, coal64);

        return gui;
    }

    public Inventory GuiShopMultiplerStone(){
        Inventory gui = Bukkit.createInventory(null, 27, "§a§lVendre de la roche");

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

        gui.setItem(10, coal10);
        gui.setItem(13, coal32);
        gui.setItem(16, coal64);

        return gui;
    }

    public Inventory GuiShopMultiplerCobble(){
        Inventory gui = Bukkit.createInventory(null, 27, "§a§lVendre de la pierre taillé");

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

        gui.setItem(10, coal10);
        gui.setItem(13, coal32);
        gui.setItem(16, coal64);

        return gui;
    }

    //GUI Mines
    public Inventory GUIMine(){

        Inventory gui = Bukkit.createInventory(null, 36, "§a§lLes zones");

        //Niveau 1
        ItemStack coal = new ItemStack(Material.COAL, 1);
        ItemMeta coalMeta = coal.getItemMeta();
        coalMeta.setDisplayName("§8§lZone du charbon");
        coal.setItemMeta(coalMeta);

        //Niveau 2
        ItemStack iron = new ItemStack(Material.IRON_INGOT, 2);
        ItemMeta ironMeta = iron.getItemMeta();
        ironMeta.setDisplayName("§7§lZone du fer");
        iron.setItemMeta(ironMeta);

        //Niveau 3
        ItemStack gold = new ItemStack(Material.GOLD_INGOT, 3);
        ItemMeta goldMeta = gold.getItemMeta();
        goldMeta.setDisplayName("§e§lZone d'or");
        gold.setItemMeta(goldMeta);

        //Niveau 4
        ItemStack s = new ItemStack(Material.REDSTONE, 4);
        ItemMeta S = s.getItemMeta();
        S.setDisplayName("§c§lZone de la redstone");
        s.setItemMeta(S);

        //Niveau 6
        ItemStack l = new ItemStack(Material.LAPIS_LAZULI, 6);
        ItemMeta L = l.getItemMeta();
        L.setDisplayName("§3§lZone du lapis");
        l.setItemMeta(L);

        //Niveau 7
        ItemStack d = new ItemStack(Material.DIAMOND, 7);
        ItemMeta D = d.getItemMeta();
        D.setDisplayName("§b§lZone des diamants");
        d.setItemMeta(D);

        //Niveau 8
        ItemStack e = new ItemStack(Material.EMERALD, 8);
        ItemMeta E = e.getItemMeta();
        E.setDisplayName("§a§lZone des émeraudes");
        e.setItemMeta(E);

        //Aller aux niveaux des VIP
        ItemStack g = new ItemStack(Material.IRON_SWORD);
        ItemMeta G = g.getItemMeta();
        G.setDisplayName("§eSuivant §6(Vous devez être Déchus ou plus)");
        g.setItemMeta(G);

        gui.setItem(35, g);
        gui.setItem(24, e);
        gui.setItem(22, d);
        gui.setItem(20, l);
        gui.setItem(16, s);
        gui.setItem(14, gold);
        gui.setItem(12, iron);
        gui.setItem(10, coal);

        return gui;
    }

    //GUI Magasin
    public Inventory GUIShop() {
        Inventory guiShop = Bukkit.createInventory(null, 27, "§a§lLe magasin");

        ItemStack Pioche = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta PiocheMeta = Pioche.getItemMeta();
        PiocheMeta.setDisplayName("§d§lPioches");
        Pioche.setItemMeta(PiocheMeta);

        ItemStack Cobble = new ItemStack(Material.COBBLESTONE);
        ItemMeta CobbleMeta = Cobble.getItemMeta();
        CobbleMeta.setDisplayName("§d§lMinerais");
        Cobble.setItemMeta(CobbleMeta);

        guiShop.setItem(11, Cobble);
        guiShop.setItem(15, Pioche);

        return guiShop;
    }

    //GUI Shop Pioche
    public Inventory GUIShopPioche() {
        Inventory Shop = Bukkit.createInventory(null, 45, "§a§lLes pioches");

        ItemStack or = new ItemStack(Material.GOLDEN_PICKAXE);
        ItemMeta orMeta = or.getItemMeta();
        orMeta.setDisplayName("§e§lPioche en or (180 AstCoins)");
        or.setItemMeta(orMeta);

        ItemStack diams1 = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta diams1Meta = diams1.getItemMeta();
        diams1Meta.setDisplayName("§b§lPioche en diamant (320 AstCoins)");
        diams1.setItemMeta(diams1Meta);

        ItemStack diams2 = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta diams2Meta = diams2.getItemMeta();
        diams2Meta.setDisplayName("§b§lPioche en diamant V2 (780 AstCoins)");
        diams2Meta.addEnchant(Enchantment.DIG_SPEED, 3, true);
        diams2.setItemMeta(diams2Meta);

        ItemStack diams3 = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta diams3Meta = diams3.getItemMeta();
        diams3Meta.setDisplayName("§b§lPioche en diamant V3 (830 AstCoins)");
        diams3Meta.addEnchant(Enchantment.DIG_SPEED, 4, true);
        diams3.setItemMeta(diams3Meta);

        ItemStack netherite = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta netheriteMeta = netherite.getItemMeta();
        netheriteMeta.setDisplayName("§7§lPioche en netherite (1020 AstCoins)");
        netherite.setItemMeta(netheriteMeta);

        Shop.setItem(0, or);
        Shop.setItem(2, diams1);
        Shop.setItem(4, diams2);
        Shop.setItem(6, diams3);
        Shop.setItem(8, netherite);

        return Shop;
    }

}
