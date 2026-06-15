package entity.environment;

import entity.GameEntity;
import map.Coordinates;

public class Grass extends GameEntity {
    public Grass(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public boolean isWalkable() {
        return true;
    }
}
