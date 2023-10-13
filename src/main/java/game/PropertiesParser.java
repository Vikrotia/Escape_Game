package game;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesParser {
    Properties properties;
    String relativePath;

    public void readProperties(boolean devMode) {
        try{
            if (!devMode){
                relativePath = "src/main/resources/application-production.properties";
            } else {
                relativePath = "src/main/resources/application-dev.properties";
            }
            FileInputStream propertiesFile = new FileInputStream(relativePath);
            properties = new Properties();
            properties.load(propertiesFile);

        } catch (IOException ex) {
            System.err.println("Properties wasn't find.");
            System.exit(-1);
        }
    }

public <T> T getProperty(String s, T defaultValue) {
    String value = properties.getProperty(s);
    if (value != null && !value.isEmpty()) {
        if (defaultValue instanceof String) {
            return (T) value;
        } else if (defaultValue instanceof Character) {
            return (T) Character.valueOf(value.charAt(0));
        }
    }
    return defaultValue;
}

}
