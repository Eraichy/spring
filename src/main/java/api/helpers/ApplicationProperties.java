package api.helpers;

import java.io.InputStream;
import java.util.Properties;


public class ApplicationProperties {

    private static Properties environment;

    static {
        environment = new Properties();
        InputStream is = ApplicationProperties.class.getResourceAsStream("/application.properties");
        try {
            environment.load(is);
        }
        catch (Exception ex) {
            System.out.println("Error reading property file.");
        }
    }

    /**
     * @param propertyName - key of test property from in the property file
     * @return - value of test option
     */
    public static String getProperty(String propertyName){
        return environment.getProperty(propertyName);
    }

}
