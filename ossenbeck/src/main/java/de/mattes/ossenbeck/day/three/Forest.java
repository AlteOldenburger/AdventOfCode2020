package de.mattes.ossenbeck.day.three;

import java.util.List;

public class Forest {
    private static final char TREE = '#';

    private final List<String> map;

    public Forest(List<String> map) {
        this.map = map;
    }

    public int getWidth() {
        return map.get(0).length();
    }

    public int getHeight() {
        return map.size();
    }

    public boolean isTreeAt(Coordinate coordinate) {
        if(coordinate.y() >= getHeight()) {
            return false;
        }

        return map.get(coordinate.y()).charAt(coordinate.x() % getWidth()) == TREE;
    }
}