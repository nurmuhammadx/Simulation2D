package entity.creature;

import action.impl.MoveRequest;
import entity.GameEntity;
import map.Coordinates;
import map.SimulationMap;
import pathfinding.IPathfinder;

import java.util.LinkedList;

public abstract class Creature extends GameEntity {
    private final Integer speed;
    private final Integer health;
    protected final LinkedList<Coordinates> currentPath = new LinkedList<>();
    protected Coordinates target;

    public Creature(Coordinates coordinates, Integer speed, Integer health) {
        super(coordinates);
        this.speed = speed;
        this.health = health;
    }

    protected abstract Coordinates findNearestTarget(SimulationMap simulationMap, IPathfinder pathfinder);

    protected abstract boolean isTargetAlive(SimulationMap simulationMap);

    public abstract boolean canEat(GameEntity entity);

    public MoveRequest getMoveRequest(SimulationMap simulationMap, IPathfinder pathFinder) {
        setTarget(pathFinder, simulationMap);
        setPath(pathFinder, simulationMap);

        if (currentPath.isEmpty()) {
            return null;
        }

        Coordinates nextStep = currentPath.removeFirst();
        GameEntity targetEntity = simulationMap.getEntity(nextStep);
        return new MoveRequest(coordinates, nextStep,this, targetEntity);
    }

    public void reachedTarget() {
        target = null;
        currentPath.clear();
    }

    protected void setTarget(IPathfinder pathFinder, SimulationMap simulationMap) {
        if (target != null && isTargetAlive(simulationMap)) {
            return;
        }

        target = null;
        currentPath.clear();

        target = findNearestTarget(simulationMap, pathFinder);
    }

    protected void setPath(IPathfinder pathFinder, SimulationMap simulationMap) {
        if (target == null) {
            return;
        }

        if (coordinates.equals(target)) {
            reachedTarget();
            return;
        }

        if (currentPath.isEmpty()) {
            currentPath.addAll(pathFinder.findPath(coordinates, target, simulationMap));
        }
    }
}
