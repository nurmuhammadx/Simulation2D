package entity.creature.impl;

import entity.GameEntity;
import entity.creature.Creature;
import map.Coordinates;
import map.SimulationMap;
import pathfinding.IPathfinder;

import java.util.List;

public class Predator extends Creature {
    private final Integer attackPower;

    public Predator(Coordinates coordinates, Integer speed, Integer health, Integer attackPower) {
        super(coordinates, speed, health);
        this.attackPower = attackPower;
    }

    @Override
    protected Coordinates findNearestTarget(SimulationMap simulationMap, IPathfinder pathfinder) {
        Coordinates nearestHerbivore = null;
        int shortestPath = Integer.MAX_VALUE;
        for (Coordinates herbivore : simulationMap.getHerbivore()) {
            List<Coordinates> path = pathfinder.findPath(coordinates, herbivore, simulationMap);
            if (!path.isEmpty() && path.size() < shortestPath) {
                shortestPath = path.size();
                nearestHerbivore = herbivore;
            }
        }

        return nearestHerbivore;
    }

    @Override
    protected boolean isTargetAlive(SimulationMap simulationMap) {
        return simulationMap.getHerbivore().contains(target);
    }

    @Override
    public boolean canEat(GameEntity entity) {
        return entity instanceof Herbivore;
    }
}
