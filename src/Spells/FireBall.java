package Spells;

import Exceptions.UnitIsDeadException;
import SpellCasters.SpellCaster;
import Units.Unit;

public class FireBall extends Spell {
    public FireBall(String name, int spellCost, int spellDamage) {
        super(name, spellCost, spellDamage);
    }

    public FireBall() {
        this("FireBall", 20, 20);
    }

    @Override
    public void spellAction(SpellCaster attacker, Unit enemy) throws UnitIsDeadException {
        if (attacker.getIsHealer()) {
            if (attacker.getIsPriest() && enemy.getIsUndead()) {
                enemy.getState().takeMagicDamage(spellDamage * 2, enemy);
            } else {
                enemy.getState().takeMagicDamage(spellDamage / 2, enemy);
            }
        } else {
            enemy.getState().takeMagicDamage(spellDamage, enemy);
        }
    }
}
