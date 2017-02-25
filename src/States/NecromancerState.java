package States;

import Exceptions.UnitIsDeadException;
import SpellCasters.Necromancer;
import Units.Unit;

public class NecromancerState extends State {
    public NecromancerState(String name, int hp, int damage) {
        super(name, hp, damage);
    }

    @Override
    public void takePhysicalDamage(int damage, Unit owner) throws UnitIsDeadException {
        isAlive();

        if ( hp < damage ) {
            hp = 0;
            ((Necromancer)owner).sendNotification();
        } else {
            hp -= damage;
        }
    }

    @Override
    public void takeMagicDamage(int damage, Unit owner) throws UnitIsDeadException {
        isAlive();

        if ( hp < damage ) {
            hp = 0;
            ((Necromancer)owner).sendNotification();
        } else {
            hp -= damage;
        }
    }
}
