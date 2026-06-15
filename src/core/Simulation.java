package core;

import action.GameAction;
import action.impl.InteractionAction;
import action.impl.MoveCreatureGameAction;
import action.spawn.*;
import map.SimulationMap;
import pathfinding.IPathfinder;
import view.MapConsoleRenderer;

import java.util.*;

public class Simulation {
    SimulationMap simulationMap;
    MapConsoleRenderer mapConsoleRenderer;
    SimulationConfig simulationConfig =  new SimulationConfig();
    InteractionAction interactionAction = new InteractionAction();
    IPathfinder pathfinder;
    Set<GameAction> gameActions;

    public Simulation(SimulationMap simulationMap, MapConsoleRenderer mapConsoleRenderer,  IPathfinder pathfinder) {
        this.simulationMap = simulationMap;
        this.mapConsoleRenderer = mapConsoleRenderer;
        this.pathfinder = pathfinder;
    }

    public void start(){
        gameActions = new HashSet<>(List.of(
                new SpawnGrassGameAction(simulationConfig),
                new SpawnRockGameAction(simulationConfig),
                new SpawnTreeGameAction(simulationConfig),
                new SpawnHerbivoreGameAction(simulationConfig),
                new SpawnPredatorGameAction(simulationConfig)
        ));

        for (GameAction gameAction : gameActions) {
            gameAction.init(simulationMap);
        }

        startSimulation();
    }

    //просимулировать и отрендерить один ход
    public void nextTurn() {
        MoveCreatureGameAction move = new MoveCreatureGameAction(simulationConfig, pathfinder, interactionAction);
        move.init(simulationMap);
        mapConsoleRenderer.render(simulationMap, simulationConfig);

    }

    //запустить бесконечный цикл симуляции и рендеринга
    public void startSimulation() {
        MoveCreatureGameAction move = new MoveCreatureGameAction(simulationConfig, pathfinder,  interactionAction);

        while (!simulationMap.getGrass().isEmpty() || !simulationMap.getHerbivore().isEmpty()) {
            move.init(simulationMap);
            mapConsoleRenderer.render(simulationMap, simulationConfig);
            System.out.println();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls")
                    .inheritIO()
                    .start()
                    .waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //приостановить бесконечный цикл симуляции и рендеринга
    public void pauseSimulation() {}
}
