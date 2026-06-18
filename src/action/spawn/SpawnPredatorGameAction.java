package action.spawn;

import action.GameAction;
import core.SimulationConfig;
import entity.creature.impl.Predator;
import map.Coordinates;
import map.SimulationMap;

public class SpawnPredatorGameAction extends GameAction {

    public SpawnPredatorGameAction() {}

    @Override
    public void init(SimulationMap simulationMap) {
        int spawned = 0;
        while (spawned < SimulationConfig.PREDATOR_COUNT) {
            int[] position = generateRandomPosition();
            Coordinates coordinates = new Coordinates(position[0], position[1]);
            if (simulationMap.isSquareEmpty(coordinates)) {
                simulationMap.putEntity(coordinates, new Predator(2, 100, 10));
                spawned++;
            }
        }
    }
}
