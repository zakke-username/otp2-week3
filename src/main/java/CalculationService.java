import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CalculationService {
    public void saveCalculation(CalculationRecord record) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO calculation_records (distance, consumption, price, total_fuel, total_cost, language) VALUES (?, ?, ?, ?, ?, ?)");

            statement.setDouble(1, record.getDistance());
            statement.setDouble(2, record.getConsumption());
            statement.setDouble(3, record.getPrice());
            statement.setDouble(4, record.getTotalFuel());
            statement.setDouble(5, record.getTotalCost());
            statement.setString(6, record.getLanguage());

            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
