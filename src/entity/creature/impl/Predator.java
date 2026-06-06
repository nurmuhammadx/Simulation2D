package entity.creature.impl;

import core.SimulationConfig;
import entity.creature.Creature;
import map.Coordinates;
import map.SimulationMap;
import pathfinding.IPathfinder;

public class Predator extends Creature {
    private final Integer attackPower;

    public Predator(Coordinates coordinates, Integer speed, Integer health, Integer attackPower) {
        super(coordinates, speed, health);
        this.attackPower = attackPower;
    }

    @Override
    public void makeMove(SimulationMap simulationMap,  IPathfinder pathFinder,  SimulationConfig config) {

    }
}
