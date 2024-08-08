package lol.vedant.config;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {

    private static final Dotenv dotenv = Dotenv.load();

    public static String get(String key) {
        return dotenv.get(key.toUpperCase());
    }

    public static String get(String key, String defaultValue) {
        return dotenv.get(key.toUpperCase(), defaultValue);
    }

    public static int getInt(String key, int defaultValue) {
        String value = dotenv.get(key.toUpperCase());
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        String value = dotenv.get(key.toUpperCase());
        if (value == null) {
            return defaultValue;
        }
        return value.equalsIgnoreCase("true") || value.equalsIgnoreCase("1");
    }
}
