package core;

import map.Map;
import view.MapConsoleRenderer;

public class Simulation {
    private final Integer MAP_WIDTH = 17;
    private final Integer MAP_HEIGHT = 15;
    private final Integer HERBIVORE_QUANTITY = 1;
    private final Integer PREDATOR_QUANTITY = 1;

    public void run(){
        Map map = new Map(MAP_WIDTH,  MAP_HEIGHT, PREDATOR_QUANTITY, HERBIVORE_QUANTITY);
        map.setDefPos();

        MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();
        mapConsoleRenderer.render(map);
    }
}
