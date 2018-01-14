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
import javafx.scene.effect.Effect;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class Controller {
    @FXML
    private JFXTextField chord;

    @FXML
    private JFXTextField BPM;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private ComboBox firstChord;

    @FXML
    private Canvas canvas;

    @FXML
    private JFXButton startStop;

    Main mainController;

    GraphicsContext gc;

    Sound sound;

    Trie trie = new Trie();



    public Controller() {

    }

    public void initialize() throws Exception {
        trie.read(Main.string);
        sound = new Sound();
        gc = canvas.getGraphicsContext2D();
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
            currMesure.chord = chord.getText().toLowerCase();
            currMesure.trie=trie;
            Thread thread1 = new Thread(currMesure);
            thread1.start();
            //thread1.join();

        //sound.playKey("a");
        startTimer();
        drawSquares();
    }

    public void drawSquares() {
        canvas.setWidth(mainPane.getWidth());
        canvas.setHeight(mainPane.getHeight());
        //System.out.println("This happened");

        double windowH = gc.getCanvas().getHeight();
        double windowW = gc.getCanvas().getWidth();

        gc.clearRect(0,0,windowW,windowH);

        double widthIncrement = windowW/Display.getInstance().getNoteHeight().length;

        int factor = 1;

        gc.setStroke(Color.rgb(64,168,104));
        gc.setFill(Color.rgb(64,168,104));
        //gc.setEffect();
        for(int i = 0; i <  Display.getInstance().getNoteHeight().length; i++) {

            gc.setLineWidth(10);
            gc.strokeLine(widthIncrement * i, windowH, widthIncrement * i, windowH - Display.getInstance().getSpecficNoteHeight(i) * factor);
            gc.rect(widthIncrement * i, windowH - Display.getInstance().getSpecficNoteHeight(i) * factor, 10, Display.getInstance().getSpecficNoteHeight(i) * factor);
            gc.fillRect( Display.getInstance().getSpecficNoteHeight(i) * i, windowH, 10, Display.getInstance().getSpecficNoteHeight(i) * factor);
        }

        gc.rect(100,100,300,300);
        //gc.fillOval(100,100,234,123);
        Display.getInstance().decrementAllNoteHeight();
        startTimer();
    }

    void startTimer() { // throws Exception {
        // only start a timer if we're in the admin scene. we don't care about the patient scene.
        runLater(javafx.util.Duration.millis(25), () -> {
            drawSquares();
        });
    }

    private void runLater(javafx.util.Duration delay, Runnable action) {
        Timeline timeline = new Timeline(new KeyFrame(delay, ae -> action.run()));
        timeline.play();
    }

}
