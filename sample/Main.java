//package sample;
//
//import javafx.animation.KeyFrame;
//import javafx.animation.ScaleTransition;
//import javafx.animation.Timeline;
//import javafx.animation.TranslateTransition;
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.input.KeyCode;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.layout.Pane;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.*;
//import javafx.stage.Stage;
//import javafx.util.Duration;
//import java.util.ArrayList;
//import java.util.Random;
//
//public class Main extends Application {
//    static boolean abc = false;
//    static ArrayList<String> colors = new ArrayList<>();
//    static int check_layout = 1;
//    public static Pane canvas;
//    static  Circle c = new Circle();
//    static Circle ball = new Circle( 15,Color.web(database.Pink));
//
////    @Override
//    public void start(final Stage primaryStage) {
//        colors.add(database.Pink);
//        colors.add(database.turquoise);
//        colors.add(database.Yellow);
//        colors.add(database.Voilet);
//        ball.relocate(400, 700);
//        Group ring1 = obstacles.smallring(400,500,ball);
//        Group ring2 = obstacles.midring(400,0,ball);
//        canvas.getChildren().addAll(ball,ring1,ring2);
//        ArrayList<Group> groups = new ArrayList<>();
//        groups.add(ring1);
//        groups.add(ring2);
//        ring2.translateXProperty();
//        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(4000), new EventHandler<ActionEvent>() {
//            double deltaX = 0;
//            double deltaY = 3;
//            double deltaX1 = 1;
//            int total = 0;
//            int one = -400;
//            int two = -800;
//            int three = -1200;
//            int four = -1600;
//            public void handle(final ActionEvent t) {
//                ArrayList<Integer> infinite = new ArrayList<>();
//                ArrayList<Integer> check = new ArrayList<>();
//                infinite.add(one);
//                infinite.add(two);
//                infinite.add(three);
//                infinite.add(four);
//                Random random = new Random();
//                while(check.size()!=infinite.size()){
//                    int j_random = random.nextInt(infinite.size());
//                    if(!check.contains(j_random)){
//                        check.add(j_random);
//                    }
//                }
//                ArrayList<Integer> random__arr = new ArrayList<>();
//                for(int k:check){
//                    random__arr.add(infinite.get(k));
//                }
//                System.out.println(random__arr);
//                canvas.getChildren().addAll(obstacles.smallsmalldoublering(400,random__arr.get(0),ball));
//                System.out.println(canvas.getChildren());
//                total =-1600;
//                one+=total;
//                two+=total;
//                three+=total;
//                four+=total;
//                int b=3;
//            }
//        }
//        ));
//        double deltaY = -40;
//        TranslateTransition translate = new TranslateTransition();
//        translate.setNode(ball);
//        canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            int i = 0;
//            int j = 0;
//            int k = 0;
//            @Override
//            public void handle(KeyEvent keyEvent) {
//                if (keyEvent.getCode() == KeyCode.SPACE){
//                    ball.setLayoutY(ball.getLayoutY() + deltaY);
//                    translate.setByY(1000);
//                    translate.setDuration(Duration.millis(18000));
//                    System.out.println("space is pressed");
//                    translate.play();
//                    if(ball.getLayoutY()<300 && ball.getLayoutY()>200|| ball.getLayoutY()<-350*i && ball.getLayoutY()>-400*4*i){ //ball.getLayoutY()>-100 + j ){
//                        if(k!=1){
//                            i=i+1;
//                            j = j-700;
//                            System.out.println(i);
//                            System.out.println(j);}
//                        k++;
//                        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
//                            double deltaX = 0;
//                            double deltaY = 3;
//                            double deltaX1 = 1;
//                            @Override
//                            public void handle(final ActionEvent t) {
//                                System.out.println(ball.getLayoutY());
//                                canvas.setLayoutY(canvas.getLayoutY()+1);
//                            }
//                        }
//                        ));
//                        loop.setCycleCount(200);
//                        loop.play();
//                    }
//                }
//            }
//        });
//        loop.setCycleCount(Timeline.INDEFINITE);
//        loop.play();
////        primaryStage.setScene(scene);
////        primaryStage.show();
//        ball.requestFocus();
//    }
////    public static void main(final String[] args) {
//////        Pane abc = new Pane();
////        if(abc) {
////            launch(args);
////        }
////    }
//}