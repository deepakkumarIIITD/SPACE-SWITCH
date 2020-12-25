package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class leaderboardcontroller implements Initializable {
    //Stage stage = new Stage();

    public static int firstpos = -1;

    public static int secondpos = -1;

    public static int thirdpos = -1;

    @FXML
    private Label third;

    @FXML
    private Label first;

    @FXML
    private Label second;

    @FXML
    private AnchorPane showPane;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    void backtomain(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();
    }

    public void resultmaker() {
        int[] ranks = new int[database.playersDatabase.size()];
        int[] pos = new int[database.playersDatabase.size()];
        for (int i = 0; i < database.playersDatabase.size(); i++) {
            ranks[i] = database.playersDatabase.get(i).getTotalpoints();
            pos[i] = i;
        }
        for (int i = 0; i < ranks.length; i++) {
            for (int j = i + 1; j < ranks.length; j++) {
                int tmp = 0;
                if (ranks[i] > ranks[j]) {
                    tmp = ranks[i];
                    ranks[i] = ranks[j];
                    ranks[j] = tmp;

                    tmp = pos[i];
                    pos[i] = pos[j];
                    pos[j] = tmp;
                }
            }
        }
        try {
            firstpos = pos[pos.length - 1];
        }
        catch(Exception e) { }
        try {
            secondpos = pos[pos.length - 2];
        }
        catch(Exception e) { }
        try {
            thirdpos = pos[pos.length - 3];
        }
        catch(Exception e) { }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        resultmaker();
        if(firstpos != -1){
            String id = "";
            String total = "";
            id = database.playersDatabase.get(firstpos).getId();
            total = Integer.toString(database.playersDatabase.get(firstpos).getTotalpoints());
            first.setText("ID : \n"+id+"\nTOTAL : \n"+total);
            if(secondpos != -1){
                id = database.playersDatabase.get(secondpos).getId();
                total = Integer.toString(database.playersDatabase.get(secondpos).getTotalpoints());
                second.setText("ID : \n"+id+"\nTOTAL : \n"+total);
                if(thirdpos != -1){
                    id = database.playersDatabase.get(thirdpos).getId();
                    total = Integer.toString(database.playersDatabase.get(thirdpos).getTotalpoints());
                    third.setText("ID : \n"+id+"\nTOTAL : \n"+total);
                }else{
                    third.setText("NO\nUSER\nPRESENT");
                }
            }else{
                third.setText("NO\nUSER\nPRESENT");
                second.setText("NO\nUSER\nPRESENT");
            }
        }else{
            third.setText("NO\nUSER\nPRESENT");
            second.setText("NO\nUSER\nPRESENT");
            first.setText("NO\nUSER\nPRESENT");
        }
    }


}