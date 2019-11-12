import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Entidad {

    private double x;
    private double y;
    private double width;
    private double height;
    private double HitboxX;
    private double HitboxY;
    private double HitboxWidth;
    private double HitboxHeight;

    public Entidad (int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.HitboxX = x;
        this.HitboxY = y + height/2;
        this.HitboxWidth = width;
        this.HitboxHeight = height/2;

    }

}
