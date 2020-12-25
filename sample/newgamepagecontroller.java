package sample;

/**
 * Sample Skeleton for 'newgamepagefxml.fxml' Controller Class
 */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class newgamepagecontroller implements Initializable{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private Spinner agefeild;

    @FXML
    private TextField namefeild;

    public static player currentplayer;

    @FXML
    void donefunction(MouseEvent event) throws IOException, InterruptedException {
        while (true){
            try {
                String name = namefeild.getText();
                int age = (int) agefeild.getValue();
                name = name.replaceAll("\\s","");
                currentplayer = new player(name,age);
                database.playersDatabase.add(currentplayer);
                database.currentplayer = currentplayer;
                break;
            }
            catch(Exception e) {

            }
        }
        Parent root = FXMLLoader.load(getClass().getResource("iddisplay.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
