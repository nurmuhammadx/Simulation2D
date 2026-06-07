package entity.creature.impl;

import action.MoveRequest;
import core.SimulationConfig;
import entity.creature.Creature;
import map.Coordinates;
import map.SimulationMap;
import pathfinding.IPathfinder;

import java.util.LinkedList;

public class Predator extends Creature {
    private final Integer attackPower;
    private final LinkedList<Coordinates> currentPath = new LinkedList<>();
    private Coordinates target;

    public Predator(Coordinates coordinates, Integer speed, Integer health, Integer attackPower) {
        super(coordinates, speed, health);
        this.attackPower = attackPower;
    }

    @Override
    public MoveRequest getMoveRequest(SimulationMap simulationMap, IPathfinder pathFinder) {
        return null;
    }
}
