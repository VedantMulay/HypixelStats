package lol.vedant.commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.concurrent.ExecutionException;

public interface Command {
    void execute(MessageReceivedEvent event, String[] args);
    boolean hasPermission(MessageReceivedEvent event);
    boolean isOwnerOnly();
}