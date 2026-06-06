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
        for (int i = 0; i < simulationConfig.getPredatorCount(); i++) {
            int[] position = generateRandomPosition();
            if (simulationMap.isSquareEmpty(new Coordinates(position[0], position[1]))) {
                simulationMap.setEntity(new Coordinates(position[0],position[1]), new Predator(new Coordinates(position[0],position[1]), 10, 100, 40));
            }
        }
    }
}
