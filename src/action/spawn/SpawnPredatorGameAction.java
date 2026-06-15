package action.spawn;

import action.GameAction;
import core.SimulationConfig;
import entity.creature.impl.Predator;
import map.Coordinates;
import map.SimulationMap;

public class SpawnPredatorGameAction extends GameAction {

    public SpawnPredatorGameAction(SimulationConfig simulationConfig) {
        super(simulationConfig);
    }

    @Override
    public void init(SimulationMap simulationMap) {
        int spawned = 0;
        while (spawned < simulationConfig.getPredatorCount()) {
            int[] position = generateRandomPosition();
            Coordinates coordinates = new Coordinates(position[0], position[1]);
            if (simulationMap.isSquareEmpty(coordinates)) {
                simulationMap.setEntity(coordinates, new Predator(coordinates, 10, 100, 40));
                spawned++;
            }
        }
    }
}
