package game;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesParser {
    Properties properties;
    String relativePath;

    public void readProperties(String profile) {
        try{
            if (profile.equals("production")){
                relativePath = "src/main/resources/application-production.properties";
            } else if (profile.equals("dev")){
                relativePath = "src/main/resources/application-dev.properties";
            } else {
                throw new PropertiesNotFoundException();
            }
            FileInputStream propertiesFile = new FileInputStream(relativePath);
            properties = new Properties();
            properties.load(propertiesFile);

        } catch (IOException | PropertiesNotFoundException ex) {
            System.err.println("Properties wasn't find.");
            System.exit(-1);
        }
    }


    public char getPropertyChar(String s) {
        String value = properties.getProperty(s);
        if (value != null && !value.isEmpty()) {
            return value.charAt(0);
        } else {
            return ' ';
        }
    }

    public String getPropertyString(String s) {
        String value = properties.getProperty(s);
        if (value != null && !value.isEmpty()) {
            return value;
        } else {
            return "BLACK";
        }
    }
}
