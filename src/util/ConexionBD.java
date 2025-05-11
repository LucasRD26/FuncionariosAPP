

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class ConexionBD {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {
        try (InputStream input = ConexionBD.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties props = new Properties();
            if (input == null) {
                throw new RuntimeException("No se encontró el archivo de configuración: config.properties");
            }
            props.load(input);
            url = props.getProperty("db.url");
            user = props.getProperty("db.user");
            password = props.getProperty("db.password");
            driver = props.getProperty("db.driver");
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException("Error cargando la configuración de la base de datos", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}

