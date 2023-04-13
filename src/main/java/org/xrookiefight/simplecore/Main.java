package org.xrookiefight.simplecore;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import org.xrookiefight.simplecore.commands.ClearChat;
import org.xrookiefight.simplecore.commands.Kick;
import org.xrookiefight.simplecore.commands.SetGroup;
import org.xrookiefight.simplecore.events.EventListener;

public class Main extends PluginBase {

    private static Main instance;
    public static Config groups;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        this.getLogger().info(TextFormat.GREEN + "SimpleCore is online. By xRookieFight");
        this.getServer().getPluginManager().registerEvents(new EventListener(), this);
        this.getServer().getCommandMap().register("clearchat", new ClearChat());
        this.getServer().getCommandMap().register("setgroup", new SetGroup());
        this.getServer().getCommandMap().register("kickplayer", new Kick());
        this.groups = new Config(this.getDataFolder() + "-groups.yml", Config.YAML);

    }
    @Override
    public void onDisable() {
        this.getLogger().info(TextFormat.RED + "SimpleCore is offline. By xRookieFight");
    }
}
