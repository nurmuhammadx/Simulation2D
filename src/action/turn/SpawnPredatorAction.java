package action.turn;

import action.Action;
import core.SimulationConfig;
import creature.impl.Predator;
import map.Coordinates;
import map.Map;

public class SpawnPredatorAction extends Action {

    public SpawnPredatorAction(Map map, SimulationConfig simulationConfig) {
        super(map, simulationConfig);
    }

    @Override
    public void init() {
        spawnPredator();
    }

    public void spawnPredator() {
        for (int i = 0; i < simulationConfig.getPredatorCount(); i++) {
            int[] position = generateRandomPosition();
            if (map.isSquareEmpty(new Coordinates(position[0], position[1]))) {
                map.setEntity(new Coordinates(position[0],position[1]), new Predator(new Coordinates(position[0],position[1]), 10, 100, 40));
            }
        }
    }
}
