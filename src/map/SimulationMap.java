package map;

import entity.GameEntity;
import entity.creature.impl.Herbivore;
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

    public LinkedList<Coordinates> getGrass() {
        LinkedList<Coordinates> grassSet = new LinkedList<>();
        for (GameEntity gameEntity : entities.values()) {
            if (gameEntity instanceof Grass) {
                grassSet.add(gameEntity.getCoordinates());
            }
        }
        return grassSet;
    }

    public LinkedList<Coordinates> getHerbivore() {
        LinkedList<Coordinates> herbivoreSet = new LinkedList<>();
        for (GameEntity gameEntity : entities.values()) {
            if (gameEntity instanceof Herbivore) {
                herbivoreSet.add(gameEntity.getCoordinates());
            }
        }
        return herbivoreSet;
    }

    public static boolean isSquareOrange(Coordinates coordinates) {
        return (coordinates.getPositionX() + coordinates.getPositionY()) % 2 == 0;
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }
}
