package States;

import Exceptions.UnitIsDeadException;
import Units.Unit;

public abstract class State {
    protected String name;
    protected int hp;
    protected int maxHp;
    protected int damage;

    public State(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getDamage() {
        return damage;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void isAlive() throws UnitIsDeadException{
        if ( hp <= 0 ) {
            throw new UnitIsDeadException();
        }
    }

    public void addHp(int extra) throws UnitIsDeadException {
        isAlive();

        if ( hp + extra > maxHp) {
            hp = maxHp;
        } else {
            hp += extra;
        }
    }

    public abstract void takePhysicalDamage(int damage, Unit owner) throws UnitIsDeadException;
    public abstract void takeMagicDamage(int damage, Unit owner) throws UnitIsDeadException;
}
