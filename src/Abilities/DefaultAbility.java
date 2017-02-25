package Abilities;

import Exceptions.UnitIsDeadException;
import Units.Unit;

public class DefaultAbility extends Ability {
    public DefaultAbility(String name) {
        super(name);
    }

    @Override
    public void action(Unit enemy, int damage) throws UnitIsDeadException {
        enemy.getState().takePhysicalDamage(damage, enemy);
    }
}
