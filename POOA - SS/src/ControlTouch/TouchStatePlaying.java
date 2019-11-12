package ControlTouch;

import People.StatePlayer;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.TouchEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import sample.Main;

import java.util.ArrayList;

public final class TouchStatePlaying extends Touch {
    public static Rectangle dash = new Rectangle(60,60);
    public static Rectangle recoge=new Rectangle(60,60);
    public  static Shape dpad;
    public static Button botonRegresa=new Button("Regresa al menu");
    ArrayList<Node> Node;

    static {
        //Cntrol de movimiento
        dpad = Shape.subtract(new Rectangle(50, 300, 150, 150),
                new Rectangle(100, 350, 50,50));
        dpad.setOnTouchMoved(new EventHandler<TouchEvent>() {
            @Override
            public void handle(TouchEvent event) {
                Main.x = event.getTouchPoint().getX() - 125;
                Main.y = event.getTouchPoint().getY() - 375;
                if(Main.x >= - 75 && Main.x <= - 25)
                {
                    Main.dx=-2;
                    Main.jugador.setState(StatePlayer.izquierda);
                }
                else if(Main.x >= 25 && Main.x <= 75)
                {
                    Main.dx=2;
                    Main.jugador.setState(StatePlayer.derecha);
                }
                else
                {
                    Main.dx=0;
                  //  Main.jugador.setState(StatePlayer.Parato);
                }
                if(Main.y >= - 75 && Main.y <= -25)
                {
                    Main.dy=-2;
                    Main.jugador.setState(StatePlayer.arriba);
                }
                else if(Main.y >= 25 && Main.y <= 75)
                    {
                        Main.dy=2;
                        Main.jugador.setState(StatePlayer.abajo);
                    }
                else
                {
                    Main.dy=0;
                 //   Main.jugador.setState(StatePlayer.Parato);
                }
            }
        });
        dpad.setOnTouchReleased(new EventHandler<TouchEvent>() {
            @Override
            public void handle(TouchEvent event) {
                Main.dx=0;
                Main.dy=0;
               // Main.jugador.setState(StatePlayer.Parato);
            }
        });

        dash.setX(700);
        dash.setY(400);
        dash.setOnTouchPressed(new EventHandler<TouchEvent>() {
            @Override
            public void handle(TouchEvent event) {
             //   System.out.println("dash dash dash ");

            }
        });
        dash.setOnTouchReleased(new EventHandler<TouchEvent>() {
            @Override
            public void handle(TouchEvent event) {
                Main.dx=10;
                Main.dx=0;
            }
        });

        botonRegresa.setMinSize(100,100);
        botonRegresa.setLayoutX(450);
        botonRegresa.setLayoutY(20);
        botonRegresa.setOnTouchPressed(new EventHandler<TouchEvent>() {
            @Override
            public void handle(TouchEvent event) {
                Main.setState(Main.StateGame.menu);
                Main.addComponet();
            }
        });

        recoge.setY(400);
        recoge.setX(800);
        recoge.setOnTouchPressed(new EventHandler<TouchEvent>() {
            @Override
            public void handle(TouchEvent event) {
                System.out.println("recoge recoge recoge");
            }
        });

    }

}

