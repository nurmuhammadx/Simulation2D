package entity.creature.impl;

import action.MoveRequest;
import core.SimulationConfig;
import entity.GameEntity;
import entity.creature.Creature;
import map.Coordinates;
import map.SimulationMap;
import pathfinding.IPathfinder;

import java.util.LinkedList;

public class Herbivore extends Creature {
    private final LinkedList<Coordinates> currentPath = new LinkedList<>();
    private GameEntity target;

    public Herbivore(Coordinates coordinates, Integer speed, Integer health) {
        super(coordinates, speed, health);
    }

    @Override
    // как будто бы это должно быть проверочный метод и еше когда дошел дл цели удалить цель и вставить себя на место цели
    public void makeMove(SimulationMap simulationMap, IPathfinder pathFinder, SimulationConfig simulationConfig) {
        if (target == null) {
            target = simulationMap.getGrass().get(0);
        }
        if (simulationMap.getEntities().containsKey(target.getCoordinates())) {
            // типа взять список грасов на карте и вернуть другой грасс и вставить в таргет
        }
        if (currentPath.isEmpty()) {
            currentPath.addAll(pathFinder.findPath(coordinates, target.getCoordinates(), simulationConfig));
        }
    }

    public MoveRequest getMoveRequest(SimulationMap simulationMap, IPathfinder pathFinder, SimulationConfig simulationConfig) {
        currentPath.addAll(pathFinder.findPath(coordinates, simulationMap.getGrass().get(0).getCoordinates(), simulationConfig));
        return new MoveRequest(currentPath.getFirst(), this);
    }

    // на счет скорости типа можно сделать спид гет по индексу и ремув тоде по циклу до спида
    public void remove() {
        currentPath.removeFirst();
    }

    public Integer getPositionX() {
        return coordinates.getPositionX();
    }

    public Integer getPositionY() {
        return coordinates.getPositionY();
    }
}
