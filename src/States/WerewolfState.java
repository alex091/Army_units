package States;

import Exceptions.UnitIsDeadException;
import Units.Unit;

public class WerewolfState extends State {
    public WerewolfState(String name, int hp, int damage) {
        super(name, hp, damage);
    }

    @Override
    public void takePhysicalDamage(int damage, Unit owner) throws UnitIsDeadException {
        isAlive();

        if ( hp < damage ) {
            hp = 0;
            owner.notifyObserver();
        } else {
            hp -= damage;
        }
    }

    @Override
    public void takeMagicDamage(int damage, Unit owner) throws UnitIsDeadException {
        isAlive();
        damage *= 2;

        if ( hp < damage ) {
            hp = 0;
            owner.notifyObserver();
        } else {
            hp -= damage;
        }
    }
}
