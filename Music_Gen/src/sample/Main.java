package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Scene mainStage;

    public static String string = "C,48,dm,5.2,C,0.68\n" +
            "C,48,dm,5.2,em,0.68\n" +
            "C,48,dm,5.2,F,0.87\n" +
            "C,48,dm,5.2,G,0.65\n" +
            "C,48,dm,5.2,am,1.3\n" +
            "C,48,em,3.3,C,0.23\n" +
            "C,48,em,3.3,dm,0.19\n" +
            "C,48,em,3.3,F,1.2\n" +
            "C,48,em,3.3,G,0.33\n" +
            "C,48,em,3.3,am,0.89\n" +
            "C,48,F,14,C,4.5\n" +
            "C,48,F,14,dm,0.94\n" +
            "C,48,F,14,em,0.49\n" +
            "C,48,F,14,F,0.0094\n" +
            "C,48,F,14,G,4.7\n" +
            "C,48,F,14,am,1.8\n" +
            "C,48,G,17,C,3.2\n" +
            "C,48,G,17,dm,1.9\n" +
            "C,48,G,17,em,0.46\n" +
            "C,48,G,17,F,4.9\n" +
            "C,48,G,17,am,5.9\n" +
            "C,48,am,7.9,C,1.0\n" +
            "C,48,am,7.9,dm,0.89\n" +
            "C,48,am,7.9,em,0.63\n" +
            "C,48,am,7.9,F,2.7\n" +
            "C,48,am,7.9,G,1.9\n" +
            "dm,24,C,3.7,dm,0.59\n" +
            "dm,24,C,3.7,em,0.18\n" +
            "dm,24,C,3.7,F,0.57\n" +
            "dm,24,C,3.7,G,0.97\n" +
            "dm,24,C,3.7,am,0.40\n" +
            "dm,24,em,2.8,C,0.10\n" +
            "dm,24,em,2.8,dm,0.23\n" +
            "dm,24,em,2.8,F,1.4\n" +
            "dm,24,em,2.8,G,0.17\n" +
            "dm,24,em,2.8,am,0.65\n" +
            "dm,24,F,4.9,C,1.5\n" +
            "dm,24,F,4.9,dm,0.33\n" +
            "dm,24,F,4.9,em,0.25\n" +
            "dm,24,F,4.9,G,1.4\n" +
            "dm,24,F,4.9,am,0.84\n" +
            "dm,24,G,5.0,C,2.0\n" +
            "dm,24,G,5.0,dm,0.42\n" +
            "dm,24,G,5.0,em,0.25\n" +
            "dm,24,G,5.0,F,0.49\n" +
            "dm,24,G,5.0,am,0.92\n" +
            "dm,24,am,5.3,C,0.89\n" +
            "dm,24,am,5.3,dm,0.68\n" +
            "dm,24,am,5.3,em,0.35\n" +
            "dm,24,am,5.3,F,1.3\n" +
            "dm,24,am,5.3,G,1.1\n" +
            "em,16,C,1.1,dm,0.075\n" +
            "em,16,C,1.1,em,0.16\n" +
            "em,16,C,1.1,F,0.16\n" +
            "em,16,C,1.1,G,0.22\n" +
            "em,16,C,1.1,am,0.22\n" +
            "em,16,dm,2.1,C,0.43\n" +
            "em,16,dm,2.1,em,0.37\n" +
            "em,16,dm,2.1,F,0.28\n" +
            "em,16,dm,2.1,G,0.47\n" +
            "em,16,dm,2.1,am,0.35\n" +
            "em,16,F,6.4,C,1.4\n" +
            "em,16,F,6.4,dm,0.50\n" +
            "em,16,F,6.4,em,0.77\n" +
            "em,16,F,6.4,G,2.7\n" +
            "em,16,F,6.4,am,0.91\n" +
            "em,16,G,1.7,C,0.38\n" +
            "em,16,G,1.7,dm,0.16\n" +
            "em,16,G,1.7,em,0.075\n" +
            "em,16,G,1.7,F,0.22\n" +
            "em,16,G,1.7,am,0.52\n" +
            "em,16,am,4.7,C,0.42\n" +
            "em,16,am,4.7,dm,0.59\n" +
            "em,16,am,4.7,em,0.69\n" +
            "em,16,am,4.7,F,1.1\n" +
            "em,16,am,4.7,G,1.0\n" +
            "F,51,C,19,dm,1.4\n" +
            "F,51,C,19,em,0.86\n" +
            "F,51,C,19,F,3.7\n" +
            "F,51,C,19,G,9.2\n" +
            "F,51,C,19,am,2.3\n" +
            "F,51,dm,4.8,C,0.60\n" +
            "F,51,dm,4.8,em,0.51\n" +
            "F,51,dm,4.8,F,0.62\n" +
            "F,51,dm,4.8,G,1.0\n" +
            "F,51,dm,4.8,am,1.1\n" +
            "F,51,em,3.6,C,0.24\n" +
            "F,51,em,3.6,dm,0.90\n" +
            "F,51,em,3.6,F,0.72\n" +
            "F,51,em,3.6,G,0.36\n" +
            "F,51,em,3.6,am,0.95\n" +
            "F,51,F,0.019,G,0.0094\n" +
            "F,51,G,21,C,7.2\n" +
            "F,51,G,21,dm,1.3\n" +
            "F,51,G,21,em,1.3\n" +
            "F,51,G,21,F,2.7\n" +
            "F,51,G,21,am,7.7\n" +
            "F,51,am,7.7,C,1.4\n" +
            "F,51,am,7.7,dm,0.36\n" +
            "F,51,am,7.7,em,0.34\n" +
            "F,51,am,7.7,F,1.3\n" +
            "F,51,am,7.7,G,3.4\n" +
            "G,49,C,16,dm,1.1\n" +
            "G,49,C,16,em,0.84\n" +
            "G,49,C,16,F,4.7\n" +
            "G,49,C,16,G,3.3\n" +
            "G,49,C,16,am,2.2\n" +
            "G,49,dm,5.2,C,0.77\n" +
            "G,49,dm,5.2,em,0.49\n" +
            "G,49,dm,5.2,F,1.8\n" +
            "G,49,dm,5.2,G,0.63\n" +
            "G,49,dm,5.2,am,1.2\n" +
            "G,49,em,3.0,C,0.12\n" +
            "G,49,em,3.0,dm,0.15\n" +
            "G,49,em,3.0,F,1.1\n" +
            "G,49,em,3.0,G,0.18\n" +
            "G,49,em,3.0,am,1.1\n" +
            "G,49,F,15,C,4.7\n" +
            "G,49,F,15,dm,1.0\n" +
            "G,49,F,15,em,1.0\n" +
            "G,49,F,15,G,5.0\n" +
            "G,49,F,15,am,2.1\n" +
            "G,49,am,17,C,2.4\n" +
            "G,49,am,17,dm,0.95\n" +
            "G,49,am,17,em,1.4\n" +
            "G,49,am,17,F,6.6\n" +
            "G,49,am,17,G,3.8\n" +
            "am,47,C,7.6,dm,0.81\n" +
            "am,47,C,7.6,em,0.47\n" +
            "am,47,C,7.6,F,2.3\n" +
            "am,47,C,7.6,G,2.2\n" +
            "am,47,C,7.6,am,0.92\n" +
            "am,47,dm,5.0,C,0.66\n" +
            "am,47,dm,5.0,em,0.47\n" +
            "am,47,dm,5.0,F,0.80\n" +
            "am,47,dm,5.0,G,1.2\n" +
            "am,47,dm,5.0,am,0.87\n" +
            "am,47,em,4.1,C,0.23\n" +
            "am,47,em,4.1,dm,0.39\n" +
            "am,47,em,4.1,F,1.9\n" +
            "am,47,em,4.1,G,0.54\n" +
            "am,47,em,4.1,am,0.77\n" +
            "am,47,F,16,C,6.2\n" +
            "am,47,F,16,dm,1.3\n" +
            "am,47,F,16,em,0.58\n" +
            "am,47,F,16,G,5.8\n" +
            "am,47,F,16,am,1.2\n" +
            "am,47,G,14,C,2.7\n" +
            "am,47,G,14,dm,1.2\n" +
            "am,47,G,14,em,0.75\n" +
            "am,47,G,14,F,6.8\n" +
            "am,47,G,14,am,2.0";

    public static Controller mainController = new Controller();

    @Override
    public void start(Stage primaryStage) throws Exception{


        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("HackGUI2.fxml"));
        Parent mainScreen = mainLoader.load();
        mainController = mainLoader.getController();
        mainController.setMainController(this);
        mainStage = new Scene(mainScreen);

        primaryStage.setTitle("Music Generator");
        primaryStage.setResizable(true);
        primaryStage.show();
        primaryStage.centerOnScreen();
        primaryStage.setScene(mainStage);

        /*Trie trie = new Trie();
        trie.read(string);*/

        /*for (node i: trie.heads ) {
            System.out.println(i.note);
        }*/

    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop(){
        System.exit(0);
    }

}
