package Spells;

import Exceptions.UnitIsDeadException;
import SpellCasters.SpellCaster;
import Units.Unit;

public class LightningStrike extends Spell{
    public LightningStrike(String name, int spellCost, int spellDamage) {
        super(name, spellCost, spellDamage);
    }

    public LightningStrike() {
        this("LightningStrike", 20, 20);
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
