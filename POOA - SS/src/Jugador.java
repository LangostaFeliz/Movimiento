import javafx.geometry.Pos;
import javafx.scene.image.Image;

public class Jugador extends Entidad {
    /*
    private enum Estado{
        norte,sur,oeste,este,parado
    }*/

    private int dx;
    private int dy;
    private Image[][] sprites;
    private int directionIndex;
    /*
        0 - Arriba izq.
        1 - Arriba
        2 - Arriba der.
        3 - Izquierda.
        4 - Derecha
        5 - Abajo Izq.
        6 - Abajo
        7 - Abajo Der.
    */
    private int animationFrameIndex;
    private int auxiliarCounter;

    public Jugador(int x, int y, int width, int height) {
        super(x, y, width, height);
        //Estado estado=Estado.este;
    }

    public void setMovement(int dx, int dy) {

        this.dx = dx;
        this.dy = dy;

        if(dx > 0) {
            if(dy > 0) {
                this.directionIndex = 7;        //Abajo Der.
            } else if(dy == 0) {
                this.directionIndex = 4;        //Derecha
            } else {
                this.directionIndex = 2;        //Arriba Der.
            }
        } else if(dx < 0) {
            if(dy > 0) {
                this.directionIndex = 5;        //Abajo Izq.
            } else if(dy == 0) {
                this.directionIndex = 3;        //Izquierda
            } else {
                this.directionIndex = 0;        //Arriba Izq.
            }
        } else if(dx == 0) {
            if(dy > 0) {
                this.directionIndex = 6;        //Abajo
            } else if(dy < 0) {
                this.directionIndex = 1;        //Arriba
            } else if(dy == 0) {
                animationFrameIndex = 0;
            }
        }

    }

    public Image[] getImageArray() {
        return sprites[directionIndex];
    }

    public Image getCurrentSprite() {
        return sprites[directionIndex][animationFrameIndex];
    }


}
