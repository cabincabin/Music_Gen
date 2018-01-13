package sample;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

public class Controller {

    @FXML
    private JFXTextField BPM;


    Main mainController;

    public Controller() {

    }

    public void setMainController(Main main) {
        this.mainController = main;
    }

    public void updatePlayMusic() {

    }

}
