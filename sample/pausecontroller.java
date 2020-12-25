package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class pausecontroller extends gamepagecontroller implements Initializable{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    void exitfunction(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();
    }

    @FXML
    void helpfunction(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("helpfxml.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();
    }

    @FXML
    void newgamefunction(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("newgamepagefxml.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();
    }

    @FXML
    void resumefunction(MouseEvent event) throws IOException {
        abc = false;
        Parent root = FXMLLoader.load(getClass().getResource("iddisplay.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();
    }

    @FXML
    void savefunction(MouseEvent event) throws IOException {
        database.currentplayer.setTotalpoints(database.currentplayer.getTotalpoints() + database.currentplayer.ballstar);
        database.playersDatabase.add(newgamepagecontroller.currentplayer);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
