package trangbui.selenium.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configs {
    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(new Resources().getCONFIG_PATH());
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read configuration file!!!");
        }
    }
    private Configs() {}

    public static String getProperty(String key) {
        try {
            return properties.getProperty(key);
        } catch (Exception e) {
            return "";
        }
    }
}
