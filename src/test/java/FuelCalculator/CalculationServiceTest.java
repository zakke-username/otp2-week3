package FuelCalculator;

import org.junit.jupiter.api.Test;

public class CalculationServiceTest {
    @Test
    void saveCalculation_test() {
        CalculationService calculationService = new CalculationService();
        CalculationRecord calculationRecord = new CalculationRecord(
                150.0,
                7.5,
                1.9,
                11.25,
                21.375,
                "en"
        );
        calculationService.saveCalculation(calculationRecord);
    }
}
