import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class TaskThreadDemo extends Application {
    private static TextArea textArea = new TextArea();
    // Create tasks
    Runnable printA = new PrintChar('a', 100);
    Runnable printB = new PrintChar('b', 100);
    Runnable print100 = new PrintNum(100);

    // Create threads
    Thread thread1 = new Thread(printA);
    Thread thread2 = new Thread(printB);
    Thread thread3 = new Thread(print100);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(display(), 600, 300));
        primaryStage.setTitle("Threading");
        primaryStage.show();
    }

    private Parent display() {
        Pane root = new Pane();
        VBox vb = new VBox();
        textArea = new TextArea("Hit start to begin");
        Button btn = new Button("Start");
        vb.getChildren().addAll(textArea, btn);
        vb.setAlignment(Pos.CENTER);
        root.getChildren().add(vb);

        btn.setOnMouseClicked(e -> {
            textArea.setText("");


            // Start threads
            thread1.start();
            thread2.start();
            thread3.start();
        });
        return root;
    }


    // The task for printing a specified character in specified times
     class PrintChar implements Runnable {
        private char charToPrint; // The character to print
        private int times; // The times to repeat

        /**
         * Construct a task with specified character and number of
         * times to print the character
         */
        public PrintChar(char c, int t) {
            charToPrint = c;
            times = t;
        }

        @Override
        /** Override the run() method to tell the system
         *  what the task to perform
         */
        public void run() {
            for (int i = 0; i < times; i++) {
                if (i%10 == 0)
                    textArea.appendText("\n");

                textArea.appendText(charToPrint + " ");
            }
        }
    }


    // The task class for printing number from 1 to n for a given n
     class PrintNum implements Runnable {
        private int lastNum;

        /**
         * Construct a task for printing 1, 2, ... i
         */
        public PrintNum(int n) {
            lastNum = n;
        }

        @Override
        /** Tell the thread how to run */
        public void run() {
            for (int i = 1; i <= lastNum; i++) {
                if (i%10 == 0)
                    textArea.appendText("\n");

                textArea.appendText(i + " ");
            }
        }
    }
}