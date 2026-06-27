package action.spawn;

import action.GameAction;
import core.SimulationConfig;
import entity.creature.impl.Herbivore;
import map.Coordinates;
import map.SimulationMap;

public class SpawnHerbivoreGameAction extends GameAction {

    public SpawnHerbivoreGameAction() {}

    @Override
    public void init(SimulationMap simulationMap) {
        int spawned = 0;
        while (spawned < SimulationConfig.HERBIVORE_COUNT) {
            int[] position = generateRandomPosition();
            Coordinates coordinates = new Coordinates(position[0], position[1]);
            if (simulationMap.isSquareEmpty(coordinates)) {
                simulationMap.putEntity(coordinates, new Herbivore(SimulationConfig.HERBIVORE_SPEED, SimulationConfig.HERBIVORE_HEALTH));
                spawned++;
            }
        }
    }
}
