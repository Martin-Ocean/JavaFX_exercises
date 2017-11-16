package Exercise_16_3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import sun.jvm.hotspot.memory.ParNewGeneration;

public class TrafficLights extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Traffic ");
        primaryStage.setScene(new Scene(new Pane(), 300, 270));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

class Pane extends javafx.scene.layout.BorderPane {
    RadioButton rbRed, rbGreen, rbYellow;

    public Pane () {

        // two v boxes for lights options and the image

        VBox rbPane = new VBox(30);
        VBox imageBox = new VBox(20);
        rbPane.setPadding(new Insets(5,5,5,5));

        // create radio buttons
        rbRed = new RadioButton("Red");
        rbGreen = new RadioButton("Green");
        rbYellow = new RadioButton("Yellow");

        // group buttons so that only one can be selected at one time
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbGreen.setToggleGroup(group);
        rbYellow.setToggleGroup(group);

        //add lights
        Circle cRed = new Circle();
        Circle cGreen = new Circle();
        Circle cYellow = new Circle();

        //set radius
        cRed.setRadius(20);
        cGreen.setRadius(20);
        cYellow.setRadius(20);

        //set fillings
        cRed.setFill(Color.WHITE);
        cGreen.setFill(Color.WHITE);
        cYellow.setFill(Color.WHITE);

        cRed.setStroke(Color.BLACK);
        cGreen.setStroke(Color.BLACK);
        cYellow.setStroke(Color.BLACK);

        rbRed.setOnAction(e -> {
            if (rbRed.isSelected()) {
                cGreen.setFill(Color.WHITE);
                cYellow.setFill(Color.WHITE);
                cRed.setFill(Color.RED);
            }
        });

        rbGreen.setOnAction(e -> {
            if (rbGreen.isSelected()) {
                cRed.setFill(Color.WHITE);
                cYellow.setFill(Color.WHITE);
                cGreen.setFill(Color.GREEN);
            }
        });

        rbYellow.setOnAction(e -> {
            if (rbYellow.isSelected()) {
                cRed.setFill(Color.WHITE);
                cGreen.setFill(Color.WHITE);
                cYellow.setFill(Color.YELLOW);
            }
        });

        imageBox.getChildren().addAll(cRed, cGreen, cYellow);
        rbPane.getChildren().addAll(rbRed, rbGreen, rbYellow);
        setLeft(rbPane);
        setCenter(imageBox);
    }
}