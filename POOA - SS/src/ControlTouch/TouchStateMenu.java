package ControlTouch;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.TouchEvent;
import sample.Main;


public final class TouchStateMenu extends Touch {



        public static Button botonPlay= new Button("PLAY");
        public static Button botonInstruccion=new Button("Instruccion");
        public static Button botonSalir= new Button("Salir");


        static{

            botonPlay.setLayoutX(440);
            botonPlay.setLayoutY(200);
            botonPlay.setMinSize(100,50);
            botonPlay.setOnTouchPressed(new EventHandler<TouchEvent>() {
                @Override
                public void handle(TouchEvent event) {
                    Main.setState(Main.StateGame.playing);
                    Main.addComponet();
                }
            });

            //Instruccion
            botonInstruccion.setLayoutX(440);
            botonInstruccion.setLayoutY(250);
            botonInstruccion.setMinSize(100,50);
            botonInstruccion.setOnTouchPressed(new EventHandler<TouchEvent>() {
                @Override
                public void handle(TouchEvent event) {
                    System.out.println("No hay instrucccion");
                }
            });

            //Salir
            botonSalir.setLayoutX(440);
            botonSalir.setLayoutY(300);
            botonSalir.setMinSize(100,50);
            botonSalir.setOnTouchPressed(new EventHandler<TouchEvent>() {
                @Override
                public void handle(TouchEvent event) {
                    System.exit(0);
                }
            });



        }

    }
