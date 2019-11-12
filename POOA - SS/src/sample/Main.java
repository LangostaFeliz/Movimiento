package sample;

import ControlTouch.TouchStateMenu;
import ControlTouch.TouchStatePlaying;
import Display.AnimatedImage;
import People.Player;
import People.StatePlayer;
import com.sun.org.apache.xpath.internal.objects.XObject;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.TouchEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.lang.reflect.Array;

public class Main extends Application {


    public enum StateGame{
     menu,playing,gameOver,selecion;
    }

    static StateGame state;
    public static StateGame getState() {
        return state;
    }

    public static void setState(StateGame state) {
        Main.state = state;
    }
    public static Player jugador= new Player(100,100,40,40);
    public static Group root = new Group();
    static Canvas canvas= new Canvas(1024,400);
    static Rectangle objeto=new Rectangle(50,50);
    public static double x;
    public static double y;
    public static double dx=0;
    public static double dy=0;
    Image paradoAbajo = new Image("file:src//SpritePrueba//persona1.png");
    Image paradoIzquierda = new Image("file:src//SpritePrueba//persona5.png");
    Image paradoDerecho = new Image("file:src//SpritePrueba//persona9.png");
    Image paradoArriba = new Image("file:src//SpritePrueba//persona13.png");
    AnimatedImage caminaArriba= new AnimatedImage();
    AnimatedImage caminaIzquierda=new AnimatedImage();
    AnimatedImage caminaAbajo= new AnimatedImage();
    AnimatedImage caminaderecho= new AnimatedImage();


    // el metodo init se ejecutar antes que el metodo star , cuyo
    //objeto de es cargar los recursos de componenetes
    @Override
    public void init() throws Exception{
        state=StateGame.playing;
        iniDisplayObjeto();
        addComponet();

    }




    @Override
    public void start(Stage primaryStage) throws Exception{


        primaryStage.setTitle("Hello World");

        primaryStage.setScene(new Scene(root));
       // root.getChildren().add(canvas);
        //  primaryStage.setFullScreen(true);
        System.out.println("Posicion Y:");
        addComponet();

        final long starNanoTime=System.nanoTime();
        GraphicsContext gc =canvas.getGraphicsContext2D();



       // root.getChildren().add(node.get(2));
        new AnimationTimer() {
            int i;
            @Override
            public void handle(long now) {
                double t =(now-starNanoTime)/1000000000.0;




                    gameLogic();
                    gameGraphics(gc,t);



            }
        }.start();
        primaryStage.show();
    }

    public  static void addComponet()
    {   //limpiar los todo los nodos de scenarios
        root.getChildren().clear();
        root.getChildren().add(canvas);
        if(state==StateGame.menu)
        {

            root.getChildren().add(TouchStateMenu.botonPlay);
            root.getChildren().add(TouchStateMenu.botonInstruccion);
            root.getChildren().add(TouchStateMenu.botonSalir);

        }
        if(state==StateGame.playing)
        {   root.getChildren().add(objeto);
            root.getChildren().add(TouchStatePlaying.recoge);
            root.getChildren().addAll(TouchStatePlaying.dash);
            root.getChildren().add(TouchStatePlaying.dpad);
            root.getChildren().add(TouchStatePlaying.botonRegresa);

        }
    }


    //prueba de movimiento touch
    public void move()
    {

        objeto.setX(objeto.getX()+dx);
        objeto.setY(objeto.getY()+dy);
    }
    //actualizacion de la logica
    public void gameLogic()
    {
        jugador.move();
    }
    //actualizacion de la grafica
    public void gameGraphics(GraphicsContext gc, double t) {
        gc.clearRect(0,0,1024,500);
        if(state==StateGame.playing)
        {
       /*    if(jugador.state==StatePlayer.Parato)
           {
               gc.drawImage(paradoAbajo,jugador.getX(),jugador.getY(),jugador.getWidth(),jugador.getHeight());
           }*/
        //   else
            if (jugador.state==StatePlayer.abajo) {
               if(dy!=0)gc.drawImage(caminaAbajo.getFrame(t),jugador.getX(),jugador.getY(),jugador.getWidth(),jugador.getHeight());
               else gc.drawImage(paradoAbajo,jugador.getX(),jugador.getY(),jugador.getWidth(),jugador.getHeight());
            }
           else if(jugador.state==StatePlayer.arriba)
           {
                if (dy!=0)  gc.drawImage(caminaArriba.getFrame(t),jugador.getX(),jugador.getY(),jugador.getWidth(),jugador.getHeight());
                else gc.drawImage(paradoArriba,jugador.getX(),jugador.getY(),jugador.getWidth(),jugador.getHeight());
           }
           else if(jugador.state==StatePlayer.derecha)
           {
               if (dx!=0)gc.drawImage(caminaderecho.getFrame(t),jugador.getX(),jugador.getY(),jugador.getWidth(),jugador.getHeight());
                else gc.drawImage(paradoDerecho,jugador.getX(),jugador.getY(),jugador.getWidth(),jugador.getHeight());
           }
           else if(jugador.state==StatePlayer.izquierda)
           {
               if(dx!=0)gc.drawImage(caminaIzquierda.getFrame(t),jugador.getX(),jugador.getY(),jugador.getWidth(),jugador.getHeight());
                gc.drawImage(paradoIzquierda,jugador.getX(),jugador.getY(),jugador.getWidth(),jugador.getHeight());
           }

        }


    }

    void iniDisplayObjeto()
    {   double duracion=0.2;
        Image[][] arrayImage= new Image[4][4];
        for(int i=0;i<4;i++)
            {
                arrayImage[0][i]= new Image("file:src//SpritePrueba//persona"+(i+1)+".png");
                arrayImage[1][i]= new Image("file:src//SpritePrueba//persona"+(i+5)+".png");
                arrayImage[2][i]= new Image("file:src//SpritePrueba//persona"+(i+9)+".png");
                arrayImage[3][i]= new Image("file:src//SpritePrueba//persona"+(i+13)+".png");
            }
        caminaAbajo.frames=arrayImage[0];
        caminaIzquierda.frames=arrayImage[1];
        caminaderecho.frames=arrayImage[2];
        caminaArriba.frames=arrayImage[3];
        caminaIzquierda.duration=duracion;
        caminaderecho.duration=duracion;
        caminaArriba.duration=duracion;
        caminaAbajo.duration=duracion;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
