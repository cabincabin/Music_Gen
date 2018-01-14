package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;

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
    private Canvas canvas;

    @FXML
    private JFXButton startStop;

    Main mainController;

    GraphicsContext gc;

    Sound sound;

    public Controller() {

    }

    public void initialize() throws Exception {
        sound = new Sound();
        gc = canvas.getGraphicsContext2D();
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
        startTimer();
    }

    public void drawSquares() {

        double windowH = gc.getCanvas().getHeight();
        double windowW = gc.getCanvas().getWidth();

        double widthIncrement = windowW/Display.getInstance().getNoteHeight().length;

        int factor = 10;

        gc.setStroke(Color.rgb(64,168,104));

        for(int i = 0; i <  Display.getInstance().getNoteHeight().length; i++) {
            gc.rect(widthIncrement * i, windowH - Display.getInstance().getSpecficNoteHeight(i) * factor, 10, Display.getInstance().getSpecficNoteHeight(i) * factor);
            gc.fillRect( Display.getInstance().getSpecficNoteHeight(i) * i, windowH, 10, Display.getInstance().getSpecficNoteHeight(i) * factor);
        }

        startTimer();
    }

    void startTimer() { // throws Exception {
        // only start a timer if we're in the admin scene. we don't care about the patient scene.
        runLater(javafx.util.Duration.millis(500), () -> {
            drawSquares();
        });
    }

    private void runLater(javafx.util.Duration delay, Runnable action) {
        Timeline timeline = new Timeline(new KeyFrame(delay, ae -> action.run()));
        timeline.play();
    }

}
