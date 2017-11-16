package Exercise_16_17;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ScrollBarForColor extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane outerPane = new BorderPane();
        GridPane controlPane = new GridPane();
        Pane color = new Pane();

        Circle circle = new Circle(200,300, 100);
        circle.setFill(Color.rgb(0,0,0,0.5));
        circle.setStroke(Color.BLACK);
        color.getChildren().add(circle);


        controlPane.setHgap(100);
        controlPane.setAlignment(Pos.CENTER);
        controlPane.add(new Label("Red"),0,0);
        controlPane.add(new Label("Green"),0,1);
        controlPane.add(new Label("Blue"),0,2);
        controlPane.add(new Label("Opacity"),0,3);

        ScrollBar sbRed = new ScrollBar();
        ScrollBar sbGreen = new ScrollBar();
        ScrollBar sbBlue = new ScrollBar();
        ScrollBar sbOpacity = new ScrollBar();

        sbRed.setMax(225);
        sbGreen.setMax(225);
        sbBlue.setMax(225);
        sbOpacity.setMax(1);

        sbRed.setPrefWidth(225);
        sbOpacity.setValue(.5);

        sbRed.setBlockIncrement(1);
        sbGreen.setBlockIncrement(1);
        sbBlue.setBlockIncrement(1);
        sbOpacity.setBlockIncrement(.01);


        controlPane.add(sbRed,1,0);
        controlPane.add(sbGreen,1,1);
        controlPane.add(sbBlue,1,2);
        controlPane.add(sbOpacity,1,3);

        outerPane.setBottom(controlPane);
        outerPane.setTop(color);

        primaryStage.setScene(new Scene(outerPane, 400,600));
        primaryStage.setTitle("Scroll Bar Color Change");
        primaryStage.show();

        sbRed.valueProperty().addListener(e -> {
            circle.setFill(Color.rgb((int)sbRed.getValue(), (int)sbGreen.getValue(), (int)sbBlue.getValue(), sbOpacity.getValue()));
        });

        sbGreen.valueProperty().addListener(e -> {
            circle.setFill(Color.rgb((int)sbRed.getValue(), (int)sbGreen.getValue(), (int)sbBlue.getValue(), sbOpacity.getValue()));
        });

        sbBlue.valueProperty().addListener(e -> {
            circle.setFill(Color.rgb((int)sbRed.getValue(), (int)sbGreen.getValue(), (int)sbBlue.getValue(), sbOpacity.getValue()));
        });

        sbOpacity.valueProperty().addListener(e -> {
            circle.setFill(Color.rgb((int)sbRed.getValue(), (int)sbGreen.getValue(), (int)sbBlue.getValue(), sbOpacity.getValue()));
        });
    }
}
