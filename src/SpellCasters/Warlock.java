package SpellCasters;

import Abilities.Ability;
import Abilities.DefaultAbility;
import Exceptions.IncompatibleAbilityException;
import Exceptions.NotEnoughManaException;
import Exceptions.UnitIsDeadException;
import States.State;
import States.UsualState;
import States.WarlockState;
import Units.Demon;
import Units.Unit;

public class Warlock extends SpellCaster {
    private Demon slave;

    public Warlock(State state, Ability ability, MagicianFeature magicianFeature) {
        super(state, ability, magicianFeature);
        this.slave = null;
    }

    public Warlock() {
        this(new WarlockState("Warlock", 70, 20), new DefaultAbility("Sword"), new MagicianFeature(200));
    }

    public void callDemon() throws NotEnoughManaException {
        this.magicianFeature.spendMana(100);
        if ( slave != null ) {
            freeSlave();
        }
        slave = new Demon(this);
    }

    public void demonAttack(Unit enemy) throws UnitIsDeadException, IncompatibleAbilityException {
        slave.attack(enemy);
    }

    public void freeSlave() {
        slave = null;
    }


}
