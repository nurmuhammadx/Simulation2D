package creature.impl;

import creature.Creature;
import map.Coordinates;

public class Herbivore extends Creature {

    public Herbivore(Coordinates coordinates, Integer speed, Integer health) {
        super(coordinates, speed, health);
    }


    @Override
    public void makeMove() {

    }
}
