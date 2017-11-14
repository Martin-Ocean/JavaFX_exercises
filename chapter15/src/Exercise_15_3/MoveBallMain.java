package Exercise_15_3;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MoveBallMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        BallPane pane = new BallPane();

        Scene scene = new Scene(pane, 400,600);
        primaryStage.setTitle("Bounce Ball");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}

class BallPane extends Pane {

    Circle ball = new Circle(200, 200, 50);
    Button Left, Right, Up, Down;

    public BallPane() {
        ball.setFill(Color.BLACK);
        ball.setStroke(Color.GOLD);

        Left = new Button("Left");
        Right = new Button("Right");
        Up = new Button("Up");
        Down = new Button("Down");

        //set button size
        Left.prefWidthProperty().bind(widthProperty().divide(6));
        Left.prefHeightProperty().bind(heightProperty().divide(24));

        Right.prefWidthProperty().bind(widthProperty().divide(6));
        Right.prefHeightProperty().bind(heightProperty().divide(24));

        Up.prefWidthProperty().bind(widthProperty().divide(6));
        Up.prefHeightProperty().bind(heightProperty().divide(24));

        Down.prefWidthProperty().bind(widthProperty().divide(6));
        Down.prefHeightProperty().bind(heightProperty().divide(24));

        ReadOnlyDoubleProperty paneWidth = widthProperty();
        ReadOnlyDoubleProperty paneHeight = heightProperty();

        //set button locations
        Left.layoutXProperty().bind(paneWidth.divide(6).subtract(paneWidth.divide(12)));
        Left.layoutYProperty().bind(paneHeight.subtract(paneHeight.divide(8)));

        Right.layoutXProperty().bind(paneWidth.subtract(paneWidth.divide(4)));
        Right.layoutYProperty().bind(paneHeight.subtract(paneHeight.divide(8)));

        Up.layoutXProperty().bind(paneWidth.divide(2).subtract(paneWidth.divide(12)));
        Up.layoutYProperty().bind(paneHeight.subtract(paneHeight.divide(6)));

        Down.layoutXProperty().bind(paneWidth.divide(2).subtract(paneWidth.divide(12)));
        Down.layoutYProperty().bind(paneHeight.subtract(paneHeight.divide(12)));


        //add component to pane
        getChildren().add(Left);
        getChildren().add(Up);
        getChildren().add(Down);
        getChildren().add(Right);
        getChildren().add(ball);


        //btn on click event
        Left.setOnMouseClicked(e -> {
            double x = ball.getCenterX();
            if (x > ball.getRadius()) {
                ball.setCenterX(ball.getCenterX() - 50);
            }
        });

        Right.setOnMouseClicked(e -> {
            double x = ball.getCenterX();
            if ((widthProperty().subtract(x).get()) > ball.getRadius()) {
                ball.setCenterX(ball.getCenterX() + 50);
            }
        });

        Up.setOnMouseClicked(e -> {
            double y = ball.getCenterY();
            if(y > ball.getRadius()) ball.setCenterY(ball.getCenterY() - 50);
        });

        Down.setOnMouseClicked(e -> {
            double y = ball.getCenterY();
            if (y < (paneHeight.subtract(paneHeight.divide(6)).subtract(ball.radiusProperty()).get())) {
                ball.setCenterY(ball.getCenterY() + 50);
            }
        });

    }


}