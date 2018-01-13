package sample;

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
            //Thread.sleep(1000);
            sound.playChord(chord.getText().trim(), 100);
            Thread.sleep(60000/(Integer.parseInt(BPM.getText().trim())));
            sound.playChord(chord.getText().trim(), 75);
            Thread.sleep(60000/(Integer.parseInt(BPM.getText().trim())));
            sound.playChord(chord.getText().trim(), 90);
            Thread.sleep(60000/(Integer.parseInt(BPM.getText().trim())));
            sound.playChord(chord.getText().trim(), 75);
            Thread.sleep(60000/(Integer.parseInt(BPM.getText().trim())));
            chord.setText(Next.getNextChord(chord.getText().trim()));
            
        }
        //sound.playKey("a");
    }


}
