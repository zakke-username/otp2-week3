package FuelCalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.sql.Connection;

public class DatabaseConnectionTest {
    @Test
    void getConnection_test() {
        try {
            Connection connection = DatabaseConnection.getConnection();
            assertNotNull(connection);
        } catch (Exception e) {
            //
        }
    }
}
