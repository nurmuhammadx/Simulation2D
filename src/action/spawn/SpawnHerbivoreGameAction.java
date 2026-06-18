package action.spawn;

import action.GameAction;
import core.SimulationConfig;
import entity.creature.impl.Herbivore;
import map.Coordinates;
import map.SimulationMap;

public class SpawnHerbivoreGameAction extends GameAction {

    public SpawnHerbivoreGameAction(SimulationConfig simulationConfig) {
        super(simulationConfig);
    }

    @Override
    public void init(SimulationMap simulationMap) {
        int spawned = 0;
        while (spawned < simulationConfig.getHerbivoreCount()) {
            int[] position = generateRandomPosition();
            Coordinates coordinates = new Coordinates(position[0], position[1]);
            if (simulationMap.isSquareEmpty(coordinates)) {
                simulationMap.setEntity(coordinates, new Herbivore(coordinates, 2, 100));
                spawned++;
            }
        }
    }
}
