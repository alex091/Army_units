package Units;

import Abilities.Ability;
import Abilities.DefaultAbility;
import SpellCasters.Warlock;
import States.State;
import States.UsualState;

public class Demon extends Soldier {
    private Warlock master;

    public Demon(Warlock master) {
        super(new UsualState("Demon",120, 20), new DefaultAbility("Sword"));
        this.isUndead = true;
    }
}
