package map;

import entity.GameEntity;
import entity.environment.Grass;

import java.util.*;

public class SimulationMap {
    private final HashMap<Coordinates, GameEntity> entities =  new HashMap<>();

    public SimulationMap() {}

    public void setEntity(Coordinates coordinates, GameEntity gameEntity) {
        gameEntity.setCoordinates(coordinates);
        entities.put(coordinates, gameEntity);
    }

    public void removeEntity(Coordinates coordinates) {
        entities.remove(coordinates);
    }

    public GameEntity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public HashMap<Coordinates, GameEntity> getEntities() {
        return entities;
    }

    public List<Grass> getGrass() {
        List<Grass> grassSet = new ArrayList<>();
        for (GameEntity gameEntity : entities.values()) {
            if (gameEntity instanceof Grass grass) {
                grassSet.add(grass);
            }
        }
        return grassSet;
    }

    public static boolean isSquareOrange(Coordinates coordinates) {
        return (coordinates.getPositionX() + coordinates.getPositionY()) % 2 == 0;
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }
}
