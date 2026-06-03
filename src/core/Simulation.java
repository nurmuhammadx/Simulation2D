package core;

import action.Action;
import action.turn.*;
import map.Map;
import view.MapConsoleRenderer;

import java.util.*;

public class Simulation {
    Map map;
    MapConsoleRenderer mapConsoleRenderer;
    SimulationConfig simulationConfig =  new SimulationConfig();
    Set<Action> actions;

    public Simulation(Map map, MapConsoleRenderer mapConsoleRenderer) {
        this.map = map;
        this.mapConsoleRenderer = mapConsoleRenderer;
    }

    public void run(){
        actions = new HashSet<>(List.of(
                new SpawnGrassAction(map,  simulationConfig),
                new SpawnRockAction(map, simulationConfig),
                new SpawnTreeAction(map, simulationConfig),
                new SpawnHerbivoreAction(map, simulationConfig),
                new SpawnPredatorAction(map, simulationConfig)
        ));

        for (Action action : actions) {
            action.init();
        }
        mapConsoleRenderer.render(map, simulationConfig);
    }

    public void nextTurn() {

    }
}
