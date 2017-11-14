package grid;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.*;

import static javafx.scene.paint.Color.WHITE;
import static javafx.scene.paint.Color.color;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new pane(), 900,900);
        primaryStage.setTitle("3 X 3 Grid");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class pane extends javafx.scene.layout.Pane {
    public pane() {
        //add 2 vertical line to pane
        Line vLine1 = new Line();
        Line vLine2 = new Line();
        Line hLine1 = new Line();
        Line hLine2 = new Line();


                                    /* Vertical Line 1 */

        //vertical line 1 start points
        vLine1.startXProperty().bind(widthProperty().divide(3).subtract(1)); // divide by three and move back half of the stroke width
        vLine1.startYProperty().setValue(0);

        //vertical line 1 end points
        vLine1.endXProperty().bind(widthProperty().divide(3).subtract(1));
        vLine1.endYProperty().bind(heightProperty());

        //set other properties
        vLine1.setStrokeWidth(2);
        vLine1.setStroke(Color.GREEN);

        //add component
        getChildren().add(vLine1);
                                    /* Vertical Line 2 */

        //vertical line 2 start points
        vLine2.startXProperty().bind(widthProperty().divide(3).multiply(2).subtract(1)); // multiply by 2/3 and subtract half the stroke width
        vLine2.startYProperty().setValue(0);

        //vertical line 2 end points
        vLine2.endXProperty().bind(widthProperty().divide(3).multiply(2).subtract(1));
        vLine2.endYProperty().bind(heightProperty());

        //set other properties
        vLine2.setStrokeWidth(2);
        vLine2.setStroke(Color.GREEN);

        //add to pane
        getChildren().add(vLine2);


                                     /* Horizontal line 1 */

        //horizontal line 1 start points
        hLine1.startXProperty().setValue(0);
        hLine1.startYProperty().bind(heightProperty().divide(3).subtract(1));

        //horizontal line 1 end points
        hLine1.endXProperty().bind(widthProperty());
        hLine1.endYProperty().bind(heightProperty().divide(3).subtract(1));

        //set other properties
        hLine1.setStrokeWidth(2);
        hLine1.setStroke(Color.RED);

        //add component to pane
        getChildren().add(hLine1);


                                    /* Horizontal line 2 */

        //horizontal line 2 start points
        hLine2.startXProperty().setValue(0);
        hLine2.startYProperty().bind(heightProperty().divide(3).multiply(2).subtract(1));

        //horizontal line 2 end points
        hLine2.endXProperty().bind(widthProperty());
        hLine2.endYProperty().bind(heightProperty().divide(3).multiply(2).subtract(1));

        //set other properties
        hLine2.setStrokeWidth(2);
        hLine2.setStroke(Color.RED);

        //add component to pane
        getChildren().add(hLine2);


                                    /* circles in 3 X 3 */
        //String[] color = new String[]{"BLACK","GREEN","RED","WHITE","GRAY","CRIMSON","BEIGE","BISQUE","AQUA"};


        Circle circle_0_0 = new Circle();
        circle_0_0.centerXProperty().bind(widthProperty().divide(6));
        circle_0_0.centerYProperty().bind(heightProperty().divide(6));
        circle_0_0.radiusProperty().bind(widthProperty().multiply(heightProperty()).divide(8100));
        circle_0_0.setFill(Color.BLACK);
        getChildren().add(circle_0_0);

        Circle circle_0_1 = new Circle();
        circle_0_1.centerXProperty().bind(widthProperty().divide(2));
        circle_0_1.centerYProperty().bind(heightProperty().divide(6));
        circle_0_1.radiusProperty().bind(widthProperty().multiply(heightProperty()).divide(8100));
        circle_0_1.setFill(Color.GREEN);
        getChildren().add(circle_0_1);

        Circle circle_0_2 = new Circle();
        circle_0_2.centerXProperty().bind(widthProperty().subtract(widthProperty().divide(6)));
        circle_0_2.centerYProperty().bind(heightProperty().divide(6));
        circle_0_2.radiusProperty().bind(widthProperty().multiply(heightProperty()).divide(8100));
        circle_0_2.setFill(Color.RED);
        getChildren().add(circle_0_2);

        Circle circle_1_0 = new Circle();
        circle_1_0.centerXProperty().bind(widthProperty().divide(6));
        circle_1_0.centerYProperty().bind(heightProperty().divide(2));
        circle_1_0.radiusProperty().bind(widthProperty().multiply(heightProperty()).divide(8100));
        circle_1_0.setFill(Color.BEIGE);
        getChildren().add(circle_1_0);

        Circle circle_1_1 = new Circle();
        circle_1_1.centerXProperty().bind(widthProperty().divide(2));
        circle_1_1.centerYProperty().bind(heightProperty().divide(2));
        circle_1_1.radiusProperty().bind(widthProperty().multiply(heightProperty()).divide(8100));
        circle_1_1.setFill(Color.AQUA);
        getChildren().add(circle_1_1);

        Circle circle_1_2 = new Circle();
        circle_1_2.centerXProperty().bind(widthProperty().subtract(widthProperty().divide(6)));
        circle_1_2.centerYProperty().bind(heightProperty().divide(2));
        circle_1_2.radiusProperty().bind(widthProperty().multiply(heightProperty()).divide(8100));
        circle_1_2.setFill(Color.DARKCYAN);
        getChildren().add(circle_1_2);

        Circle circle_2_0 = new Circle();
        circle_2_0.centerXProperty().bind(widthProperty().divide(6));
        circle_2_0.centerYProperty().bind(heightProperty().subtract(heightProperty().divide(6)));
        circle_2_0.radiusProperty().bind(widthProperty().multiply(heightProperty()).divide(8100));
        circle_2_0.setFill(Color.FIREBRICK);
        getChildren().add(circle_2_0);

        Circle circle_2_1 = new Circle();
        circle_2_1.centerXProperty().bind(widthProperty().divide(2));
        circle_2_1.centerYProperty().bind(heightProperty().subtract(heightProperty().divide(6)));
        circle_2_1.radiusProperty().bind(widthProperty().multiply(heightProperty()).divide(8100));
        circle_2_1.setFill(Color.GHOSTWHITE);
        getChildren().add(circle_2_1);

        Circle circle_2_2 = new Circle();
        circle_2_2.centerXProperty().bind(widthProperty().subtract(widthProperty().divide(6)));
        circle_2_2.centerYProperty().bind(heightProperty().subtract(heightProperty().divide(6)));
        circle_2_2.radiusProperty().bind(widthProperty().multiply(heightProperty()).divide(8100));
        circle_2_2.setFill(Color.HONEYDEW);
        getChildren().add(circle_2_2);



        /*


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Circle circle = new Circle();
                circle.centerXProperty().bind(vLine1.startXProperty().divide(2).multiply(i+1));
                circle.centerYProperty().bind(hLine1.startYProperty().divide(2).multiply(j+1));
                circle.radiusProperty().bind(hLine1.startXProperty().divide(2 * (i + 1)*(j+1)));


                circle.setFill(Color.valueOf(color[i]));
                getChildren().add(circle);
            }
        }
        */

    }
}