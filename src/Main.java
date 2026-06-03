import core.Simulation;
import map.Map;
import view.MapConsoleRenderer;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();

        Simulation simulation = new Simulation(map, mapConsoleRenderer);
        simulation.run();
    }
}