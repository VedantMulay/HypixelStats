package lol.vedant.embed;

import javafx.scene.paint.Color;
import net.dv8tion.jda.api.EmbedBuilder;

public class FetchingEmbed extends EmbedBuilder {

    public FetchingEmbed() {
        setTitle("Fetching data...");
        setDescription("Please be patient");
        setColor(Color.AZURE.hashCode());
    }

}
