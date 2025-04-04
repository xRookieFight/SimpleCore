package org.xrookiefight.simplecore.commands;

import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import org.xrookiefight.simplecore.Main;

public class ClearChat extends Command {


    public ClearChat() {
        super("clearchat", "Clears chat", "/cc", new String[]{"cc"});
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if (Main.groups.get(commandSender.getName()) == "Admin") {
            for (int i = 0; i < 100; i++) Server.getInstance().broadcastMessage("");
            Server.getInstance().broadcastMessage("§3The chat was cleared by §1" + commandSender.getName() + "§3.");
        } else {
            commandSender.sendMessage(TextFormat.RED + "You don't have permission to use this command.");
            return false;
        }
        return false;
    }
}
