package Display;

import javafx.scene.image.Image;

public final class RecursoSprite {

    public static Image paradoAbajo = new Image("file:src//SpritePrueba//persona1.png");
    public static Image paradoIzquierda = new Image("file:src//SpritePrueba//persona5.png");
    public static Image paradoDerecho = new Image("file:src//SpritePrueba//persona9.png");
    public static Image paradoArriba = new Image("file:src//SpritePrueba//persona13.png");
    public static AnimatedImage caminaArriba;
    public static AnimatedImage caminaIzquierda;
    public static AnimatedImage caminaAbajo;
    public static AnimatedImage caminaderecho;
        static {
            double duracion=0.2;
        Image[][] arrayImage = new Image[4][4];
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

}
