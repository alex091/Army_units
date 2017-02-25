package Units;

import Abilities.Ability;
import Abilities.DefaultAbility;
import Exceptions.IncompatibleAbilityException;
import Exceptions.UnitIsDeadException;
import States.BerserkerState;
import States.State;
import com.sun.jndi.ldap.Ber;

public class Berserker extends Unit {
    public Berserker(State state, Ability ability) {
        super(state, ability);
    }

    public Berserker() {
        this(new BerserkerState("Berserker", 100, 30), new DefaultAbility("Axe"));
    }

    @Override
    public void attack(Unit enemy) throws UnitIsDeadException, IncompatibleAbilityException {
        this.getState().isAlive();
        this.ability.action(enemy, this.getState().getDamage());
        this.counterAttack(enemy);
    }
}
