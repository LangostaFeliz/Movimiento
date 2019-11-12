import javafx.scene.image.Image;

public abstract class EntidadVisual extends Entidad {

    private String spriteSheetURL;
    private Image currentSprite;

    public EntidadVisual(int x, int y, int width, int height, String url) {
        super(x, y, width, height);

        this.spriteSheetURL = url;
    }

    protected abstract void ripSprites(String url);

    public Image getCurrentSprite() {
        return currentSprite;
    }

    public static class Controller {
    }
}
