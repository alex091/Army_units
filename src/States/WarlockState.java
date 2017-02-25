package States;

import Exceptions.UnitIsDeadException;
import SpellCasters.Warlock;
import Units.Unit;

public class WarlockState extends State {
    public WarlockState(String name, int hp, int damage) {
        super(name, hp, damage);
    }

    @Override
    public void takePhysicalDamage(int damage, Unit owner) throws UnitIsDeadException {
        isAlive();

        if ( hp < damage ) {
            hp = 0;
            owner.notifyObserver();
            ((Warlock)owner).freeSlave();
        } else {
            hp -= damage;
        }
    }

    @Override
    public void takeMagicDamage(int damage, Unit owner) throws UnitIsDeadException {
        isAlive();

        if ( hp < damage ) {
            hp = 0;
            owner.notifyObserver();
            ((Warlock)owner).freeSlave();
        } else {
            hp -= damage;
        }
    }
}
