package entity;

import map.Coordinates;

public abstract class GameEntity {
    protected Coordinates coordinates;

    public GameEntity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
