package action;

import core.SimulationConfig;
import map.Map;

import java.util.Random;

public abstract class Action {
    public Map map;
    public SimulationConfig simulationConfig;

    public Action(Map map,  SimulationConfig simulationConfig) {
        this.map = map;
        this.simulationConfig = simulationConfig;
    }

    public abstract void init();

    public int[] generateRandomPosition() {
        int[] result = new int[2];
        Random random = new Random();
        result[0] = random.nextInt(simulationConfig.getMapWidth());
        result[1] = random.nextInt(simulationConfig.getMapHeight());
        return result;
    }
}
