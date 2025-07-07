package VWO.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class PropertyReader {

    PropertyReader() {
    }

    static FileInputStream fileInputStream = null;
    static Properties p = null;
    static Map<String, String> prop_keys = new HashMap<>();

    static {
        try {

            fileInputStream = new FileInputStream(new File(System.getProperty("user.dir")) + "\\src\\test\\resources\\config.properties");
            p = new Properties();
            p.load(fileInputStream);
            for (Object key : p.keySet()) {
                prop_keys.put(String.valueOf(key), p.getProperty(String.valueOf(key)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (Objects.nonNull(fileInputStream)) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String readkey(String key) throws Exception {
        if (key == null & p.getProperty(key) == null) {
            throw new Exception(p.getProperty(key) + " Not Found !!");
        } else {
            return prop_keys.get(key);
        }
    }
}
