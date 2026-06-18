package core;

import action.GameAction;
import action.interaction.MoveCreatureAction;
import action.spawn.*;
import map.SimulationMap;
import view.MapConsoleRenderer;

import java.util.*;

public class Simulation {
    SimulationMap simulationMap;
    MapConsoleRenderer mapConsoleRenderer;
    MoveCreatureAction moveCreatureAction;
    Set<GameAction> gameActions;

    public Simulation(SimulationMap simulationMap, MapConsoleRenderer mapConsoleRenderer,  MoveCreatureAction moveCreatureAction) {
        this.simulationMap = simulationMap;
        this.mapConsoleRenderer = mapConsoleRenderer;
        this.moveCreatureAction = moveCreatureAction;
    }

    public void start(){
        initEntitiesSpawn();
        startSimulation();
    }

    public void nextTurn() {
        moveCreatureAction.execute();
        mapConsoleRenderer.render(simulationMap);

    }

    public void startSimulation() {
        while (!simulationMap.getGrass().isEmpty() && !simulationMap.getHerbivore().isEmpty()) {
            moveCreatureAction.execute();
            mapConsoleRenderer.render(simulationMap);
            System.out.println();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void pauseSimulation() {}

    private void initEntitiesSpawn() {
        gameActions = new HashSet<>(List.of(
                new SpawnGrassGameAction(),
                new SpawnRockGameAction(),
                new SpawnTreeGameAction(),
                new SpawnHerbivoreGameAction(),
                new SpawnPredatorGameAction()
        ));

        for (GameAction gameAction : gameActions) {
            gameAction.init(simulationMap);
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
}
