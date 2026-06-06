package core;

import action.GameAction;
import action.impl.MoveCreatureGameAction;
import action.spawn.*;
import map.SimulationMap;
import view.MapConsoleRenderer;

import java.util.*;

public class Simulation {
    SimulationMap simulationMap;
    MapConsoleRenderer mapConsoleRenderer;
    SimulationConfig simulationConfig =  new SimulationConfig();
    Set<GameAction> gameActions;

    public Simulation(SimulationMap simulationMap, MapConsoleRenderer mapConsoleRenderer) {
        this.simulationMap = simulationMap;
        this.mapConsoleRenderer = mapConsoleRenderer;
    }

    public void run(){
//        actions = new HashSet<>(List.of(
//                new SpawnGrassAction(simulationConfig),
//                new SpawnRockAction(simulationConfig),
//                new SpawnTreeAction(simulationConfig),
//                new SpawnHerbivoreAction(simulationConfig),
//                new SpawnPredatorAction(simulationConfig)
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
        MoveCreatureGameAction move = new MoveCreatureGameAction(simulationConfig);
        move.init(simulationMap);
        mapConsoleRenderer.render(simulationMap, simulationConfig);

    }

    //запустить бесконечный цикл симуляции и рендеринга
    public void startSimulation() {
        MoveCreatureGameAction move = new MoveCreatureGameAction(simulationConfig);

        while (move.moveRequests.isEmpty()) {
            move.init(simulationMap);
            mapConsoleRenderer.render(simulationMap, simulationConfig);
            System.out.println();
        }
    }

    //приостановить бесконечный цикл симуляции и рендеринга
    public void pauseSimulation() {}
}
