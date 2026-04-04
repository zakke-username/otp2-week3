public class FuelCalculator {

    public static double calculateTotalFuel(double distance, double consumption) {
        return (consumption / 100) * distance;
    }

    public static double calculateCost(double totalFuel, double price) {
        return totalFuel * price;
    }
}
