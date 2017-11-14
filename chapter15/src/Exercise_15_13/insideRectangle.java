package Exercise_15_13;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class insideRectangle extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Rectangle rectangle = new Rectangle();
        Scene scene = new Scene(rectangle, 300 ,200);
        primaryStage.setTitle("Is it in the Rectangle?");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class Rectangle extends Pane {
 // Rectangle centered at (100, 60) height 40 width 100

    public Rectangle() {
        javafx.scene.shape.Rectangle rectangle = new javafx.scene.shape.Rectangle(100, 60, 100, 40);
        Text text = new Text();
        text.setX(100);
        text.setY(180);
        text.setText("Click anywhere");
        rectangle.setFill(Color.BLACK);
        rectangle.setStroke(Color.GOLD);
        rectangle.setStrokeWidth(5);
        getChildren().add(rectangle);
        getChildren().add(text);


        setOnMouseClicked(e -> {
            System.out.println(e.getSceneX() + ", " + e.getSceneY());
            if(e.getSceneX() >= 100 && e.getSceneX() <= 200 && e.getSceneY() >= 60 && e.getSceneY() <= 100) text.setText("Inside");
            else text.setText("Outside");
        });
    }

}
