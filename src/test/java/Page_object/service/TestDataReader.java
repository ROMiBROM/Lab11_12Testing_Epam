package Page_object.service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("user"));

    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}
