package FuelCalculator;

import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerTest {
    private Controller controller;

    @BeforeAll
    static void initJavaFX() {
        try {
            Platform.startup(() -> {});
        } catch (Exception e) {
            //
        }
    }

    @BeforeEach
    void setUp() {
        controller = new Controller();

        controller.setLblDistance(new Label());
        controller.setLblConsumption(new Label());
        controller.setLblPrice(new Label());
        controller.setLblResult(new Label());

        controller.setTxtDistance(new TextField("150"));
        controller.setTxtConsumption(new TextField("7.5"));
        controller.setTxtPrice(new TextField("1.9"));

        controller.setBtnCalculate(new Button());
        controller.setRoot(new VBox());
    }

    @Test
    void handleCalculate_test() {
        controller.handleCalculate();
    }

    @Test
    void setLanguage_test() {
        controller.setLanguage("en");
    }

    @Test
    void setEnglish_test() {
        controller.setEnglish();
    }

    @Test
    void setFrench_test() {
        controller.setFrench();
    }

    @Test
    void setJapanese_test() {
        controller.setJapanese();
    }

    @Test
    void setPersian_test() {
        controller.setPersian();
    }
}