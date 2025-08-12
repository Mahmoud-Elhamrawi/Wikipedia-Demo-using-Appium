package Utils.DataUtils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;

public class ReadPropertyFile {
    public static String propertyFilePath = "src/main/resources/";

    //load property files
    public static Properties loadPropertyFile() {
        try {
            Properties properties = new Properties();
            Collection<File> collection;
            collection = FileUtils.listFiles(new File(propertyFilePath), new String[]{"properties"}, true);
            collection.forEach(
                    file -> {
                        try {
                            properties.load(new FileInputStream(file));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        properties.putAll(System.getProperties());
                        System.setProperties(properties);
                    });
            return properties;
        } catch (
                Exception e) {
            System.out.println("error" + e.getMessage());
            return null;
        }
    }

    //get property key
    public static String getPropertyKey(String key) {
        try {
       return      System.getProperty(key);
        } catch (Exception e) {
            System.out.println("fail to get property key" + e.getMessage());
            return "0";
        }


    }


}
