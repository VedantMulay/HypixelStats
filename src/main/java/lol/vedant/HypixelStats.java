package lol.vedant;

import lol.vedant.commands.CommandManager;
import lol.vedant.commands.command.BedwarsCommand;
import lol.vedant.commands.command.HypixelCommand;
import lol.vedant.commands.command.SkywarsCommand;
import lol.vedant.config.Config;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class HypixelStats extends ListenerAdapter {
    private final CommandManager commandManager;

    public HypixelStats(String token, String ownerId) {
        this.commandManager = new CommandManager(ownerId);

        commandManager.registerCommand("hypixel", new HypixelCommand());
        commandManager.registerCommand("bedwars", new BedwarsCommand());
        commandManager.registerCommand("skywars", new SkywarsCommand());

        try {
            JDABuilder builder = JDABuilder.createDefault(token);
            builder.enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES);
            builder.addEventListeners(this);
            builder.build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        commandManager.onMessageReceived(event);
    }

    public static void main(String[] args) {

        String token = Config.get("BOT_TOKEN");
        String ownerId = null;
        new HypixelStats(token, ownerId);
    }
}
