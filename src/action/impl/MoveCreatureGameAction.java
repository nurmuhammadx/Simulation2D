package action.impl;

import action.GameAction;
import action.MoveRequest;
import core.SimulationConfig;
import entity.creature.impl.Herbivore;
import entity.GameEntity;
import entity.environment.Grass;
import map.Coordinates;
import map.SimulationMap;
import pathfinding.IPathfinder;

import java.util.ArrayList;
import java.util.List;

public class MoveCreatureGameAction extends GameAction {
    public List<MoveRequest> moveRequests = new ArrayList<>();
    IPathfinder pathfinder;

    public MoveCreatureGameAction(SimulationConfig simulationConfig, IPathfinder pathfinder) {
        super(simulationConfig);
        this.pathfinder = pathfinder;
    }

    @Override
    public void init(SimulationMap simulationMap) {
        collect(simulationMap);
        update(simulationMap);
    }

    private void collect(SimulationMap simulationMap) {
        moveRequests.clear();
        for (GameEntity entity : simulationMap.getEntities().values()) {
            if (entity instanceof Herbivore herbivore) {
                MoveRequest request = herbivore.getMoveRequest(simulationMap, pathfinder);
                if (request != null) {
                    moveRequests.add(request);
                }
            }
        }
    }

    private void update(SimulationMap simulationMap) {
        for (MoveRequest request : moveRequests) {
            Herbivore herbivore = (Herbivore) request.getEntity();
            Coordinates oldPosition = herbivore.getCoordinates();
            Coordinates newPosition = request.getCoordinates();
            GameEntity targetEntity = simulationMap.getEntity(newPosition);

            if (targetEntity instanceof Grass) {
                simulationMap.removeEntity(newPosition);
                herbivore.reachedTarget();
            }

            simulationMap.removeEntity(oldPosition);
            simulationMap.setEntity(newPosition, herbivore);
        }
        moveRequests.clear();
    }
}
