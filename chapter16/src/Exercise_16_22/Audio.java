package Exercise_16_22;

import com.sun.tools.javah.Gen;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.io.File;
import java.io.FilenameFilter;
import java.net.FileNameMap;
import java.util.ArrayList;

public class Audio extends Application {
  /*GenericExtFilter filter = new GenericExtFilter(".mp3");
  File dir = new File("Exercise_16_22.audio");
  String[] list = dir.list(filter);
*/



  AudioClip audioClip = new AudioClip("./audio/china.mp3");

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {

    Button btPlay = new Button("Play");
    Button btLoop = new Button("Loop");
    Button btStop = new Button("Stop");

    ComboBox items = new ComboBox();
    /*for (int i = 0; i < list.length; i++) {
      items.getItems().add(list[i]);
    }*/
    
    HBox hBox = new HBox(5);
    hBox.setAlignment(Pos.CENTER);
    hBox.getChildren().addAll(btPlay, btLoop, btStop);
    
    btPlay.setOnAction(e -> {
      audioClip.setCycleCount(1);
      audioClip.play();
    });

    btLoop.setOnAction(e -> {
      audioClip.setCycleCount(Timeline.INDEFINITE);
      audioClip.play();
    });

    btStop.setOnAction(e -> {
      audioClip.stop();
    });
        
    // Create a scene and place it in the stage
    Scene scene = new Scene(hBox, 200, 100);
    primaryStage.setTitle("Audio"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}

class GenericExtFilter implements FilenameFilter {
  private String ext;
  public GenericExtFilter(String ext) {
    this.ext = ext;
  }

  @Override
  public boolean accept(File dir, String name) {
    return (name.endsWith(ext));
  }
}
