package Units;

import Abilities.Ability;
import Abilities.DefaultAbility;
import Exceptions.IncompatibleAbilityException;
import Exceptions.UnitIsDeadException;
import States.State;
import States.UsualState;

public class Rogue extends Unit {
    public Rogue(State state, Ability ability) {
        super(state, ability);
    }

    public Rogue() {
        this(new UsualState("Rogue", 120, 30), new DefaultAbility("Sword"));
    }

    @Override
    public void attack(Unit enemy) throws UnitIsDeadException, IncompatibleAbilityException {
        this.getState().isAlive();
        this.ability.action(enemy, this.getState().getDamage());
    }
}
