import javafx.fxml.FXML;
import javafx.geometry.NodeOrientation;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    private Label lblDistance;
    @FXML
    private Label lblConsumption;
    @FXML
    private Label lblPrice;
    @FXML
    private Label lblResult;
    @FXML
    private TextField txtDistance;
    @FXML
    private TextField txtConsumption;
    @FXML
    private TextField txtPrice;
    @FXML
    private Button btnCalculate;
    @FXML
    private Parent root;

    private CalculationService calculationService = new CalculationService();
    private LocalizationService localizationService = new LocalizationService();

    @FXML
    private void initialize() {
        setLanguage("en");
    }

    @FXML
    private void handleCalculate() {
        try {
            double distance = Double.parseDouble(txtDistance.getText());
            double consumption = Double.parseDouble(txtConsumption.getText());
            double price = Double.parseDouble(txtPrice.getText());

            double totalFuel = FuelCalculator.calculateTotalFuel(distance, consumption);
            double totalCost = FuelCalculator.calculateCost(totalFuel, price);

            CalculationRecord record = new CalculationRecord(
                    distance,
                    consumption,
                    price,
                    totalFuel,
                    totalCost,
                    localizationService.getLanguage()
            );
            calculationService.saveCalculation(record);
            lblResult.setText(MessageFormat.format(localizationService.getString("result"), totalFuel, totalCost));
        } catch (Exception e) {
            // TODO: show localized error?
            e.printStackTrace();
        }
    }

    private void setLanguage(String language) {
        try {
            localizationService.loadStrings(language);

            lblDistance.setText(localizationService.getString("distance.label"));
            lblConsumption.setText(localizationService.getString("consumption.label"));
            lblPrice.setText(localizationService.getString("price.label"));
            btnCalculate.setText(localizationService.getString("calculate.button"));

            if ("fa".equals(localizationService.getLanguage())) {
                root.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            } else {
                root.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            }
            handleCalculate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void setEnglish() {
        setLanguage("en");
    }

    @FXML
    private void setFrench() {
        setLanguage("fr");
    }

    @FXML
    private void setJapanese() {
        setLanguage("ja");
    }

    @FXML
    private void setPersian() {
        setLanguage("fa");
    }
}
