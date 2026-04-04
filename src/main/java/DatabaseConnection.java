import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Hardcoded for testing
    private static final String URL =
            System.getenv().getOrDefault("DB_URL",
                    "jdbc:mariadb://localhost:3306/fuel_calculator_localization");
    private static final String USER =
            System.getenv().getOrDefault("DB_USER", "fuel_app_user");
    private static final String PASSWORD =
            System.getenv().getOrDefault("DB_PASSWORD", "fuel_app_password");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}