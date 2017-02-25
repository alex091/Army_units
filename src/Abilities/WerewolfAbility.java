package Abilities;

import Exceptions.IncompatibleAbilityException;
import Exceptions.UnitIsDeadException;
import States.WerewolfState;
import Units.Unit;


public class WerewolfAbility extends Ability {
    private int chanceToInfect;

    public WerewolfAbility(String name) {
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
        if (enemy.getState().getName().equals("Vampire")) {
            throw new IncompatibleAbilityException();
        }
        enemy.setAbility(new WerewolfAbility("Claw"));
        enemy.setState(new WerewolfState("Werewolf", 100, 20));
    }
}
