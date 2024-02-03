package org.example.connecttion;
import java.util.ResourceBundle;

public class WorkWithBase {

    private static final String DATABASE = "properties";
    private static final String URL_KEY = "url";
    private static final String USER_KEY = "user";
    private static final String PASSWORD_KEY = "password";


    private static final ResourceBundle resource = ResourceBundle.getBundle(DATABASE);

    private static String getValue(String key) {
        return resource.getString(key);
    }
    private static final String URL = getValue(URL_KEY);
    private static final String USER = getValue(USER_KEY);
    private static final String PASSWORD = getValue(PASSWORD_KEY);


    public static String getURL() { return URL; }

    public static String getUser() {
        return USER;
    }

    public static String getPassword() {
        return PASSWORD;
    }

}