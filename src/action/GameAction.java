package action;

import core.SimulationConfig;
import map.SimulationMap;

import java.util.Random;

public abstract class GameAction {

    public GameAction() {}

    public abstract void init(SimulationMap simulationMap);

    protected int[] generateRandomPosition() {
        int[] result = new int[2];
        Random random = new Random();
        result[0] = random.nextInt(SimulationConfig.MAP_WIDTH);
        result[1] = random.nextInt(SimulationConfig.MAP_HEIGHT);
        return result;
    }
}
