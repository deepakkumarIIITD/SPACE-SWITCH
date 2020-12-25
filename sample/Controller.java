package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    //Stage stage = new Stage();
    @FXML
    private AnchorPane showPane;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    void leaderboard(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("leaderboard.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();
    }

    @FXML
    void exitthegame(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void loadpresentgame(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("loadpagefxml.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();
    }

    @FXML
    void newgametobemade(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("newgamepagefxml.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
    }


}