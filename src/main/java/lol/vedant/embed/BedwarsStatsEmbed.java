package lol.vedant.embed;

import net.dv8tion.jda.api.EmbedBuilder;
import net.hypixel.api.reply.PlayerReply;


public class BedwarsStatsEmbed extends EmbedBuilder {


    public BedwarsStatsEmbed(PlayerReply playerReply) {
        setTitle("Bedwars Stats for " + playerReply.getPlayer().getName());
        setDescription("Here are the Bedwars statistics:");

        addField("**Wins:**", String.format("%d", playerReply.getPlayer().getIntProperty("stats.Bedwars.wins_bedwars", 0)), true);
        addField("**Losses:**", String.format("%d", playerReply.getPlayer().getIntProperty("stats.Bedwars.losses_bedwars", 0)), true);
        addField("**Kills:**", String.format("%d", playerReply.getPlayer().getIntProperty("stats.Bedwars.kills_bedwars", 0)), true);
        addField("**Deaths:**", String.format("%d", playerReply.getPlayer().getIntProperty("stats.Bedwars.deaths_bedwars", 0)), true);
        addField("**Final Kills:**", String.format("%d", playerReply.getPlayer().getIntProperty("stats.Bedwars.final_kills_bedwars", 0)), true);
        addField("**Final Deaths:**", String.format("%d", playerReply.getPlayer().getIntProperty("stats.Bedwars.final_deaths_bedwars", 0)), true);
        addField("**Beds Destroyed:**", String.format("%d", playerReply.getPlayer().getIntProperty("stats.Bedwars.beds_destroyed_bedwars", 0)), true);
        addField("**Items Purchased:**", String.format("%d", playerReply.getPlayer().getIntProperty("stats.Bedwars.items_purchased_bedwars", 0)), true);
        addField("**Resources Collected:**", String.format("%d", playerReply.getPlayer().getIntProperty("stats.Bedwars.resources_collected_bedwars", 0)), true);
        addField("**Coins:**", String.format("%d", playerReply.getPlayer().getIntProperty("stats.Bedwars.coins", 0)), true);
        setThumbnail("https://mc-heads.net/avatar/" + playerReply.getPlayer().getUuid().toString());
        setColor(0xFF6347); // A color of your choice
        setFooter("Data provided by Hypixel API");
    }

}