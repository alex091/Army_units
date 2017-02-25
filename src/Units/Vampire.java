package Units;

import Abilities.Ability;
import Abilities.VampireAbility;
import Exceptions.IncompatibleAbilityException;
import Exceptions.UnitIsDeadException;
import States.State;
import States.UsualState;

public class Vampire extends Unit {
    public Vampire(State state, Ability ability) {
        super(state, ability);
        this.isUndead = true;
    }

    public Vampire() {
        this(new UsualState("Vampire", 100, 20), new VampireAbility("Fang"));
    }

    @Override
    public void attack(Unit enemy) throws UnitIsDeadException, IncompatibleAbilityException {
        this.getState().isAlive();
        this.ability.action(enemy, this.getState().getDamage());
        this.getState().addHp(enemy.getState().getHp()/10);
        this.counterAttack(enemy);
    }
}
