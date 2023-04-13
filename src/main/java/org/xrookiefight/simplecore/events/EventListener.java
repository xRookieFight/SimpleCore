package org.xrookiefight.simplecore.events;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import org.xrookiefight.simplecore.Main;

public class EventListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!Main.groups.exists(event.getPlayer().getName())) {
            Main.groups.set(event.getPlayer().getName(), "Player");
        }
        event.setJoinMessage("§8[§a+§8] §f" + event.getPlayer().getName());
        event.getPlayer().sendMessage("§8------------------------------------");
        event.getPlayer().sendMessage("§eSimpleCore §b1.0");
        event.getPlayer().sendMessage("§aWelcome, §d" + event.getPlayer().getName() + "!");
        event.getPlayer().sendMessage("§8------------------------------------");
        event.getPlayer().sendTitle("§eSimpleCore", "§b1.0");
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage("§8[§c-§8] §f" + event.getPlayer().getName());
    }

    @EventHandler
    public void onChat(PlayerChatEvent event) {
        event.setMessage(event.getMessage().toLowerCase());
        if (Main.groups.get(event.getPlayer().getName()) == "Player") {
            event.setFormat("§8Player §7" + event.getPlayer().getName() + " §f> §7" + event.getMessage());
        } else if (Main.groups.get(event.getPlayer().getName()) == "Admin") {
            event.setFormat("§cAdmin §f" + event.getPlayer().getName() + " §e> §f" + event.getMessage());
        }
    }
}
