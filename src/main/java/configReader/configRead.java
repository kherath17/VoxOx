package configReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class configRead {
    private Properties properties;
    private final String filePath = "configFiles/configuration.properties";


    public String read(String data) throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(filePath));
        properties = new Properties();
        properties.load(reader);


        return properties.getProperty(data);


    }

}
