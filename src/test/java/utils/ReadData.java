package utils;

import io.cucumber.java.Before;
import stepsDefinitions.Hooks;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadData {

    private static FileInputStream fis = null;
    private static Properties prop = null;

    public static String readData(String key) throws IOException {
            try {
                fis = new FileInputStream("./resources/Config.properties");
                prop = new Properties();
                prop.load(fis);
            } catch (IOException file) {
                file.printStackTrace();
            } finally {
                fis.close();
            }
            return prop.getProperty(key);
        }

}
