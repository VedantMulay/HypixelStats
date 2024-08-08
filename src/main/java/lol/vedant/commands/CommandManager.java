package lol.vedant.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private static final String PREFIX = "?";
    private final Map<String, Command> commands = new HashMap<>();
    private final String ownerId;

    public CommandManager(String ownerId) {
        this.ownerId = ownerId;
    }

    public void registerCommand(String commandName, Command command) {
        commands.put(commandName.toLowerCase(), command);
    }

    public void executeCommand(String commandName, MessageReceivedEvent event, String[] args) {
        Command command = commands.get(commandName.toLowerCase());
        if (command != null) {
            if (command.isOwnerOnly() && !event.getAuthor().getId().equals(ownerId)) {
                event.getChannel().sendMessage("You do not have permission to use this command.").queue();
                return;
            }
            if (!command.hasPermission(event)) {
                event.getChannel().sendMessage("You do not have permission to use this command.").queue();
                return;
            }
            command.execute(event, args);
        } else {
            event.getChannel().sendMessage("Unknown command.").queue();
        }
    }

    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        if (!message.startsWith(PREFIX) || event.getAuthor().isBot()) return;

        String[] parts = message.substring(PREFIX.length()).split("\\s+");
        String commandName = parts[0].toLowerCase();
        String[] args = parts.length > 1 ? message.substring(PREFIX.length() + commandName.length()).trim().split("\\s+") : new String[0];

        executeCommand(commandName, event, args);
    }
}
