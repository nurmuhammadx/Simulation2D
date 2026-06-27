import action.interaction.InteractionAction;
import action.interaction.MoveCreatureAction;
import core.Simulation;
import map.SimulationMap;
import pathfinding.IPathfinder;
import pathfinding.impl.BfsPathFinder;
import threads.SimulationRunner;
import view.ConsoleView;
import view.MapConsoleRenderer;

public class Main {
    public static void main(String[] args) {
        SimulationMap simulationMap = new SimulationMap();
        MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();
        IPathfinder pathfinder = new BfsPathFinder();
        InteractionAction interactionAction = new InteractionAction();
        MoveCreatureAction moveCreatureAction = new MoveCreatureAction(pathfinder, simulationMap);


        Simulation simulation = new Simulation(simulationMap, mapConsoleRenderer,  moveCreatureAction, interactionAction);
        simulation.init();

        SimulationRunner runner = new SimulationRunner(simulation);

        ConsoleView input = new ConsoleView(runner);
        input.launch();


    }
}