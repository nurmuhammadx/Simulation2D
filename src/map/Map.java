package map;

import entity.Entity;

import java.util.HashMap;

public class Map {
    private final HashMap<Coordinates, Entity> entities =  new HashMap<>();

    public Map() {
    }

    public void setEntity(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        entities.put(coordinates, entity);
    }

    public static boolean isSquareOrange(Coordinates coordinates) {
        return (coordinates.getPositionX() + coordinates.getPositionY()) % 2 == 0;
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }
}
