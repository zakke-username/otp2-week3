package FuelCalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage mainStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view.fxml"));
        Scene scene = new Scene(loader.load());
        mainStage.setTitle("Fuel Consumption Calculator (Zachris Zweygberg)");
        mainStage.setScene(scene);
        mainStage.show();
    }
}
