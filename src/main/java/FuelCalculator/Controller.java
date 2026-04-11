package FuelCalculator;

import javafx.fxml.FXML;
import javafx.geometry.NodeOrientation;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.MessageFormat;

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

    public Controller() {}

    @FXML
    private void initialize() {
        setLanguage("en");
    }

    @FXML
    void handleCalculate() {
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
//            e.printStackTrace();
        }
    }

    public void setLanguage(String language) {
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
//            e.printStackTrace();
        }
    }

    @FXML
    void setEnglish() {
        setLanguage("en");
    }

    @FXML
    void setFrench() {
        setLanguage("fr");
    }

    @FXML
    void setJapanese() {
        setLanguage("ja");
    }

    @FXML
    void setPersian() {
        setLanguage("fa");
    }


    // UI component setters for testing
    void setLblDistance(Label lblDistance) {
        this.lblDistance = lblDistance;
    }

    void setLblConsumption(Label lblConsumption) {
        this.lblConsumption = lblConsumption;
    }

    void setLblPrice(Label lblPrice) {
        this.lblPrice = lblPrice;
    }

    void setLblResult(Label lblResult) {
        this.lblResult = lblResult;
    }

    void setTxtDistance(TextField txtDistance) {
        this.txtDistance = txtDistance;
    }

    void setTxtConsumption(TextField txtConsumption) {
        this.txtConsumption = txtConsumption;
    }

    void setTxtPrice(TextField txtPrice) {
        this.txtPrice = txtPrice;
    }

    void setBtnCalculate(Button btnCalculate) {
        this.btnCalculate = btnCalculate;
    }

    void setRoot(Parent root) {
        this.root = root;
    }
}
