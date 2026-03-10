package demoQA.baseLayer;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    public static void loadConfig() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/config.properties"
            );
            prop.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config file", e);
        }
    }

    public static String getProperty(String key) {
        if (prop == null) {
            loadConfig();
        }
        return prop.getProperty(key);
    }

    public static String[] getBrowsers() {
        return prop.getProperty("browser").split(",");
    }
}
