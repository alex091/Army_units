package Abilities;

import Exceptions.IncompatibleAbilityException;
import Exceptions.UnitIsDeadException;
import States.UsualState;
import Units.Unit;

public class VampireAbility extends Ability {
    private int chanceToInfect;

    public VampireAbility(String name) {
        super(name);
        this.chanceToInfect = 1;
    }

    @Override
    public void action(Unit enemy, int damage) throws UnitIsDeadException, IncompatibleAbilityException {
        enemy.getState().takePhysicalDamage(damage, enemy);
        if ( chanceToInfect % 3 == 0 ) {
            infect(enemy);
        }
        this.chanceToInfect += 1;
    }

    private void infect(Unit enemy) throws IncompatibleAbilityException {
        if (enemy.getState().getName().equals("Werewolf")) {
            throw new IncompatibleAbilityException();
        }
        enemy.setAbility(new VampireAbility("Fang"));
        enemy.setState(new UsualState("Vampire", 100, 20));
    }
}
