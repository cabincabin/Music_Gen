package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Scene mainStage;

    public static Controller mainController = new Controller();

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("HackGUI.fxml"));
        Parent mainScreen = mainLoader.load();
        mainController = mainLoader.getController();
        mainController.setMainController(this);
        mainStage = new Scene(mainScreen);

        primaryStage.setTitle("Music Generator");
        primaryStage.setIconified(true);
        primaryStage.setResizable(true);
        primaryStage.show();
        primaryStage.centerOnScreen();
        primaryStage.setScene(mainStage);

    }


    public static void main(String[] args) {
        launch(args);
    }


}
