import core.Simulation;
import core.SimulationConfig;
import map.Coordinates;
import map.SimulationMap;
import pathfinding.impl.BfsPathFinder;
import view.MapConsoleRenderer;

public class Main {
    public static void main(String[] args) {
        SimulationMap simulationMap = new SimulationMap();
        MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();

        Simulation simulation = new Simulation(simulationMap, mapConsoleRenderer);
        simulation.run();


//        BfsPathFinder bfsPathFinder = new BfsPathFinder();
//        bfsPathFinder.findPath(new Coordinates(0, 0), new Coordinates(1,5), new SimulationConfig()).forEach(System.out::println);



    }
}