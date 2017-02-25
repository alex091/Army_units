package SpellCasters;

import Abilities.Ability;
import Abilities.DefaultAbility;
import Exceptions.IncompatibleAbilityException;
import Exceptions.NotEnoughManaException;
import Exceptions.UnitIsDeadException;
import Interfaces.Observable;
import Interfaces.Observer;
import States.State;
import States.UsualState;
import Units.Unit;

import java.util.HashSet;
import java.util.Set;

public class Necromancer extends SpellCaster implements Observer {
    protected Set<Observable> observables = new HashSet<Observable>();

    public Necromancer(State state, Ability ability, MagicianFeature magicianFeature) {
        super(state, ability, magicianFeature);
        isUndead = true;
    }

    public Necromancer() {
        this(new UsualState("Necromancer", 50, 10), new DefaultAbility("Sword"), new MagicianFeature(150));
    }

    @Override
    public void attack(Unit enemy) throws UnitIsDeadException, IncompatibleAbilityException {
        this.getState().isAlive();
        addObservable(enemy);
        this.ability.action(enemy, this.getState().getDamage());
        this.counterAttack(enemy);
    }

    @Override
    public void cast(String spellName, Unit enemy) throws UnitIsDeadException, NotEnoughManaException {
        this.getState().isAlive();
        this.magicianFeature.spendMana(spellbook.get(spellName).getSpellCost());
        addObservable(enemy);
        spellbook.get(spellName).spellAction(this, enemy);
    }

    public void addObservable(Observable observable) {
        observables.add(observable);
        observable.addObserver(this);
    }

    public void removeObservable(Observable observable) {
        observables.remove(observable);
    }

    public void sendNotification() {
        for ( Observable observable : observables ) {
            observable.removeObserver(this);
        }

    }
}
