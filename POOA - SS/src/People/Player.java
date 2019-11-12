package People;

import Entidades.MovingIsoEntity;
import sample.Main;

public class Player extends MovingIsoEntity {
    private static int vida=3;
    public StatePlayer state;


    public Player(double x, double y, double width, double height) {
        super(x, y, width, height);
        state=StatePlayer.abajo;
    }


    public StatePlayer getState() {
        return state;
    }

    public void setState(StatePlayer state) {
        this.state = state;
    }

    @Override
    public void move() {
        setX(getX()+ Main.dx);
        setY(getY()+Main.dy);
    }
}
