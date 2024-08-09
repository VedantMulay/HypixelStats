package lol.vedant.embed;


import javafx.scene.paint.Color;
import lol.vedant.Utils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.hypixel.api.reply.PlayerReply;

public class SkywarsStatsEmbed extends EmbedBuilder {

    public SkywarsStatsEmbed(PlayerReply reply) {
        PlayerReply.Player player = reply.getPlayer();
        setTitle("Skywars Stats for " + reply.getPlayer().getName());
        setDescription("Here are the Skywars statistics:");

        addField(new MessageEmbed.Field("**Wins**", String.format("%d", player.getIntProperty("stats.SkyWars.wins", 0)), true));
        addField(new MessageEmbed.Field("**Losses**", String.format("%d", player.getIntProperty("stats.SkyWars.losses", 0)), true));
        addField(new MessageEmbed.Field("**Games Played**", String.format("%d", player.getIntProperty("stats.SkyWars.games_played_skywars", 0)), true));
        addField(new MessageEmbed.Field("**Assists**", String.format("%d", player.getIntProperty("stats.SkyWars.assists",0)), true));
        addField(new MessageEmbed.Field("**Kills**", String.format("%d", player.getIntProperty("stats.SkyWars.kills",0)), true));
        addField(new MessageEmbed.Field("**Deaths**", String.format("%d", player.getIntProperty("stats.SkyWars.deaths",0)), true));

        setThumbnail("https://mc-heads.net/avatar/" + reply.getPlayer().getUuid().toString());
        setFooter("Data provided by Hypixel API");
        setColor(Color.GOLD.hashCode());
    }


}
