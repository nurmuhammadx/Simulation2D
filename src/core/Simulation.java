package core;

import action.GameAction;
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
    IPathfinder pathfinder;
    Set<GameAction> gameActions;

    public Simulation(SimulationMap simulationMap, MapConsoleRenderer mapConsoleRenderer,  IPathfinder pathfinder) {
        this.simulationMap = simulationMap;
        this.mapConsoleRenderer = mapConsoleRenderer;
        this.pathfinder = pathfinder;
    }

    public void run(){
//        gameActions = new HashSet<>(List.of(
//                new SpawnGrassGameAction(simulationConfig),
//                new SpawnRockGameAction(simulationConfig),
//                new SpawnTreeGameAction(simulationConfig),
//                new SpawnHerbivoreGameAction(simulationConfig),
//                new SpawnPredatorGameAction(simulationConfig)
//        ));
        gameActions = new HashSet<>(List.of(
                new SpawnGrassGameAction(simulationConfig),
                new SpawnHerbivoreGameAction(simulationConfig)
        ));

        for (GameAction gameAction : gameActions) {
            gameAction.init(simulationMap);
        }
//        mapConsoleRenderer.render(simulationMap, simulationConfig);
//        System.out.println();
//        nextTurn();
//        System.out.println();
//        nextTurn();
        startSimulation();
    }

    //просимулировать и отрендерить один ход
    public void nextTurn() {
        MoveCreatureGameAction move = new MoveCreatureGameAction(simulationConfig, pathfinder);
        move.init(simulationMap);
        mapConsoleRenderer.render(simulationMap, simulationConfig);

    }

    //запустить бесконечный цикл симуляции и рендеринга
    public void startSimulation() {
        MoveCreatureGameAction move = new MoveCreatureGameAction(simulationConfig, pathfinder);
//        EatGrassAction eatGrassAction = new EatGrassAction(simulationMap.getGrass());

        while (!simulationMap.getGrass().isEmpty()) {
            move.init(simulationMap);

            clearScreen();

            mapConsoleRenderer.render(simulationMap, simulationConfig);

            try {
                Thread.sleep(300);
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
