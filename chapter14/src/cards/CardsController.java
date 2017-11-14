package cards;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class CardsController {
    ArrayList<String> list = new ArrayList<>();

    @FXML private Button changeCards;
    @FXML private ImageView image1;
    @FXML private ImageView image2;
    @FXML private ImageView image3;

    @FXML public void changeCardsClicked(ActionEvent event) {
        for (int i = 1; i <= 52 ; i++) {
            list.add(i+".png");
        }
        Collections.shuffle(list);
        image1.setImage(new Image(String.valueOf(new File("cards/card/" + list.get(0)))));
        image2.setImage(new Image(String.valueOf(new File("cards/card/" + list.get(1)))));
        image3.setImage(new Image(String.valueOf(new File("cards/card/" + list.get(2)))));

    }
}
