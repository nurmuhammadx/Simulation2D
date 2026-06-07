package entity.creature.impl;

import action.MoveRequest;
import entity.creature.Creature;
import map.Coordinates;
import map.SimulationMap;
import pathfinding.IPathfinder;

import java.util.LinkedList;

public class Herbivore extends Creature {
    private final LinkedList<Coordinates> currentPath = new LinkedList<>();
    private Coordinates target;

    public Herbivore(Coordinates coordinates, Integer speed, Integer health) {
        super(coordinates, speed, health);
    }

    @Override
    public MoveRequest getMoveRequest(SimulationMap simulationMap, IPathfinder pathFinder) {
        ensureTarget(simulationMap);
        ensurePath(pathFinder);
        if (currentPath.isEmpty()) {
            return null;
        }
        Coordinates nextStep = currentPath.removeFirst();
        return new MoveRequest(nextStep, this);
    }

    public void reachedTarget() {
        target = null;
        currentPath.clear();
    }

    private void ensureTarget(SimulationMap simulationMap) {
        if (target != null && !simulationMap.getGrass().contains(target)) {
            target = null;
            currentPath.clear();
        }

        if (target == null) {
            if (simulationMap.getGrass().isEmpty()) {
                return;
            }
            target = simulationMap.getGrass().getFirst();
        }
    }

    private void ensurePath(IPathfinder pathFinder) {
        if (target == null) {
            return;
        }

        if (coordinates.equals(target)) {
            reachedTarget();
            return;
        }

        if (currentPath.isEmpty()) {
            currentPath.addAll(pathFinder.findPath(coordinates, target));
        }
    }
}
