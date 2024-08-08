package lol.vedant.embed;

import net.dv8tion.jda.api.EmbedBuilder;
import net.hypixel.api.reply.PlayerReply;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class HypixelPlayerEmbed extends EmbedBuilder {

    private final PlayerReply.Player player;

    public HypixelPlayerEmbed(PlayerReply playerReply) {
        this.player = playerReply.getPlayer();

        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }

        setTitle(player.getName() + "'s Hypixel Profile");
        setDescription("Here's the latest info about **" + player.getName() + "** on Hypixel:");

        addField("**Rank:**", player.getHighestRank() != null ? player.getHighestRank() : "N/A", true);
        addField("**Karma:**", player.getKarma() >= 0 ? String.format("%,d", player.getKarma()) : "N/A", true);
        addField("**Network Experience:**", player.getNetworkExp() >= 0 ? String.format("%h", player.getNetworkExp()) : "N/A", true);
        addField("**Network Level:**", player.getNetworkLevel() >= 0 ? String.format("%h", player.getNetworkLevel()) : "N/A", true);
        addField("**Recently Played:**", player.getMostRecentGameType() != null ? player.getMostRecentGameType().getName() : "N/A", true);
        addField("**Last Login:**", formatDate(player.getLastLoginDate()), true);
        addField("**First Login:**", formatDate(player.getFirstLoginDate()), true);

        setThumbnail("https://mc-heads.net/avatar/" + player.getUuid().toString());
        setColor(0x1E90FF); // A nice blue color for the embed
        setFooter("Data provided by Hypixel API");
    }

    private String formatDate(ZonedDateTime dateTime) {
        if (dateTime == null) {
            return "Unknown";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        return dateTime.format(formatter);
    }
}
