package action.spawn;

import action.GameAction;
import core.SimulationConfig;
import entity.environment.Grass;
import map.Coordinates;
import map.SimulationMap;

public class SpawnGrassGameAction extends GameAction {

    public SpawnGrassGameAction(SimulationConfig simulationConfig) {
        super(simulationConfig);
    }

    @Override
    public void init(SimulationMap simulationMap) {
        for (int i = 0; i < simulationConfig.getGrassCount(); i++) {
            int[] position = generateRandomPosition();
            if (simulationMap.isSquareEmpty(new Coordinates(position[0], position[1]))) {
                simulationMap.setEntity(new Coordinates(position[0], position[1]), new Grass(new Coordinates(position[0], position[1])));
            }
        }
    }
}
