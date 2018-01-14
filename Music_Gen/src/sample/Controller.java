package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class Controller {
    @FXML
    private JFXTextField chord;

    @FXML
    private JFXTextField BPM;


    @FXML
    private ComboBox firstChord;



    @FXML
    private JFXButton startStop;

    Main mainController;

    Sound sound;
    public Controller() {

    }

    public void initialize() throws Exception {
        sound = new Sound();
        BPM.setStyle("-fx-text-inner-color: white;");
        chord.setStyle("-fx-text-inner-color: white;");
    }

    public void setMainController(Main main) {
        this.mainController = main;
    }

    public void updatePlayMusic() throws Exception {
        PlayChord currMesure = new PlayChord();

        System.out.println("This happened");
            currMesure.BPM = Integer.parseInt(BPM.getText());
            currMesure.chord = chord.getText();
            Thread thread1 = new Thread(currMesure);
            thread1.start();
            //thread1.join();

        //sound.playKey("a");
    }


}
