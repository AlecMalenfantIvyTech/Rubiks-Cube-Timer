package sample;
/**This program will create a timer to help Rubik's Cubers keep track of their solves.
 This Program will create a random rubik's cube scramble for the user to scramble their physical rubik's cube
 The Program will also have a timer. The program will automatically calculate the average of the user's past 5 solves and the average time of the user's past 10 solves
  */


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;

import java.sql.ClientInfoStatus;
public class Main extends Application {
//create objects
    Scramble Scramble = new Scramble();
    Times Times = new Times();
    Stopwatch Stopwatch = new Stopwatch();


    //JAVAFX
    //textfields
    private TextField tfScramble = new TextField();
    private TextField tfAvg5 = new TextField();
    private TextField tfAvg10 = new TextField();
    private TextField tfTime = new TextField();
    //Buttons
    private Button btNewScramble = new Button("New Scramble");
    private Button btStart = new Button("Start");
    private Button btStop = new Button("Stop");
    //Combo box
    public ComboBox cbStringLength = new ComboBox(FXCollections.observableArrayList(6,7,8,9,10));




    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));


        //create grid pane
        GridPane pane = new GridPane();
        pane.setVgap(5);
        pane.setHgap(5);
        pane.add(tfScramble, 2, 0);
        pane.add(btNewScramble, 1, 0);
        pane.add(cbStringLength, 0,0);
        pane.add(tfTime, 2, 1);
        pane.add(btStart, 0, 1);
        pane.add(btStop, 1, 1);
        pane.add(new Label("Avg 5"), 1, 2);
        pane.add(tfAvg5, 2, 2);
        pane.add(new Label("Avg 10"), 1, 3);
        pane.add(tfAvg10, 2, 3);
        cbStringLength.getSelectionModel().selectFirst();


        // Set UI properties
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHalignment(btStart, HPos.CENTER);
        pane.setHalignment(btNewScramble, HPos.CENTER);
        pane.setHalignment(cbStringLength, HPos.CENTER);
        pane.setHalignment(btStop, HPos.CENTER);



        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Cube Timer"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage


        //process events
        btNewScramble.setOnAction(e -> getScramble());
        btStart.setOnAction(e -> startTime());
        btStop.setOnAction(e -> stopTime());


    }

    //create new scramble and set it to the text field
    public void getScramble() {
        Scramble.createScramble((Integer) cbStringLength.getValue());
        tfScramble.setText(Scramble.currentScramble);
    }

    //start time
    public void startTime(){
        Stopwatch.start();
        tfTime.setText("Timing");
    }

    //stop time and set tf to the elapsed seconds
    public void stopTime(){
        Stopwatch.stop();
        tfTime.setText(String.valueOf(Stopwatch.getElapsedSeconds()) + "s");
        Times.addTime((int)     Stopwatch.getElapsedSeconds());
        getAvg5();
        getAvg10();
    }

    public void getAvg5(){
        tfAvg5.setText(String.valueOf(Times.calcAvgOfFive())+ "s");
    }

    public void getAvg10(){
        tfAvg10.setText(String.valueOf(Times.calcAvgOfTen())+ "s");
    }





    //MAIN
    public static void main(String[] args) {

        launch(args);
    }
}

