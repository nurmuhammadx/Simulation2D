package action.interaction;

import core.SimulationConfig;
import entity.GameEntity;
import entity.creature.Creature;
import map.SimulationMap;

import java.util.List;

public class InteractionAction {

    public InteractionAction() {}

    public void interact(SimulationMap simulationMap, List<MoveRequest> moveRequests) {
        for (MoveRequest request : moveRequests) {
            if (request.getTarget() != null) {
                request.getCreature().interact(request.getTarget(), simulationMap);
            }
        }
    }

    public void takeHungerDamage(SimulationMap simulationMap) {
        for (GameEntity entity : simulationMap.getEntities().values()) {
            if (entity instanceof Creature creature) {
                creature.applyHungerDamage(simulationMap, SimulationConfig.HUNGER_DAMAGE);
                if (creature.isDead()) {
                    simulationMap.removeEntity(entity.getCoordinates());
                }
            }
        }
    }
}
