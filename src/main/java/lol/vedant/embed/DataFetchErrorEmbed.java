package lol.vedant.embed;

import lol.vedant.Utils;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class DataFetchErrorEmbed extends EmbedBuilder {

    public DataFetchErrorEmbed() {
        setTitle(":warning: Error fetching details");
        setColor(Utils.getEmbedColor());
    }

}
