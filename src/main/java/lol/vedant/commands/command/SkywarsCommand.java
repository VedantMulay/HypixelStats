package lol.vedant.commands.command;

import lol.vedant.Utils;
import lol.vedant.commands.Command;
import lol.vedant.embed.BedwarsStatsEmbed;
import lol.vedant.embed.DataFetchErrorEmbed;
import lol.vedant.embed.FetchingEmbed;
import lol.vedant.embed.SkywarsStatsEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.hypixel.api.exceptions.HypixelAPIException;
import net.hypixel.api.reply.PlayerReply;

import java.util.concurrent.ExecutionException;

public class SkywarsCommand implements Command {
    @Override
    public void execute(MessageReceivedEvent e, String[] args) {
        if (args.length < 1) {
            e.getChannel().sendMessage("Please provide a Minecraft username.").queue();
            return;
        }

        String playerName = args[0];

        e.getChannel().sendMessageEmbeds(new FetchingEmbed().build()).queue(msg -> {

            try {
                PlayerReply playerReply = Utils.API.getPlayerByUuid(Utils.getPlayerUUID(playerName)).get();
                msg.editMessageEmbeds(new SkywarsStatsEmbed(playerReply).build()).queue();
            } catch (HypixelAPIException | InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
                msg.editMessageEmbeds(new DataFetchErrorEmbed().build()).queue();
            }

        });
    }

    @Override
    public boolean hasPermission(MessageReceivedEvent event) {
        return true;
    }

    @Override
    public boolean isOwnerOnly() {
        return false;
    }
}
