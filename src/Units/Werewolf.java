package Units;

import Abilities.Ability;
import Abilities.DefaultAbility;
import Abilities.WerewolfAbility;
import Exceptions.IncompatibleAbilityException;
import Exceptions.UnitIsDeadException;
import States.State;
import States.UsualState;
import States.WerewolfState;

public class Werewolf extends Unit {
    private State alternativeState;
    private Ability alternativeAbility;

    public Werewolf(State state, Ability ability) {
        super(state, ability);
        this.alternativeState = new WerewolfState("Werewolf", 200, 50);
        this.alternativeAbility = new WerewolfAbility("Claw");
    }

    public Werewolf() {
        this(new UsualState("Werewolf", 100, 20), new DefaultAbility("Sword"));
    }

    @Override
    public void attack(Unit enemy) throws UnitIsDeadException, IncompatibleAbilityException {
        this.getState().isAlive();
        this.ability.action(enemy, this.getState().getDamage());
        this.counterAttack(enemy);
    }

    public void transform() {
        int newHp = (this.getState().getHp() * this.alternativeState.getHp()) / this.getState().getMaxHp();

        State tempState = state;
        state = alternativeState;
        alternativeState = tempState;
        Ability tempAbility = ability;
        ability = alternativeAbility;
        alternativeAbility = tempAbility;
        this.getState().setHp(newHp);
    }
}
