package action.turn;

import action.Action;
import core.SimulationConfig;
import environment.Tree;
import map.Coordinates;
import map.Map;

public class SpawnTreeAction extends Action {

    public SpawnTreeAction(Map map, SimulationConfig simulationConfig) {
        super(map, simulationConfig);
    }

    @Override
    public void init() {
        spawnTree();
    }

    public void spawnTree() {
        for (int i = 0; i < simulationConfig.getTreeCount(); i++) {
            int[] position = generateRandomPosition();
            if (map.isSquareEmpty(new Coordinates(position[0], position[1]))) {
                map.setEntity(new Coordinates(position[0], position[1]), new Tree(new Coordinates(position[0], position[1])));
            }
        }
    }
}
