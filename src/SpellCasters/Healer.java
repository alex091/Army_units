package SpellCasters;

import Abilities.Ability;
import Abilities.DefaultAbility;
import Exceptions.IncompatibleAbilityException;
import Exceptions.UnitIsDeadException;
import States.State;
import States.UsualState;
import Units.Unit;

public class Healer extends SpellCaster {
    public Healer(State state, Ability ability, MagicianFeature magicianFeature) {
        super(state, ability, magicianFeature);
        isHealer = true;
    }

    public Healer() {
        this(new UsualState("Healer", 50, 20), new DefaultAbility("Sword"), new MagicianFeature(150));
    }
}
