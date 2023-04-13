package org.xrookiefight.simplecore.commands;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import org.xrookiefight.simplecore.Main;

public class Kick extends Command {


    public Kick() {
        super("kickplayer", "Kicks a player", "/kick <player> <reason>");
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if (Main.groups.get(commandSender.getName()) == "Admin") {
                if (!strings[0].isEmpty()) {
                    if (!strings[0].isBlank()) {
                        if (!strings[1].isEmpty()) {
                            if (!strings[1].isBlank()) {
                                Player player = Server.getInstance().getPlayer(strings[0]);
                                player.close("","§cYou are kicked from server.\n\n§cReason: §e" + strings[1]);
                                commandSender.sendMessage("§aYou kicked §2" + player.getName() + " §afrom server.\n\n§aReason: §2" + strings[1]);
                                Server.getInstance().broadcastMessage("§2" + player.getName() + " §ais kicked from server.\n\n§aReason: §2" + strings[1] + "\n§aAdmin: §2" + commandSender.getName());
                            } else  {
                                Player player = Server.getInstance().getPlayer(strings[0]);
                                player.close("§cYou are kicked from server.\n\n§cReason: §eNo reason given.");
                                commandSender.sendMessage("§aYou kicked §2" + player.getName() + " §afrom server.\n\n§aReason: §2No reason given.");
                                Server.getInstance().broadcastMessage("§2" + player.getName() + " §ais kicked from server.\n\n§aReason: §2No reason given." + "\n§aAdmin: §2" + commandSender.getName());
                                return false;
                            }
                        } else {
                            Player player = Server.getInstance().getPlayer(strings[0]);
                            player.close("", "§cYou are kicked from server.\n\n§cReason: §eNo reason given.");
                            commandSender.sendMessage("§aYou kicked §2" + player.getName() + " §afrom server.\n\n§aReason: §2No reason given.");
                            Server.getInstance().broadcastMessage("§2" + player.getName() + " §ais kicked from server.\n\n§aReason: §2No reason given." + "\n§aAdmin: §2" + commandSender.getName());
                            return false;
                        }
                    } else {
                        commandSender.sendMessage(TextFormat.RED + "/kick <player> <reason>");
                        return false;
                    }
                } else {
                    commandSender.sendMessage(TextFormat.RED + "/kick <player> <reason>");
                    return false;
                }
        } else  {
            commandSender.sendMessage(TextFormat.RED + "You don't have permission to use this command.");
            return false;
        }
        return false;
    }
}
