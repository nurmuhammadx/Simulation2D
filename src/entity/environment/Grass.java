package entity.environment;

import entity.GameEntity;
import map.Coordinates;

public class Grass extends GameEntity {

    public Grass() {}

    @Override
    public boolean isWalkable() {
        return true;
    }
}
