package action.init;

import action.Action;
import creature.impl.Herbivore;
import creature.impl.Predator;
import environment.Grass;
import environment.Rock;
import environment.Tree;
import map.Coordinates;
import map.Map;

import java.util.Random;

public class InitAction implements Action {
    private final static Integer HERBIVORE_QUANTITY = 1;
    private final static Integer PREDATOR_QUANTITY = 1;
    private final static Integer DEFAULT_ROCK_QUANTITY = 10;
    private final static Integer DEFAULT_TREE_QUANTITY = 10;
    private final static Integer DEFAULT_GRASS_QUANTITY = 10;

    Map map;

    public InitAction(Map map) {
        this.map = map;
    }

    public void init(){
        setEntityRandomPosition();
    }

    public void setEntityRandomPosition() {
        //Herbivore
        for (int i = 0; i < HERBIVORE_QUANTITY; i++) {
            int[] position = generateRandomPosition();
            if (map.isSquareEmpty(new Coordinates(position[0], position[1]))) {
                map.setEntity(new Coordinates(position[0],position[1]), new Herbivore(new Coordinates(position[0],position[1]), 5, 50));
            }
        }

        //Predator
        for (int i = 0; i < PREDATOR_QUANTITY; i++) {
            int[] position = generateRandomPosition();
            if (map.isSquareEmpty(new Coordinates(position[0], position[1]))) {
                map.setEntity(new Coordinates(position[0],position[1]), new Predator(new Coordinates(position[0],position[1]), 10, 100, 40));
            }
        }

        //Grass
        for (int i = 0; i < DEFAULT_GRASS_QUANTITY; i++) {
            int[] position = generateRandomPosition();
            if (map.isSquareEmpty(new Coordinates(position[0], position[1]))) {
                map.setEntity(new Coordinates(position[0], position[1]), new Grass(new Coordinates(position[0], position[1])));
            }
        }

        //Tree
        for (int i = 0; i < DEFAULT_TREE_QUANTITY; i++) {
            int[] position = generateRandomPosition();
            if (map.isSquareEmpty(new Coordinates(position[0], position[1]))) {
                map.setEntity(new Coordinates(position[0], position[1]), new Tree(new Coordinates(position[0], position[1])));
            }
        }

        //Rock
        for (int i = 0; i < DEFAULT_ROCK_QUANTITY; i++) {
            int[] position = generateRandomPosition();
            if (map.isSquareEmpty(new Coordinates(position[0], position[1]))) {
                map.setEntity(new Coordinates(position[0], position[1]), new Rock(new Coordinates(position[0], position[1])));
            }
        }
    }

    private int[] generateRandomPosition() {
        int[] result = new int[2];
        Random random = new Random();
        result[0] = random.nextInt(map.getWidth());
        result[1] = random.nextInt(map.getHeight());
        return result;
    }
}
