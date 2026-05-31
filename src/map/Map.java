package map;

import creature.impl.Herbivore;
import creature.impl.Predator;
import entity.Entity;
import environment.Grass;
import environment.Rock;
import environment.Tree;

import java.util.HashMap;

public class Map {
    private final Integer MAP_WIDTH;
    private final Integer MAP_HEIGHT;

    HashMap<Coordinates, Entity> entities =  new HashMap<>();

    public Map(Integer mapWidth, Integer mapHeight) {
        MAP_WIDTH = mapWidth;
        MAP_HEIGHT = mapHeight;
    }

    public void setEntity(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        entities.put(coordinates, entity);
    }
    public static boolean isSquareGreen(Coordinates coordinates) {
        return (coordinates.getPositionX() + coordinates.getPositionY()) % 2 == 0;
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }

    public void setDefPos() {
        setEntity(new Coordinates(0,0), new Rock(new Coordinates(0,0)));
        setEntity(new Coordinates(3,5), new Grass(new Coordinates(3,5)));
        setEntity(new Coordinates(7,3), new Tree(new Coordinates(7,3)));
        setEntity(new Coordinates(8,3), new Herbivore(new Coordinates(8,3), 5, 50));
        setEntity(new Coordinates(4,3), new Predator(new Coordinates(4,3), 10, 100, 40));
    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public Integer getMAP_HEIGHT() {
        return MAP_HEIGHT;
    }

    public Integer getMAP_WIDTH() {
        return MAP_WIDTH;
    }
}
