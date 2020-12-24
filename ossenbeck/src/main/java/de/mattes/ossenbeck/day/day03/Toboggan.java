package de.mattes.ossenbeck.day.day03;

public class Toboggan {
    private int x;
    private int y;

    public void move(Coordinate direction) {
        x += direction.x();
        y += direction.y();
    }

    public Coordinate getPosition() {
        return new Coordinate(x, y);
    }
}