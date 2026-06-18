package action.interaction;

import entity.creature.Creature;
import entity.GameEntity;
import map.Coordinates;
import map.SimulationMap;
import pathfinding.IPathfinder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MoveCreatureAction {
    private final List<MoveRequest> moveRequests = new ArrayList<>();
    SimulationMap simulationMap;
    private final IPathfinder pathfinder;
    private final InteractionAction interactionAction;

    public MoveCreatureAction(IPathfinder pathfinder, InteractionAction interactionAction, SimulationMap simulationMap) {
        this.pathfinder = pathfinder;
        this.interactionAction = interactionAction;
        this.simulationMap = simulationMap;
    }

    public void execute() {
        collect();
        List<MoveRequest> approved = resolveConflicts();
        interactionAction.interact(simulationMap, approved);
        update(approved);
    }

    private void collect() {
        moveRequests.clear();
        for (GameEntity entity : simulationMap.getEntities().values()) {
            if (entity instanceof Creature creature) {
                MoveRequest request = creature.getMoveRequest(simulationMap, pathfinder);
                if (request != null) {
                    moveRequests.add(request);
                }
            }
        }
    }

    private void update(List<MoveRequest> approved) {
        removeOldPositions(approved);
        placeNewPositions(approved);
        moveRequests.clear();
    }

    private List<MoveRequest> resolveConflicts() {
        List<MoveRequest> approved = new ArrayList<>();
        Set<Coordinates> occupied = new HashSet<>();
        for (MoveRequest request : moveRequests) {
            if (occupied.contains(request.getTo())) {
                continue;
            }
            occupied.add(request.getTo());
            approved.add(request);
        }

        return approved;
    }

    private void placeNewPositions(List<MoveRequest> approved) {
        for (MoveRequest request : approved) {
            Coordinates newPosition = request.getTo();
            Creature creature = request.getCreature();
            if (creature.isDead()) {
                continue;
            }
            simulationMap.putEntity(newPosition, creature);
        }
    }

    private void removeOldPositions(List<MoveRequest> approved) {
        for (MoveRequest request : approved) {
            simulationMap.removeEntity(request.getFrom());
        }
    }
}
