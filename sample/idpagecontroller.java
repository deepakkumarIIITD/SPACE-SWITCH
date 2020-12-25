package sample;

import javafx.application.Application;
import javafx.fxml.FXML;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class idpagecontroller implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label displayarea;

    @FXML
    void next(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass() .getResource("gamepage.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root, Color.web("#272727")));
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String labelstring = "";
        labelstring += "YOUR PLAYER ID IS\n" + database.currentplayer.getId() + "\nCLICK ANYWHERE TO CONTINUE";
        displayarea.setText(labelstring);
    }
}