package action;

import core.SimulationConfig;
import map.SimulationMap;

import java.util.Random;

public abstract class GameAction {
    protected final SimulationConfig simulationConfig;

    public GameAction(SimulationConfig simulationConfig) {
        this.simulationConfig = simulationConfig;
    }

    public abstract void init(SimulationMap simulationMap);

    protected int[] generateRandomPosition() {
        int[] result = new int[2];
        Random random = new Random();
        result[0] = random.nextInt(simulationConfig.getMapWidth());
        result[1] = random.nextInt(simulationConfig.getMapHeight());
        return result;
    }
}
