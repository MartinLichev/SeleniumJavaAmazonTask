import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private Properties properties;

    public ConfigLoader() {
        properties = new Properties();
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getSiteUrl() {
        return properties.getProperty("site.url");
    }

    // Additional getters for other config properties
}
