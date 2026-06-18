import core.Simulation;
import core.SimulationConfig;
import map.SimulationMap;
import pathfinding.IPathfinder;
import pathfinding.impl.BfsPathFinder;
import view.MapConsoleRenderer;

public class Main {
    public static void main(String[] args) {
        SimulationMap simulationMap = new SimulationMap();
        MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();
        IPathfinder pathfinder = new BfsPathFinder(new SimulationConfig());

        Simulation simulation = new Simulation(simulationMap, mapConsoleRenderer,  pathfinder);
        simulation.start();
    }
}