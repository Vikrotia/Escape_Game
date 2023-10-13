package game;

public class Player implements MovingObjects {
    private int x;
    private int y;

    public Player(int newX, int newY){
        x = newX;
        y = newY;
    }

    @Override
    public void setX(int newX) {
        x = newX;
    }

    @Override
    public void setY(int newY) {
        y = newY;
    }

    @Override
    public void appendX(int newX) {
        x += newX;
    }

    @Override
    public void appendY(int newY) {
        y += newY;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
