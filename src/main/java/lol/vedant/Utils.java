package lol.vedant;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lol.vedant.config.Config;
import net.hypixel.api.HypixelAPI;
import net.hypixel.api.apache.ApacheHttpClient;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    private static String getApiKey() {
        return Config.get("HYPIXEL_API_KEY");
    }

    public static int getEmbedColor() {
        return Color.getColor(Config.get("EMBED_COLOR")).hashCode();
    }

    public static int extractLevel(String input) {
        Pattern pattern = Pattern.compile("\\[(\\d+)★\\]");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        } else {
            throw new IllegalArgumentException("No number found inside brackets.");
        }
    }

    public static String getPlayerUUID(String playerName) {
        String apiUrl = "https://api.mojang.com/users/profiles/minecraft/" + playerName;

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            if (connection.getResponseCode() != 200) {
                return null;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String output;

            while ((output = br.readLine()) != null) {
                response.append(output);
            }

            connection.disconnect();

            JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();
            return jsonResponse.get("id").getAsString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static final HypixelAPI API;

    static {
        API = new HypixelAPI(new ApacheHttpClient(UUID.fromString(getApiKey())));
    }

}
