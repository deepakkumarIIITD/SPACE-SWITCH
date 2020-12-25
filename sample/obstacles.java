package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class obstacles {
    public static Group Color_Switch(int x , int y , int r,double speed,Circle ball){
        Arc bluearc = new Arc();

        bluearc.setFill(Color.web("#900DFF"));
        bluearc.setCenterX(x);
        bluearc.setCenterY(y);
        bluearc.setRadiusX(r*2);
        bluearc.setRadiusY(r*2);
        bluearc.setLength(r/2);
        bluearc.setStartAngle(0);
        bluearc.setType(ArcType.ROUND);

        Arc pinkarc = new Arc();

        pinkarc.setFill(Color.web("#FF0181"));
        pinkarc.setCenterX(x);
        pinkarc.setCenterY(y);
        pinkarc.setRadiusX(r*2);
        pinkarc.setRadiusY(r*2);
        pinkarc.setLength(r/2);
        pinkarc.setStartAngle(90);
        pinkarc.setType(ArcType.ROUND);

        Arc yellowarc = new Arc();

        yellowarc.setFill(Color.web("#FAE100"));
        yellowarc.setCenterX(x);
        yellowarc.setCenterY(y);
        yellowarc.setRadiusX(r*2);
        yellowarc.setRadiusY(r*2);
        yellowarc.setLength(r/2);
        yellowarc.setStartAngle(180);
        yellowarc.setType(ArcType.ROUND);

        Arc purplearc = new Arc();

        purplearc.setFill(Color.web("#32DBF0"));
        purplearc.setCenterX(x);
        purplearc.setCenterY(y);
        purplearc.setRadiusX(r*2);
        purplearc.setRadiusY(r*2);
        purplearc.setLength(r/2);
        purplearc.setStartAngle(270);
        purplearc.setType(ArcType.ROUND);

        Group obstacle = new Group();//                    Shape intersect3 = Shape.intersect(yellowarc,ball);
        Random random = new Random();
        //System.out.println(color_switch_color);
        ArrayList<String> color_change = new ArrayList<>();
        color_change.add(database.Pink);
        color_change.add(database.Voilet);
        color_change.add(database.turquoise);
        color_change.add(database.Yellow);
        int color_switch_color = random.nextInt(color_change.size());
        System.out.println(color_switch_color);
        obstacle.getChildren().addAll(bluearc,pinkarc,yellowarc,purplearc);
        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            double deltaX = 0;
            double deltaY = 3;
            double deltaX1 = speed;

            @Override
            public void handle(final ActionEvent t) {
//                ball.setLayoutX(ball.getLayoutX() + deltaX);
//                ball.setLayoutY(ball.getLayoutY() + deltaY);

                pinkarc.setStartAngle(pinkarc.getStartAngle()+deltaX1);
                purplearc.setStartAngle(purplearc.getStartAngle()+deltaX1);
                bluearc.setStartAngle(bluearc.getStartAngle()+deltaX1);
                yellowarc.setStartAngle(yellowarc.getStartAngle()+deltaX1);
                // System.out.println("inside");
                if(ball.getFill().equals(Color.web(database.Pink))||ball.getFill().equals(Color.web(database.turquoise))||ball.getFill().equals(Color.web(database.Yellow))||ball.getFill().equals(Color.web(database.Voilet))){
                    Shape intersect1 = Shape.intersect(bluearc,ball);
                    Shape intersect2 = Shape.intersect(purplearc,ball);
                    Shape intersect3 = Shape.intersect(yellowarc,ball);
                    Shape intersect4 = Shape.intersect(pinkarc,ball);

//                    //System.out.println("inside");
//                    Shape intersect2 = Shape.intersect(yellowarc,ball);
                    if (intersect1.getBoundsInParent().getWidth() != -1 ||intersect2.getBoundsInParent().getWidth() != -1 ||intersect3.getBoundsInParent().getWidth() != -1||intersect4.getBoundsInParent().getWidth() != -1  ) {
//                        System.exit(0);
                        System.out.println(color_change.get(color_switch_color));
                        ball.setFill(Color.web(color_change.get(color_switch_color)));

                    }


//                    else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
//                        System.exit(0);
//                    }
//                    else if (intersect3.getBoundsInParent().getWidth() != -1 ) {
//                        System.exit(0);
//                    }
                }

//                if(ball.getLayoutY()<200){
//                    System.out.println(ball.getLayoutY());
//                    canvas.setLayoutY(canvas.getLayoutY()+0.5);
//                }
            }
        }
        ));

        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
        return obstacle;
    }
    public static Group obstacle_ball(int x,int y,double speed,Circle ball){
        Arc arc_Pink = new Arc();
        Arc arc_Yellow = new Arc();
        Arc arc_Voilet = new Arc();
        Arc arc_turquoise = new Arc();
        arc_Pink.setFill(Color.web("#FF0181"));
        arc_turquoise.setFill(Color.web("#900DFF"));
        arc_Voilet.setFill(Color.web("#32DBF0"));
        arc_Yellow.setFill(Color.web("#FAE100"));
        arc_Pink.setCenterX(x);
        arc_Pink.setCenterY(y);
        arc_Pink.setRadiusX(100);
        arc_Pink.setRadiusY(100);
        arc_Pink.setStartAngle(0);
        arc_Pink.setLength(100);
        arc_Pink.setType(ArcType.CHORD);
        arc_turquoise.setCenterX(x);
        arc_turquoise.setCenterY(y);
        arc_turquoise.setRadiusX(100);
        arc_turquoise.setRadiusY(100);
        arc_turquoise.setStartAngle(180);
        arc_turquoise.setLength(100);
        arc_turquoise.setType(ArcType.CHORD);
        arc_Yellow.setCenterX(x);
        arc_Yellow.setCenterY(y);
        arc_Yellow.setRadiusX(100);
        arc_Yellow.setRadiusY(100);
        arc_Yellow.setStartAngle(270);
        arc_Yellow.setLength(100);
        arc_Yellow.setType(ArcType.CHORD);
        arc_Voilet.setCenterX(x);
        arc_Voilet.setCenterY(y);
        arc_Voilet.setRadiusX(100);
        arc_Voilet.setRadiusY(100);
        arc_Voilet.setStartAngle(90);
        arc_Voilet.setLength(100);
        arc_Voilet.setType(ArcType.CHORD);
        Group obstacle1 = new Group();
        obstacle1.getChildren().addAll(arc_Pink,arc_turquoise,arc_Yellow,arc_Voilet);
        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            double deltaX = 0;
            double deltaY = 3;
            double deltaX1 = speed;

            @Override
            public void handle(final ActionEvent t) {
//                ball.setLayoutX(ball.getLayoutX() + deltaX);
//                ball.setLayoutY(ball.getLayoutY() + deltaY);

                arc_Pink.setStartAngle(arc_Pink.getStartAngle()+deltaX1);
                arc_turquoise.setStartAngle(arc_turquoise.getStartAngle()+deltaX1);
                arc_Voilet.setStartAngle(arc_Voilet.getStartAngle()+deltaX1);
                arc_Yellow.setStartAngle(arc_Yellow.getStartAngle()+deltaX1);
                // obstacle1.setLayoutX(obstacle1.getLayoutX());
                if(ball.getFill().equals(Color.web(database.Pink))){
                    Shape intersect1 = Shape.intersect(arc_turquoise,ball);
                    //System.out.println("inside");
                    Shape intersect2 = Shape.intersect(arc_Voilet,ball);
                    Shape intersect3 = Shape.intersect(arc_Yellow,ball);

                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect3.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }
                if(ball.getFill().equals(Color.web(database.turquoise))){
                    Shape intersect1 = Shape.intersect(arc_Pink,ball);
                    //System.out.println("inside");
                    Shape intersect2 = Shape.intersect(arc_Voilet,ball);
                    Shape intersect3 = Shape.intersect(arc_Yellow,ball);

                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect3.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }
                if(ball.getFill().equals(Color.web(database.Voilet))){
                    Shape intersect1 = Shape.intersect(arc_Pink,ball);
                    //System.out.println("inside");
                    Shape intersect2 = Shape.intersect(arc_turquoise,ball);
                    Shape intersect3 = Shape.intersect(arc_Yellow,ball);

                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect3.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }
                if(ball.getFill().equals(Color.web(database.Yellow))){
                    Shape intersect1 = Shape.intersect(arc_turquoise,ball);
                    //System.out.println("inside");
                    Shape intersect2 = Shape.intersect(arc_Voilet   ,ball);
                    Shape intersect3 = Shape.intersect(arc_Pink   ,ball);

                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect3.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }



//                if(ball.getLayoutY()<200){
//                    System.out.println(ball.getLayoutY());
//                    canvas.setLayoutY(canvas.getLayoutY()+0.5);
//                }
            }
        }
        ));

        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
        return obstacle1;

    }
    public static Group ring1(int x , int y , int r,double speed,Circle ball){
        Arc bluearc = new Arc();

        bluearc.setFill(Color.web("#900DFF"));
        bluearc.setCenterX(x);
        bluearc.setCenterY(y);
        bluearc.setRadiusX(r*2);
        bluearc.setRadiusY(r*2);
        bluearc.setLength(r/2);
        bluearc.setStartAngle(270);
        bluearc.setType(ArcType.ROUND);

        Arc pinkarc = new Arc();

        pinkarc.setFill(Color.web("#FF0181"));
        pinkarc.setCenterX(x);
        pinkarc.setCenterY(y);
        pinkarc.setRadiusX(r*2);
        pinkarc.setRadiusY(r*2);
        pinkarc.setLength(r/2);
        pinkarc.setStartAngle(180);
        pinkarc.setType(ArcType.ROUND);

        Arc yellowarc = new Arc();

        yellowarc.setFill(Color.web("#FAE100"));
        yellowarc.setCenterX(x);
        yellowarc.setCenterY(y);
        yellowarc.setRadiusX(r*2);
        yellowarc.setRadiusY(r*2);
        yellowarc.setLength(r/2);
        yellowarc.setStartAngle(360);
        yellowarc.setType(ArcType.ROUND);

        Arc purplearc = new Arc();

        purplearc.setFill(Color.web("#32DBF0"));
        purplearc.setCenterX(x);
        purplearc.setCenterY(y);
        purplearc.setRadiusX(r*2);
        purplearc.setRadiusY(r*2);
        purplearc.setLength(r/2);
        purplearc.setStartAngle(90);
        purplearc.setType(ArcType.ROUND);

        Group obstacle = new Group();
        obstacle.getChildren().addAll(bluearc,pinkarc,yellowarc,purplearc);
        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            double deltaX = 0;
            double deltaY = 3;
            double deltaX1 = speed;

            @Override
            public void handle(final ActionEvent t) {
//                ball.setLayoutX(ball.getLayoutX() + deltaX);
//                ball.setLayoutY(ball.getLayoutY() + deltaY);

                pinkarc.setStartAngle(pinkarc.getStartAngle()+deltaX1);
                purplearc.setStartAngle(purplearc.getStartAngle()+deltaX1);
                bluearc.setStartAngle(bluearc.getStartAngle()+deltaX1);
                yellowarc.setStartAngle(yellowarc.getStartAngle()+deltaX1);
                // System.out.println("inside");
                if(ball.getFill().equals(Color.web(database.Pink))){
                    Shape intersect1 = Shape.intersect(bluearc,ball);
                    //System.out.println("inside");
                    Shape intersect2 = Shape.intersect(yellowarc,ball);
                    Shape intersect3 = Shape.intersect(purplearc,ball);

                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect3.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }
                if(ball.getFill().equals(Color.web(database.turquoise))){
                    Shape intersect1 = Shape.intersect(pinkarc,ball);
                    //System.out.println("inside");
                    Shape intersect2 = Shape.intersect(yellowarc,ball);
                    Shape intersect3 = Shape.intersect(purplearc,ball);

                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect3.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }
                if(ball.getFill().equals(Color.web(database.Voilet))){
                    Shape intersect1 = Shape.intersect(bluearc,ball);
                    //System.out.println("inside");
                    Shape intersect2 = Shape.intersect(yellowarc,ball);
                    Shape intersect3 = Shape.intersect(pinkarc,ball);

                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect3.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }
                if(ball.getFill().equals(Color.web(database.Yellow))){
                    Shape intersect1 = Shape.intersect(bluearc,ball);
                    //System.out.println("inside");
                    Shape intersect2 = Shape.intersect(pinkarc   ,ball);
                    Shape intersect3 = Shape.intersect(purplearc,ball);

                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect3.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }

//                if(ball.getLayoutY()<200){
//                    System.out.println(ball.getLayoutY());
//                    canvas.setLayoutY(canvas.getLayoutY()+0.5);
//                }
            }
        }
        ));

        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
        return obstacle;
    }
    public static Group ring2(int x , int y , int r,double speed,Circle ball){
        Arc bluearc = new Arc();

        bluearc.setFill(Color.web("#900DFF"));
        bluearc.setCenterX(x);
        bluearc.setCenterY(y);
        bluearc.setRadiusX(r*2);
        bluearc.setRadiusY(r*2);
        bluearc.setLength(r/2);
        bluearc.setStartAngle(0);
        bluearc.setType(ArcType.ROUND);

        Arc pinkarc = new Arc();

        pinkarc.setFill(Color.web("#FF0181"));
        pinkarc.setCenterX(x);
        pinkarc.setCenterY(y);
        pinkarc.setRadiusX(r*2);
        pinkarc.setRadiusY(r*2);
        pinkarc.setLength(r/2);
        pinkarc.setStartAngle(90);
        pinkarc.setType(ArcType.ROUND);

        Arc yellowarc = new Arc();

        yellowarc.setFill(Color.web("#FAE100"));
        yellowarc.setCenterX(x);
        yellowarc.setCenterY(y);
        yellowarc.setRadiusX(r*2);
        yellowarc.setRadiusY(r*2);
        yellowarc.setLength(r/2);
        yellowarc.setStartAngle(180);
        yellowarc.setType(ArcType.ROUND);

        Arc purplearc = new Arc();

        purplearc.setFill(Color.web("#32DBF0"));
        purplearc.setCenterX(x);
        purplearc.setCenterY(y);
        purplearc.setRadiusX(r*2);
        purplearc.setRadiusY(r*2);
        purplearc.setLength(r/2);
        purplearc.setStartAngle(270);
        purplearc.setType(ArcType.ROUND);

        Group obstacle = new Group();
        obstacle.getChildren().addAll(bluearc,pinkarc,yellowarc,purplearc);
        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            double deltaX = 0;
            double deltaY = 3;
            double deltaX1 = speed;

            @Override
            public void handle(final ActionEvent t) {
//                ball.setLayoutX(ball.getLayoutX() + deltaX);
//                ball.setLayoutY(ball.getLayoutY() + deltaY);

                pinkarc.setStartAngle(pinkarc.getStartAngle()+deltaX1);
                purplearc.setStartAngle(purplearc.getStartAngle()+deltaX1);
                bluearc.setStartAngle(bluearc.getStartAngle()+deltaX1);
                yellowarc.setStartAngle(yellowarc.getStartAngle()+deltaX1);
                // System.out.println("inside");
                if(ball.getFill().equals(Color.web(database.Pink))){
                    Shape intersect1 = Shape.intersect(bluearc,ball);
                    //System.out.println("inside");
                    Shape intersect2 = Shape.intersect(yellowarc,ball);
                    Shape intersect3 = Shape.intersect(purplearc,ball);

                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect3.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }
                if(ball.getFill().equals(Color.web(database.turquoise))){
                    Shape intersect1 = Shape.intersect(pinkarc,ball);
                    //System.out.println("inside");
                    Shape intersect2 = Shape.intersect(yellowarc,ball);
                    Shape intersect3 = Shape.intersect(purplearc,ball);

                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect3.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }
                if(ball.getFill().equals(Color.web(database.Voilet))){
                    Shape intersect1 = Shape.intersect(bluearc,ball);
                    //System.out.println("inside");
                    Shape intersect2 = Shape.intersect(yellowarc,ball);
                    Shape intersect3 = Shape.intersect(pinkarc,ball);

                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect3.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }
                if(ball.getFill().equals(Color.web(database.Yellow))){
                    Shape intersect1 = Shape.intersect(bluearc,ball);
                    //System.out.println("inside");
                    Shape intersect2 = Shape.intersect(pinkarc   ,ball);
                    Shape intersect3 = Shape.intersect(purplearc,ball);

                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect3.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }

//                if(ball.getLayoutY()<200){
//                    System.out.println(ball.getLayoutY());
//                    canvas.setLayoutY(canvas.getLayoutY()+0.5);
//                }
            }
        }
        ));

        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
        return obstacle;
    }
    public static Group doublering(int x , int y , int r , int nr,double speed,Circle ball){
        Arc bluearc1 = new Arc();

        bluearc1.setFill(Color.web("#900DFF"));
        bluearc1.setCenterX(x);
        bluearc1.setCenterY(y);
        bluearc1.setRadiusX(r);
        bluearc1.setRadiusY(r);
        bluearc1.setLength(90);
        bluearc1.setStartAngle(270);
        bluearc1.setType(ArcType.CHORD);

        Arc bluearc2 = new Arc();

        bluearc2.setFill(Color.web("#900DFF"));
        bluearc2.setCenterX(x);
        bluearc2.setCenterY(y);
        bluearc2.setRadiusX(nr);
        bluearc2.setRadiusY(nr);
        bluearc2.setLength(90);
        bluearc2.setStartAngle(180);
        bluearc2.setType(ArcType.CHORD);

        Arc pinkarc1 = new Arc();

        pinkarc1.setFill(Color.web("#FF0181"));
        pinkarc1.setCenterX(x);
        pinkarc1.setCenterY(y);
        pinkarc1.setRadiusX(r);
        pinkarc1.setRadiusY(r);
        pinkarc1.setLength(90);
        pinkarc1.setStartAngle(180);
        pinkarc1.setType(ArcType.CHORD);

        Arc pinkarc2 = new Arc();

        pinkarc2.setFill(Color.web("#FF0181"));
        pinkarc2.setCenterX(x);
        pinkarc2.setCenterY(y);
        pinkarc2.setRadiusX(nr);
        pinkarc2.setRadiusY(nr);
        pinkarc2.setLength(90);
        pinkarc2.setStartAngle(270);
        pinkarc2.setType(ArcType.CHORD);

        Arc yellowarc1 = new Arc();

        yellowarc1.setFill(Color.web("#FAE100"));
        yellowarc1.setCenterX(x);
        yellowarc1.setCenterY(y);
        yellowarc1.setRadiusX(r);
        yellowarc1.setRadiusY(r);
        yellowarc1.setLength(90);
        yellowarc1.setStartAngle(90);
        yellowarc1.setType(ArcType.CHORD);

        Arc yellowarc2 = new Arc();

        yellowarc2.setFill(Color.web("#FAE100"));
        yellowarc2.setCenterX(x);
        yellowarc2.setCenterY(y);
        yellowarc2.setRadiusX(nr);
        yellowarc2.setRadiusY(nr);
        yellowarc2.setLength(90);
        yellowarc2.setStartAngle(360);
        yellowarc2.setType(ArcType.CHORD);

        Arc purplearc1 = new Arc();

        purplearc1.setFill(Color.web("#32DBF0"));
        purplearc1.setCenterX(x);
        purplearc1.setCenterY(y);
        purplearc1.setRadiusX(r);
        purplearc1.setRadiusY(r);
        purplearc1.setLength(90);
        purplearc1.setStartAngle(0);
        purplearc1.setType(ArcType.CHORD);

        Arc purplearc2 = new Arc();

        purplearc2.setFill(Color.web("#32DBF0"));
        purplearc2.setCenterX(x);
        purplearc2.setCenterY(y);
        purplearc2.setRadiusX(nr);
        purplearc2.setRadiusY(nr);
        purplearc2.setLength(90);
        purplearc2.setStartAngle(90);
        purplearc2.setType(ArcType.CHORD);

        Group obstacle = new Group();
        obstacle.getChildren().addAll(bluearc1,pinkarc1,yellowarc1,purplearc1,bluearc2,pinkarc2,yellowarc2,purplearc2);
        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            double deltaX = 0;
            double deltaY = 3;
            double deltaX1 = speed;

            @Override
            public void handle(final ActionEvent t) {
//                ball.setLayoutX(ball.getLayoutX() + deltaX);
//                ball.setLayoutY(ball.getLayoutY() + deltaY);
                pinkarc1.setStartAngle(pinkarc1.getStartAngle()+deltaX1);
                purplearc1.setStartAngle(purplearc1.getStartAngle()+deltaX1);
                bluearc1.setStartAngle(bluearc1.getStartAngle()+deltaX1);
                yellowarc1.setStartAngle(yellowarc1.getStartAngle()+deltaX1);
                pinkarc2.setStartAngle(pinkarc2.getStartAngle()-deltaX1);
                purplearc2.setStartAngle(purplearc2.getStartAngle()-deltaX1);
                bluearc2.setStartAngle(bluearc2.getStartAngle()-deltaX1);
                yellowarc2.setStartAngle(yellowarc2.getStartAngle()-deltaX1);
                if(ball.getFill().equals(Color.web(database.Pink))){
                    Shape intersect1 = Shape.intersect(bluearc1,ball);
                    //System.out.println("inside");
                    Shape intersect2 = Shape.intersect(yellowarc1,ball);
                    Shape intersect3 = Shape.intersect(purplearc1,ball);
                    Shape intersect4 = Shape.intersect(bluearc2,ball);
                    //System.out.println("inside");
                    Shape intersect5 = Shape.intersect(yellowarc2,ball);
                    Shape intersect6 = Shape.intersect(purplearc2,ball);

                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect4.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect5.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect6.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }
                if(ball.getFill().equals(Color.web(database.turquoise))){
                    Shape intersect1 = Shape.intersect(pinkarc1,ball);
                    //System.out.println("inside");
                    Shape intersect2 = Shape.intersect(yellowarc1,ball);
                    Shape intersect3 = Shape.intersect(purplearc1,ball);
                    Shape intersect4 = Shape.intersect(pinkarc2,ball);
                    //System.out.println("inside");
                    Shape intersect5 = Shape.intersect(yellowarc2,ball);
                    Shape intersect6 = Shape.intersect(purplearc2,ball);

                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect4.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect5.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect6.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }
                if(ball.getFill().equals(Color.web(database.Voilet))){
                    Shape intersect1 = Shape.intersect(bluearc1,ball);
                    //System.out.println("inside");
                    Shape intersect2 = Shape.intersect(yellowarc1,ball);
                    Shape intersect3 = Shape.intersect(pinkarc1,ball);
                    Shape intersect4 = Shape.intersect(bluearc2,ball);
                    //System.out.println("inside");
                    Shape intersect5 = Shape.intersect(yellowarc2,ball);
                    Shape intersect6 = Shape.intersect(pinkarc2,ball);

                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect3.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect4.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect5.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect6.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }
                if(ball.getFill().equals(Color.web(database.Yellow))){
                    Shape intersect1 = Shape.intersect(bluearc1,ball);
                    //System.out.println("inside");
                    Shape intersect2 = Shape.intersect(pinkarc1   ,ball);
                    Shape intersect3 = Shape.intersect(purplearc1,ball);
                    Shape intersect4= Shape.intersect(bluearc2,ball);
                    //System.out.println("inside");
                    Shape intersect5 = Shape.intersect(pinkarc2 ,ball);
                    Shape intersect6 = Shape.intersect(purplearc2,ball);
                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect4.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect5.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect6.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }
            }
        }
        ));
        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
        return obstacle;
    }
    public static Group halfhalf1(int x , int y , int r , int nr,Circle ball){
        Arc bluearc = new Arc();

        bluearc.setFill(Color.web("#900DFF"));
        bluearc.setCenterX(x);
        bluearc.setCenterY(y);
        bluearc.setRadiusX(r);
        bluearc.setRadiusY(r);
        bluearc.setLength(90);
        bluearc.setStartAngle(0);
        bluearc.setType(ArcType.CHORD);

        Arc pinkarc = new Arc();

        pinkarc.setFill(Color.web("#FF0181"));
        pinkarc.setCenterX(x);
        pinkarc.setCenterY(y);
        pinkarc.setRadiusX(nr);
        pinkarc.setRadiusY(nr);
        pinkarc.setLength(90);
        pinkarc.setStartAngle(90);
        pinkarc.setType(ArcType.CHORD);

        Arc yellowarc = new Arc();

        yellowarc.setFill(Color.web("#FAE100"));
        yellowarc.setCenterX(x);
        yellowarc.setCenterY(y);
        yellowarc.setRadiusX(r);
        yellowarc.setRadiusY(r);
        yellowarc.setLength(90);
        yellowarc.setStartAngle(180);
        yellowarc.setType(ArcType.CHORD);

        Arc purplearc = new Arc();

        purplearc.setFill(Color.web("#32DBF0"));
        purplearc.setCenterX(x);
        purplearc.setCenterY(y);
        purplearc.setRadiusX(nr);
        purplearc.setRadiusY(nr);
        purplearc.setLength(90);
        purplearc.setStartAngle(270);
        purplearc.setType(ArcType.CHORD);

        Group obstacle = new Group();
        obstacle.getChildren().addAll(bluearc,pinkarc,yellowarc,purplearc);
        return obstacle;
    }
    public static Group rectangledots(int x , int y , int h , int w , int dist,double speed,Circle ball){
        Rectangle bluearc = new Rectangle();

        bluearc.setLayoutX(x);
        bluearc.setLayoutY(y);
        bluearc.setHeight(h);
        bluearc.setWidth(w);
        bluearc.setFill(Color.web("#900DFF"));

        Rectangle pinkarc = new Rectangle();

        pinkarc.setLayoutX(x+dist+w);
        pinkarc.setLayoutY(y);
        pinkarc.setHeight(h);
        pinkarc.setWidth(w);
        pinkarc.setFill(Color.web("#FF0181"));

        Rectangle yellowarc = new Rectangle();

        yellowarc.setLayoutX(x+((dist+w)*2));
        yellowarc.setLayoutY(y);
        yellowarc.setHeight(h);
        yellowarc.setWidth(w);
        yellowarc.setFill(Color.web("#FAE100"));

        Rectangle purplearc = new Rectangle();

        purplearc.setLayoutX(x+((dist+w)*3));
        purplearc.setLayoutY(y);
        purplearc.setHeight(h);
        purplearc.setWidth(w);
        purplearc.setFill(Color.web("#32DBF0"));

        Group obstacle = new Group();
        obstacle.getChildren().addAll(bluearc,pinkarc,yellowarc,purplearc);
        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            double deltaX = 0;
            double deltaY = 3;
            double deltaX1 = speed;

            @Override
            public void handle(final ActionEvent t) {
//                ball.setLayoutX(ball.getLayoutX() + deltaX);
//                ball.setLayoutY(ball.getLayoutY() + deltaY);
                if(purplearc.getLayoutX() <= 300){
                    deltaX1 = -deltaX1;
                }else if(bluearc.getLayoutX() >= 500){
                    deltaX1 = -deltaX1;
                }
                pinkarc.setLayoutX(pinkarc.getLayoutX() + deltaX1);
                bluearc.setLayoutX(bluearc.getLayoutX() + deltaX1);
                purplearc.setLayoutX(purplearc.getLayoutX() + deltaX1);
                yellowarc.setLayoutX(yellowarc.getLayoutX() + deltaX1);
                // System.out.println("inside");
                if(ball.getFill().equals(Color.web(database.Pink))){
                    Shape intersect1 = Shape.intersect(bluearc,ball);
                    //System.out.println("inside");
                    Shape intersect2 = Shape.intersect(yellowarc,ball);
                    Shape intersect3 = Shape.intersect(purplearc,ball);

                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect3.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }
                if(ball.getFill().equals(Color.web(database.turquoise))){
                    Shape intersect1 = Shape.intersect(pinkarc,ball);
                    //System.out.println("inside");
                    Shape intersect2 = Shape.intersect(yellowarc,ball);
                    Shape intersect3 = Shape.intersect(purplearc,ball);

                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect3.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }
                if(ball.getFill().equals(Color.web(database.Voilet))){
                    Shape intersect1 = Shape.intersect(bluearc,ball);
                    //System.out.println("inside");
                    Shape intersect2 = Shape.intersect(yellowarc,ball);
                    Shape intersect3 = Shape.intersect(pinkarc,ball);

                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect3.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }
                if(ball.getFill().equals(Color.web(database.Yellow))){
                    Shape intersect1 = Shape.intersect(bluearc,ball);
                    //System.out.println("inside");
                    Shape intersect2 = Shape.intersect(pinkarc   ,ball);
                    Shape intersect3 = Shape.intersect(purplearc,ball);

                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                    else if (intersect3.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }

//                if(ball.getLayoutY()<200){
//                    System.out.println(ball.getLayoutY());
//                    canvas.setLayoutY(canvas.getLayoutY()+0.5);
//                }
            }
        }
        ));

        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
        return obstacle;
    }
    public static Group ring(int x , int y , int r , double speed,Circle ball ){
        Arc bluearc = new Arc();

        bluearc.setFill(Color.web("#900DFF"));
        bluearc.setCenterX(x);
        bluearc.setCenterY(y);
        bluearc.setRadiusX(r);
        bluearc.setRadiusY(r);
        bluearc.setLength(90);
        bluearc.setStartAngle(0);
        bluearc.setType(ArcType.CHORD);

        Arc pinkarc = new Arc();

        pinkarc.setFill(Color.web("#FF0181"));
        pinkarc.setCenterX(x);
        pinkarc.setCenterY(y);
        pinkarc.setRadiusX(r);
        pinkarc.setRadiusY(r);
        pinkarc.setLength(90);
        pinkarc.setStartAngle(90);
        pinkarc.setType(ArcType.CHORD);

        Arc yellowarc = new Arc();

        yellowarc.setFill(Color.web("#FAE100"));
        yellowarc.setCenterX(x);
        yellowarc.setCenterY(y);
        yellowarc.setRadiusX(r);
        yellowarc.setRadiusY(r);
        yellowarc.setLength(90);
        yellowarc.setStartAngle(180);
        yellowarc.setType(ArcType.CHORD);

        Arc purplearc = new Arc();

        purplearc.setFill(Color.web("#32DBF0"));
        purplearc.setCenterX(x);
        purplearc.setCenterY(y);
        purplearc.setRadiusX(r);
        purplearc.setRadiusY(r);
        purplearc.setLength(90);
        purplearc.setStartAngle(270);
        purplearc.setType(ArcType.CHORD);

        Group obstacle = new Group();
        obstacle.getChildren().addAll(bluearc,pinkarc,yellowarc,purplearc);

        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            double deltaX = 0;
            double deltaY = 3;
            double deltaX1 = speed;

            @Override
            public void handle(final ActionEvent t) {
                pinkarc.setStartAngle(pinkarc.getStartAngle()+deltaX1);
                bluearc.setStartAngle(bluearc.getStartAngle()+deltaX1);
                purplearc.setStartAngle(purplearc.getStartAngle()+deltaX1);
                yellowarc.setStartAngle(yellowarc.getStartAngle()+deltaX1);
                if(ball.getFill().equals(Color.web(database.Pink))){
                    Shape intersect1 = Shape.intersect(bluearc,ball);
                    Shape intersect2 = Shape.intersect(purplearc,ball);
                    Shape intersect3 = Shape.intersect(yellowarc,ball);
                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect3.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }
                if(ball.getFill().equals(Color.web(database.turquoise))){
                    Shape intersect1 = Shape.intersect(pinkarc,ball);
                    Shape intersect2 = Shape.intersect(purplearc,ball);
                    Shape intersect3 = Shape.intersect(yellowarc,ball);
                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect3.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }
                if(ball.getFill().equals(Color.web(database.Voilet))){
                    Shape intersect1 = Shape.intersect(pinkarc,ball);
                    Shape intersect2 = Shape.intersect(bluearc,ball);
                    Shape intersect3 = Shape.intersect(yellowarc,ball);
                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect3.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }
                if(ball.getFill().equals(Color.web(database.Yellow))){
                    Shape intersect1 = Shape.intersect(bluearc,ball);
                    Shape intersect2 = Shape.intersect(purplearc   ,ball);
                    Shape intersect3 = Shape.intersect(yellowarc   ,ball);
                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect3.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }
            }
        }
        ));
        loop.setCycleCount(10000);
        loop.play();
        return obstacle;
    }

    public static Group doublering1(int x , int y , int r , int nr , double speed,Circle ball){
        Arc bluearc1 = new Arc();

        bluearc1.setFill(Color.web("#900DFF"));
        bluearc1.setCenterX(x);
        bluearc1.setCenterY(y);
        bluearc1.setRadiusX(r);
        bluearc1.setRadiusY(r);
        bluearc1.setLength(90);
        bluearc1.setStartAngle(0);
        bluearc1.setType(ArcType.CHORD);

        Arc bluearc2 = new Arc();

        bluearc2.setFill(Color.web("#900DFF"));
        bluearc2.setCenterX(x);
        bluearc2.setCenterY(y);
        bluearc2.setRadiusX(nr);
        bluearc2.setRadiusY(nr);
        bluearc2.setLength(90);
        bluearc2.setStartAngle(0);
        bluearc2.setType(ArcType.CHORD);

        Arc pinkarc1 = new Arc();

        pinkarc1.setFill(Color.web("#FF0181"));
        pinkarc1.setCenterX(x);
        pinkarc1.setCenterY(y);
        pinkarc1.setRadiusX(r);
        pinkarc1.setRadiusY(r);
        pinkarc1.setLength(90);
        pinkarc1.setStartAngle(90);
        pinkarc1.setType(ArcType.CHORD);

        Arc pinkarc2 = new Arc();

        pinkarc2.setFill(Color.web("#FF0181"));
        pinkarc2.setCenterX(x);
        pinkarc2.setCenterY(y);
        pinkarc2.setRadiusX(nr);
        pinkarc2.setRadiusY(nr);
        pinkarc2.setLength(90);
        pinkarc2.setStartAngle(90);
        pinkarc2.setType(ArcType.CHORD);

        Arc yellowarc1 = new Arc();

        yellowarc1.setFill(Color.web("#FAE100"));
        yellowarc1.setCenterX(x);
        yellowarc1.setCenterY(y);
        yellowarc1.setRadiusX(r);
        yellowarc1.setRadiusY(r);
        yellowarc1.setLength(90);
        yellowarc1.setStartAngle(180);
        yellowarc1.setType(ArcType.CHORD);

        Arc yellowarc2 = new Arc();

        yellowarc2.setFill(Color.web("#FAE100"));
        yellowarc2.setCenterX(x);
        yellowarc2.setCenterY(y);
        yellowarc2.setRadiusX(nr);
        yellowarc2.setRadiusY(nr);
        yellowarc2.setLength(90);
        yellowarc2.setStartAngle(180);
        yellowarc2.setType(ArcType.CHORD);

        Arc purplearc1 = new Arc();

        purplearc1.setFill(Color.web("#32DBF0"));
        purplearc1.setCenterX(x);
        purplearc1.setCenterY(y);
        purplearc1.setRadiusX(r);
        purplearc1.setRadiusY(r);
        purplearc1.setLength(90);
        purplearc1.setStartAngle(270);
        purplearc1.setType(ArcType.CHORD);

        Arc purplearc2 = new Arc();

        purplearc2.setFill(Color.web("#32DBF0"));
        purplearc2.setCenterX(x);
        purplearc2.setCenterY(y);
        purplearc2.setRadiusX(nr);
        purplearc2.setRadiusY(nr);
        purplearc2.setLength(90);
        purplearc2.setStartAngle(270);
        purplearc2.setType(ArcType.CHORD);

        Group obstacle = new Group();
        obstacle.getChildren().addAll(bluearc1,pinkarc1,yellowarc1,purplearc1,bluearc2,pinkarc2,yellowarc2,purplearc2);
        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            double deltaX = 0;
            double deltaY = 3;
            double deltaX1 = speed;

            @Override
            public void handle(final ActionEvent t) {
                pinkarc1.setStartAngle(pinkarc1.getStartAngle()+deltaX1);
                purplearc1.setStartAngle(purplearc1.getStartAngle()+deltaX1);
                bluearc1.setStartAngle(bluearc1.getStartAngle()+deltaX1);
                yellowarc1.setStartAngle(yellowarc1.getStartAngle()+deltaX1);
                pinkarc2.setStartAngle(pinkarc2.getStartAngle()-deltaX1);
                purplearc2.setStartAngle(purplearc2.getStartAngle()-deltaX1);
                bluearc2.setStartAngle(bluearc2.getStartAngle()-deltaX1);
                yellowarc2.setStartAngle(yellowarc2.getStartAngle()-deltaX1);
                if(ball.getFill().equals(Color.web(database.Pink))){
                    Shape intersect1 = Shape.intersect(bluearc1,ball);
                    Shape intersect2 = Shape.intersect(yellowarc1,ball);
                    Shape intersect3 = Shape.intersect(purplearc1,ball);
                    Shape intersect4 = Shape.intersect(bluearc2,ball);
                    Shape intersect5 = Shape.intersect(yellowarc2,ball);
                    Shape intersect6 = Shape.intersect(purplearc2,ball);
                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect4.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect5.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect6.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }
                if(ball.getFill().equals(Color.web(database.turquoise))){
                    Shape intersect1 = Shape.intersect(pinkarc1,ball);
                    Shape intersect2 = Shape.intersect(yellowarc1,ball);
                    Shape intersect3 = Shape.intersect(purplearc1,ball);
                    Shape intersect4 = Shape.intersect(pinkarc2,ball);
                    Shape intersect5 = Shape.intersect(yellowarc2,ball);
                    Shape intersect6 = Shape.intersect(purplearc2,ball);
                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect4.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect5.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect6.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }
                if(ball.getFill().equals(Color.web(database.Voilet))){
                    Shape intersect1 = Shape.intersect(bluearc1,ball);
                    Shape intersect2 = Shape.intersect(yellowarc1,ball);
                    Shape intersect3 = Shape.intersect(pinkarc1,ball);
                    Shape intersect4 = Shape.intersect(bluearc2,ball);
                    Shape intersect5 = Shape.intersect(yellowarc2,ball);
                    Shape intersect6 = Shape.intersect(pinkarc2,ball);
                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect3.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect4.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect5.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect6.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }
                if(ball.getFill().equals(Color.web(database.Yellow))){
                    Shape intersect1 = Shape.intersect(bluearc1,ball);
                    Shape intersect2 = Shape.intersect(pinkarc1   ,ball);
                    Shape intersect3 = Shape.intersect(purplearc1,ball);
                    Shape intersect4= Shape.intersect(bluearc2,ball);
                    Shape intersect5 = Shape.intersect(pinkarc2 ,ball);
                    Shape intersect6 = Shape.intersect(purplearc2,ball);
                    if (intersect1.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect2.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect4.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect5.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    } else if (intersect6.getBoundsInParent().getWidth() != -1 ) {
                        System.exit(0);
                    }
                }
            }
        }
        ));
        loop.setCycleCount(10000);
        loop.play();
        return obstacle;
    }

    public static Group halfhalf(int x , int y , int r , int nr){
        Arc bluearc = new Arc();

        bluearc.setFill(Color.web("#900DFF"));
        bluearc.setCenterX(x);
        bluearc.setCenterY(y);
        bluearc.setRadiusX(r);
        bluearc.setRadiusY(r);
        bluearc.setLength(90);
        bluearc.setStartAngle(0);
        bluearc.setType(ArcType.CHORD);

        Arc pinkarc = new Arc();

        pinkarc.setFill(Color.web("#FF0181"));
        pinkarc.setCenterX(x);
        pinkarc.setCenterY(y);
        pinkarc.setRadiusX(nr);
        pinkarc.setRadiusY(nr);
        pinkarc.setLength(90);
        pinkarc.setStartAngle(90);
        pinkarc.setType(ArcType.CHORD);

        Arc yellowarc = new Arc();

        yellowarc.setFill(Color.web("#FAE100"));
        yellowarc.setCenterX(x);
        yellowarc.setCenterY(y);
        yellowarc.setRadiusX(r);
        yellowarc.setRadiusY(r);
        yellowarc.setLength(90);
        yellowarc.setStartAngle(180);
        yellowarc.setType(ArcType.CHORD);

        Arc purplearc = new Arc();

        purplearc.setFill(Color.web("#32DBF0"));
        purplearc.setCenterX(x);
        purplearc.setCenterY(y);
        purplearc.setRadiusX(nr);
        purplearc.setRadiusY(nr);
        purplearc.setLength(90);
        purplearc.setStartAngle(270);
        purplearc.setType(ArcType.CHORD);

        Group obstacle = new Group();
        obstacle.getChildren().addAll(bluearc,pinkarc,yellowarc,purplearc);
        return obstacle;
    }

    public static Group rectangledots(int x , int y , int h , int w , int dist,Circle ball){
        Rectangle bluerec = new Rectangle();

        bluerec.setLayoutX(x);
        bluerec.setLayoutY(y);
        bluerec.setHeight(h);
        bluerec.setWidth(w);
        bluerec.setFill(Color.web("#900DFF"));

        Rectangle pinkrec = new Rectangle();

        pinkrec.setLayoutX(x+dist+w);
        pinkrec.setLayoutY(y);
        pinkrec.setHeight(h);
        pinkrec.setWidth(w);
        pinkrec.setFill(Color.web("#FF0181"));

        Rectangle yellowrec = new Rectangle();

        yellowrec.setLayoutX(x+((dist+w)*2));
        yellowrec.setLayoutY(y);
        yellowrec.setHeight(h);
        yellowrec.setWidth(w);
        yellowrec.setFill(Color.web("#FAE100"));

        Rectangle purplerec = new Rectangle();

        purplerec.setLayoutX(x+((dist+w)*3));
        purplerec.setLayoutY(y);
        purplerec.setHeight(h);
        purplerec.setWidth(w);
        purplerec.setFill(Color.web("#32DBF0"));

        Group obstacle = new Group();
        obstacle.getChildren().addAll(bluerec,pinkrec,yellowrec,purplerec);
        return obstacle;
    }

    public static Group colorblock(int x , int y , int h , int w){
        String[] colors = {"#FF0181" , "#FAE100" , "#32DBF0" , "#900DFF"};
        Random r = new Random();
        String color = colors[r.nextInt(4)];

        Rectangle block = new Rectangle();

        block.setLayoutX(x);
        block.setLayoutY(y);
        block.setHeight(h);
        block.setWidth(w);
        block.setStrokeWidth(10);
        block.setFill(Color.web(color));
        block.setStroke(Color.web(color));

        Group obstacle = new Group();
        obstacle.getChildren().addAll(block);
        return obstacle;
    }

    public static Group thinlongblock(int x , int y){
        return colorblock(x,y,200,20);
    }

    public static Group midlongblock(int x , int y){
        return colorblock(x,y,200,40);
    }

    public static Group fatlongblock(int x , int y){
        return colorblock(x,y,200,60);
    }

    public static Group thinsmallblock(int x , int y){
        return colorblock(x,y,100,20);
    }

    public static Group midsmallblock(int x , int y){
        return colorblock(x,y,100,40);
    }

    public static Group fatsmallblock(int x , int y){
        return colorblock(x,y,100,60);
    }
}