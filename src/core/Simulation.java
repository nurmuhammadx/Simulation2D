package core;

import action.init.InitAction;
import map.Map;
import view.MapConsoleRenderer;

public class Simulation {
    private final static Integer MAP_WIDTH = 17;
    private final static Integer MAP_HEIGHT = 15;
    Map map = new Map(MAP_WIDTH, MAP_HEIGHT);

    public void run(){
        InitAction action = new InitAction(map);
        action.init();
        MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();
        mapConsoleRenderer.render(map);
    }

    public void nextTurn() {

    }
}
