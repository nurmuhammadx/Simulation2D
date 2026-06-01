package map;

import creature.impl.Herbivore;
import creature.impl.Predator;
import entity.Entity;
import environment.Grass;
import environment.Rock;
import environment.Tree;

import java.util.HashMap;
import java.util.Random;

public class Map {
    private final static Integer DEFAULT_ROCK_QUANTITY = 10;
    private final static Integer DEFAULT_TREE_QUANTITY = 10;

    private final Integer herbivoreQuantity;
    private final Integer predatorQuantity;
    private final Integer mapHeight;
    private final Integer mapWidth;

    private final HashMap<Coordinates, Entity> entities =  new HashMap<>();

    public Map(Integer mapWidth, Integer mapHeight, Integer predatorQuantity, Integer herbivoreQuantity) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.predatorQuantity = predatorQuantity;
        this.herbivoreQuantity = herbivoreQuantity;
    }

    public void setEntity(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        entities.put(coordinates, entity);
    }

    public void setRandomPosition() {
        //Herbivore
        for (int i = 0; i < herbivoreQuantity; i++) {
            int[] position = generateRandomPosition();
            if (isSquareEmpty(new Coordinates(position[0], position[1]))) {
                setEntity(new Coordinates(position[0],position[1]), new Herbivore(new Coordinates(position[0],position[1]), 5, 50));
            }
        }

        //Predator
        for (int i = 0; i < predatorQuantity; i++) {
            int[] position = generateRandomPosition();
            if (isSquareEmpty(new Coordinates(position[0], position[1]))) {
                setEntity(new Coordinates(position[0],position[1]), new Predator(new Coordinates(position[0],position[1]), 10, 100, 40));
            }
        }

        //Grass
        for (int i = 0; i < predatorQuantity; i++) {
            int[] position = generateRandomPosition();
            if (isSquareEmpty(new Coordinates(position[0], position[1]))) {
                setEntity(new Coordinates(position[0], position[1]), new Grass(new Coordinates(position[0], position[1])));
            }
        }

        //Tree
        for (int i = 0; i < DEFAULT_TREE_QUANTITY; i++) {
            int[] position = generateRandomPosition();
            if (isSquareEmpty(new Coordinates(position[0], position[1]))) {
                setEntity(new Coordinates(position[0], position[1]), new Tree(new Coordinates(position[0], position[1])));
            }
        }

        //Rock
        for (int i = 0; i < DEFAULT_ROCK_QUANTITY; i++) {
            int[] position = generateRandomPosition();
            if (isSquareEmpty(new Coordinates(position[0], position[1]))) {
                setEntity(new Coordinates(position[0], position[1]), new Rock(new Coordinates(position[0], position[1])));
            }
        }
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

    public Integer getMAP_HEIGHT() {
        return mapHeight;
    }

    public Integer getMAP_WIDTH() {
        return mapWidth;
    }

    private int[] generateRandomPosition() {
        int[] result = new int[2];
        Random random = new Random();
        result[0] = random.nextInt(mapWidth);
        result[1] = random.nextInt(mapHeight);
        return result;
    }
}
