package entity.creature;

import action.impl.MoveRequest;
import entity.GameEntity;
import map.Coordinates;
import map.SimulationMap;
import pathfinding.IPathfinder;

import java.util.LinkedList;

public abstract class Creature extends GameEntity {
    private final Integer speed;
    private Integer health;
    private final Integer MAX_HEALTH = 100;
    protected final LinkedList<Coordinates> currentPath = new LinkedList<>();
    protected Coordinates target;

    public Creature(Coordinates coordinates, Integer speed, Integer health) {
        super(coordinates);
        this.speed = speed;
        this.health = health;
    }

    protected abstract Coordinates findNearestTarget(SimulationMap simulationMap, IPathfinder pathfinder);

    protected abstract boolean isTargetAlive(SimulationMap simulationMap);

    public abstract void interact(GameEntity target, SimulationMap simulationMap);

    public MoveRequest getMoveRequest(SimulationMap simulationMap, IPathfinder pathFinder) {
        setTarget(pathFinder, simulationMap);
        setPath(pathFinder, simulationMap);

        if (currentPath.isEmpty()) {
            return null;
        }

        Coordinates destination = getDestination();
        GameEntity targetEntity = simulationMap.getEntity(destination);
        return new MoveRequest(coordinates, destination,this, targetEntity);
    }

    public void reachedTarget() {
        target = null;
        currentPath.clear();
    }

    public int getHealth() {
        return health;
    }

    public boolean isDead() {
        return getHealth() <= 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void heal(int amount) {
        health = Math.min(MAX_HEALTH, health + amount);
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

    private Coordinates getDestination() {
        Coordinates destination = coordinates;
        int steps = Math.min(speed, currentPath.size());
        for (int i = 0; i < steps; i++) {
            destination = currentPath.removeFirst();
            if (destination.equals(target)) {
                break;
            }
        }
        return destination;
    }
}
