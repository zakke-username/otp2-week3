import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FuelCalculatorTest {

    @Test
    void testCalculateTotalFuel() {
        double distance = 200.0;
        double consumption = 8.0;
        double expected = 16.0;
        assertEquals(expected, FuelCalculator.calculateTotalFuel(distance, consumption), 1e-6);
    }

    @Test
    void testCalculateCost() {
        double totalFuel = 20.0;
        double price = 1.5;
        double expected = 30.0;
        assertEquals(expected, FuelCalculator.calculateCost(totalFuel, price), 1e-6);
    }
}