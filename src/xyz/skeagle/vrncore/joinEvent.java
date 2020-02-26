package xyz.skeagle.vrncore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class joinEvent implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);
        Player p = event.getPlayer();
        boolean not1stjoin = p.hasPlayedBefore();
        if (not1stjoin) {
            for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
                    if (pl.getName() != event.getPlayer().getName()) {
                    pl.sendMessage(ChatColor.translateAlternateColorCodes('&', VRNcore.joinquit + "&5" + event.getPlayer().getName() + " &dhas joined."));
                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', VRNcore.joinquit + "Welcome back, &5" + event.getPlayer().getName() + "&d!"));
                }
            }
        } else {
            for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
                if (pl.getName() != event.getPlayer().getName()) {
                    pl.sendMessage(ChatColor.translateAlternateColorCodes('&', VRNcore.joinquit + "&5" + event.getPlayer().getName() + " &dhas joined."));
                } else {
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', VRNcore.welcome + event.getPlayer().getName() + " &6has joined for the first time. Welcome, &e" + event.getPlayer().getName() + "&6!"));
                }
            }
        }

    }
}
