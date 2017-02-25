package Spells;

import Exceptions.UnitIsDeadException;
import SpellCasters.SpellCaster;
import Units.Unit;

public abstract class Spell {
    protected String name;
    protected int spellCost;
    protected int spellDamage;

    public Spell(String name, int spellCost, int spellDamage) {
        this.name = name;
        this.spellCost = spellCost;
        this.spellDamage = spellDamage;
    }

    public int getSpellDamage() {
        return spellDamage;
    }

    public int getSpellCost() {
        return spellCost;
    }

    public String getName() {
        return name;
    }

    public abstract void spellAction(SpellCaster attacker, Unit enemy) throws UnitIsDeadException;
}