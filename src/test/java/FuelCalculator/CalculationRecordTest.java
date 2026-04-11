package FuelCalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculationRecordTest {
    @Test
    public void calculationRecord_test() {
        double distance = 150.0;
        double consumption = 7.5;
        double price = 1.9;
        double totalFuel = 11.25;
        double totalCost = 21.375;
        String language = "en";

        CalculationRecord record = new CalculationRecord(
                distance,
                consumption,
                price,
                totalFuel,
                totalCost,
                language
        );

        assertEquals(distance, record.getDistance());
        assertEquals(consumption, record.getConsumption());
        assertEquals(price, record.getPrice());
        assertEquals(totalFuel, record.getTotalFuel());
        assertEquals(totalCost, record.getTotalCost());
        assertEquals(language, record.getLanguage());
    }
}
