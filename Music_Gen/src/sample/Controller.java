package sample;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class Controller {

    @FXML
    private JFXTextField BPM;

    @FXML
    private JFXTextField timeSignature;

    @FXML
    private ComboBox firstChord;

    @FXML
    private Button startStop;

    Main mainController;

    Sound sound;
    public Controller() {

    }

    public void initialize() throws Exception {
        sound = new Sound();
    }

    public void setMainController(Main main) {
        this.mainController = main;
    }

    public void updatePlayMusic() throws Exception {
        NextNoteObj Next = new NextNoteObj();
        System.out.println("This happened");
        while (true) {
            sound.playChord(BPM.getText().trim());
            BPM.setText(Next.getNextChord(BPM.getText().trim()));
            Thread.sleep(2000);
        }
        //sound.playKey("a");
    }


}
