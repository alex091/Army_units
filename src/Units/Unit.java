package Units;

import Abilities.Ability;
import Exceptions.IncompatibleAbilityException;
import Exceptions.UnitIsDeadException;
import Interfaces.Observable;
import Interfaces.Observer;
import States.State;

import java.util.HashSet;
import java.util.Set;

public abstract class Unit implements Observable {
    protected Set<Observer> observers = new HashSet<Observer>();
    protected State state;
    protected Ability ability;
    protected boolean isUndead;

    public Unit(State state, Ability ability) {
        this.state = state;
        this.ability = ability;
        this.isUndead = false;
    }

    public State getState() {
        return state;
    }

    public Ability getAbility() {
        return ability;
    }

    public boolean getIsUndead() {
        return isUndead;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public abstract void attack(Unit enemy) throws UnitIsDeadException, IncompatibleAbilityException;

    protected void counterAttack(Unit enemy) throws UnitIsDeadException, IncompatibleAbilityException {
        enemy.getState().isAlive();
        enemy.ability.action(this, enemy.getState().getDamage()/2);
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObserver() throws UnitIsDeadException {
        for ( Observer observer : observers ) {
            ((Unit)observer).getState().addHp(10);
            observer.removeObservable(this);
        }
    }

    public String toString() {
        return getState().getName() + ":\n" +
                "Hp (" + getState().getHp() + "/" + getState().getMaxHp() + ")\n" +
                "Ability: " + getAbility().getName() + "\n";
    }
}
