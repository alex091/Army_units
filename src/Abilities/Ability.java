package Abilities;

import Exceptions.IncompatibleAbilityException;
import Exceptions.UnitIsDeadException;
import Units.Unit;

public abstract class Ability {
    protected String name;

    public Ability(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void action(Unit enemy, int damage) throws UnitIsDeadException, IncompatibleAbilityException;
}
