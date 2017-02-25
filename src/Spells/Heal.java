package Spells;

import Exceptions.UnitIsDeadException;
import SpellCasters.SpellCaster;
import Units.Unit;

public class Heal extends Spell {
    public Heal(String name, int spellCost, int spellDamage) {
        super(name, spellCost, spellDamage);
    }

    public Heal(){
        this("Heal", 20, 20);
    }

    @Override
    public void spellAction(SpellCaster attacker, Unit enemy) throws UnitIsDeadException {
        if (attacker.getIsHealer()){
            enemy.getState().addHp(spellDamage);
        } else {
            enemy.getState().addHp(spellDamage / 2);
        }
    }
}
