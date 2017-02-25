package Units;

import Abilities.Ability;
import Abilities.DefaultAbility;
import Exceptions.IncompatibleAbilityException;
import Exceptions.UnitIsDeadException;
import States.State;
import States.UsualState;

public class Soldier extends Unit {
    public Soldier(State state, Ability ability) {
        super(state, ability);
    }

    public Soldier() {
        this(new UsualState("Soldier", 100, 20), new DefaultAbility("Sword"));
    }

    @Override
    public void attack(Unit enemy) throws UnitIsDeadException, IncompatibleAbilityException {
        this.getState().isAlive();
        this.ability.action(enemy, this.getState().getDamage());
        this.counterAttack(enemy);
    }
}
