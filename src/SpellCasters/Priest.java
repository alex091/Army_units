package SpellCasters;

import Abilities.Ability;
import Abilities.DefaultAbility;
import States.State;
import States.UsualState;

public class Priest extends SpellCaster {
    public Priest(State state, Ability ability, MagicianFeature magicianFeature) {
        super(state, ability, magicianFeature);
        isPriest = true;
        isHealer = true;
    }

    public Priest() {
        this(new UsualState("Priest", 40, 10), new DefaultAbility("Sword"), new MagicianFeature(120));
    }
}
