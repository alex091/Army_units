package SpellCasters;

import Abilities.Ability;
import Abilities.DefaultAbility;
import Exceptions.IncompatibleAbilityException;
import Exceptions.UnitIsDeadException;
import States.State;
import States.UsualState;
import Units.Unit;

public class Wizard extends SpellCaster {
    public Wizard(State state, Ability ability, MagicianFeature magicianFeature) {
        super(state, ability, magicianFeature);
    }

    public Wizard() {
        this(new UsualState("Wizard", 50, 20), new DefaultAbility("Sword"), new MagicianFeature(200));
    }
}
