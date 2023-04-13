package org.xrookiefight.simplecore.commands;

import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import org.xrookiefight.simplecore.Main;

public class SetGroup extends Command {


    public SetGroup() {
        super("setgroup", "Sets your own group", "/setgroup");
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if (commandSender.isOp()) {
            if(strings[0].equals("admin")){
                Main.groups.set(commandSender.getName(), "Admin");
                Main.groups.save();
                commandSender.sendMessage("§aYour group set to §2Admin§a.");
            } else if (strings[0].equals("player")) {
                Main.groups.set(commandSender.getName(), "Player");
                Main.groups.save();
                commandSender.sendMessage("§aYour group set to §2Player§a.");
            } else if(strings[0].isBlank()){
                commandSender.sendMessage(TextFormat.RED + "/setgroup <player,admin>");
            } else if (strings[0].isEmpty()) {
                commandSender.sendMessage(TextFormat.RED + "/setgroup <player,admin>");
            }

        } else {
            commandSender.sendMessage(TextFormat.RED + "You don't have permission to use this command.");
            return false;
        }
        return false;
    }
}
