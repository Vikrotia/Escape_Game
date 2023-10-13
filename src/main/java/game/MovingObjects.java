package game;

public interface MovingObjects {
    void setX(int newX);
    void setY(int newY);
    void appendX(int newX);
    void appendY(int newY);
    int getX();
    int getY();
}
