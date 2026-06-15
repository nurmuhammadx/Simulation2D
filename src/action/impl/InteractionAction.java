package action.impl;

import entity.GameEntity;
import entity.creature.Creature;
import map.SimulationMap;

import java.util.List;

public class InteractionAction {

    public InteractionAction() {}

    public void interact(SimulationMap simulationMap, List<MoveRequest> moveRequests) {
        for (MoveRequest request : moveRequests) {
            Creature creature = request.getCreature();
            GameEntity target = request.getTarget();

            if (target != null && creature.canEat(target)) {
                simulationMap.removeEntity(target.getCoordinates());
            }
            creature.reachedTarget();
        }
    }
}
