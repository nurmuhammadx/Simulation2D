package creature.impl;

import creature.Creature;
import map.Coordinates;

public class Predator extends Creature {
    private final Integer attackPower;

    public Predator(Coordinates coordinates, Integer speed, Integer health, Integer attackPower) {
        super(coordinates, speed, health);
        this.attackPower = attackPower;
    }

    @Override
    public void makeMove() {

    }
}
