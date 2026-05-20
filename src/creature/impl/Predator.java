package creature.impl;

import creature.Creature;

public class Predator extends Creature {
    private final Integer attackPower;

    public Predator(Integer speed, Integer health, Integer attackPower) {
        super(speed, health);
        this.attackPower = attackPower;
    }

    @Override
    public void makeMove() {

    }
}
