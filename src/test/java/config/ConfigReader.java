package config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("application.properties")) {

            if (input == null) {
                throw new RuntimeException("Файл application.properties не найден в classpath");
            }
            properties.load(input);
            System.out.println("✅ application.properties загружен успешно");

        } catch (Exception e) {
            throw new RuntimeException("Ошибка загрузки application.properties", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String  getBaseUrl() {
        return getProperty("base.url");
    }

    public static String getStandardUser() {
        return getProperty("user.standard");
    }

    public static String getStandardPassword() {
        return getProperty("user.password");
    }
}