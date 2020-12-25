package sample;
/**
 * Sample Skeleton for 'gamepagefxml.fxml' Controller Class
 */

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.w3c.dom.css.Rect;

public class gamepagecontroller extends intro implements Initializable {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private AnchorPane canvas;


    @FXML
    private ImageView pausebutton;

    @FXML
    private ImageView logo;

    @FXML
    public Label Stars;

    @FXML
    private Label starlable;

    @FXML
    private Label clk;

    public static boolean abc = false;

    @FXML
    void pauseclicked(MouseEvent event) throws IOException {
        abc = true;
//        canvas.getChildren().removeAll();
//        database.currentplayer.savefunc(ball.getLayoutY() , Score);
//        loop.pl
        Parent root = FXMLLoader.load(getClass().getResource("pausefxml.fxml"));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();
    }
    public static ArrayList<String> colors = new ArrayList<>();
//    public static
    public static int Score =0;

    @FXML
    void clicktostart(MouseEvent event) {
        Stars.setText(Integer.toString(database.currentplayer.getStars()));
        clk.setText(" ");
        colors.add(database.Pink);
        colors.add(database.turquoise);
        colors.add(database.Yellow);
        Circle ball = new Circle( 15);
        colors.add(database.Voilet);
        Random random = new Random();
        int ball_color = random.nextInt(colors.size());
        ball.setFill(Color.web(colors.get(ball_color)));
        ball.relocate(400, 700);
        Group circle1 = obstacles.obstacle_ball(400,500,0.7,ball);
        Group circle2 = obstacles.obstacle_ball(400,0,0.7,ball);
        canvas.getChildren().addAll(ball,circle1,circle2);
        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(4000), new EventHandler<ActionEvent>() {
            double deltaX = 0;
            double deltaY = 3;
            double deltaX1 = 1;
            int total = 0;
            int one = -400;
            int two = -800;
            int three = -1200;
            int four = -1600;
            int five = -2000;
            public void handle(final ActionEvent t) {
                ArrayList<Integer> infinite = new ArrayList<>();
                ArrayList<Integer> check = new ArrayList<>();
                infinite.add(one);
                infinite.add(two);
                infinite.add(three);
                infinite.add(four);
                infinite.add(five);
                Random random = new Random();
                while(check.size()!=infinite.size()){
                    int j_random = random.nextInt(infinite.size());
                    if(!check.contains(j_random)){
                        check.add(j_random);
                    }
                }
                ArrayList<Integer> random__arr = new ArrayList<>();
                for(int k:check){
                    random__arr.add(infinite.get(k));
                }
                canvas.getChildren().addAll(obstacles.doublering(400,random__arr.get(0),90,120,0.7,ball),obstacles.ring1(320,random__arr.get(4),60,1,ball),obstacles.ring2(500,random__arr.get(1),60,-1 ,ball),obstacles.Color_Switch(400,random__arr.get(2),10,1,ball),obstacles.rectangledots(20,random__arr.get(3),50,150,50,2,ball));
                total =-2000;
                one+=total;
                two+=total;
                three+=total;
                four+=total;
                five+=total;
                int b=3;
            }
        }
        ));
        double deltaY = -40;
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(ball);
        canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
            int i = 0;
            int j = 0;
            int k = 0;
            int allocate_stars = 0;
            int allocate_bonus_stars=200;
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.SPACE){
                    ball.setLayoutY(ball.getLayoutY() + deltaY);
                    canvas.getChildren().addAll(stars(400,allocate_stars,10,Stars,ball));
                    allocate_stars-=600;
                    canvas.getChildren().addAll(bonus(400,allocate_bonus_stars,20,Stars,ball));
                    allocate_bonus_stars-=1500;
                    translate.setByY(1000);
                    translate.setDuration(Duration.millis(18000));
                    translate.play();
                    if(ball.getLayoutY()<300 && ball.getLayoutY()>200|| ball.getLayoutY()<-350*i && ball.getLayoutY()>-400*4*i){ //ball.getLayoutY()>-100 + j ){
                        if(k!=1){
                            i=i+1;
                            j = j-700;}
                        k++;
                        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(final ActionEvent t) {
                                canvas.setLayoutY(canvas.getLayoutY()+1);
                                pausebutton.setLayoutY(pausebutton.getLayoutY() - 1);
                                starlable.setLayoutY(starlable.getLayoutY() - 1);
                                logo.setLayoutY(logo.getLayoutY() - 1);
                                Stars.setLayoutY(Stars.getLayoutY() - 1);
                            }
                        }
                        ));
                        loop.setCycleCount(200);
                        loop.play();
                    }
                }
            }
        });
        loop.setCycleCount(Timeline.INDEFINITE);
        if(abc){
            loop.pause();
        }else{
            loop.play();
        }
        ball.requestFocus();
    }

    public  static Group stars(int x,int y,int size,Label Stars,Circle ball){
        Rectangle star = new Rectangle(20,20);
        star.relocate(x,y);
        star.setFill(Color.WHITE);
        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(700), new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent t) {
                Shape intersect1 = Shape.intersect(star,ball);
                if (intersect1.getBoundsInParent().getWidth() != -1 ){
                    Score+=10;
                    Stars.setText(Integer.toString(Score));
                }
            }
        }
        ));
        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
        Group stars = new Group();
        stars.getChildren().addAll(star);
        return stars;

    }
    public  static Group bonus(int x,int y,int size,Label Stars,Circle ball){
        Rectangle star = new Rectangle(30,30);
        star.relocate(x,y);
        star.setFill(Color.GOLD);
        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(700), new EventHandler<ActionEvent>() {
            double deltaX = 0;
            double deltaY = 3;
            double deltaX1 = 0;
            @Override
            public void handle(final ActionEvent t) {
                Shape intersect1 = Shape.intersect(star,ball);
                if (intersect1.getBoundsInParent().getWidth() != -1 ){
                    Score+=50;
                    Stars.setText(Integer.toString(Score));
                }
            }
        }
        ));
        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
        Group stars = new Group();
        stars.getChildren().addAll(star);
        return stars;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
