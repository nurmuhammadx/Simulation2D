import action.interaction.InteractionAction;
import action.interaction.MoveCreatureAction;
import core.Simulation;
import map.SimulationMap;
import pathfinding.IPathfinder;
import pathfinding.impl.BfsPathFinder;
import view.MapConsoleRenderer;

public class Main {
    public static void main(String[] args) {
        SimulationMap simulationMap = new SimulationMap();
        MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();
        IPathfinder pathfinder = new BfsPathFinder();
        InteractionAction interactionAction = new InteractionAction();
        MoveCreatureAction moveCreatureAction = new MoveCreatureAction(pathfinder,  interactionAction,  simulationMap);

        Simulation simulation = new Simulation(simulationMap, mapConsoleRenderer,  moveCreatureAction);
        simulation.start();
    }
}