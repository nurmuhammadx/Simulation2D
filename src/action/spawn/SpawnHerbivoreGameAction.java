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
        for (int i = 0; i < simulationConfig.getHerbivoreCount(); i++) {
            int[] position = generateRandomPosition();
            if (simulationMap.isSquareEmpty(new Coordinates(position[0], position[1]))) {
                simulationMap.setEntity(new Coordinates(position[0],position[1]), new Herbivore(new Coordinates(position[0],position[1]), 5, 50));
            }
        }
    }
}
