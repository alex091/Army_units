package SpellCasters;

import Abilities.Ability;
import Exceptions.IncompatibleAbilityException;
import Exceptions.NotEnoughManaException;
import Exceptions.UnitIsDeadException;
import Spells.FireBall;
import Spells.Heal;
import Spells.LightningStrike;
import Spells.Spell;
import States.State;
import Units.Unit;
import sun.util.PreHashedMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class SpellCaster extends Unit {
    protected  MagicianFeature magicianFeature;
    protected boolean isHealer;
    protected  boolean isPriest;
    protected static Map<String, Spell> spellbook;

    static {
        spellbook = new HashMap<String, Spell>();
        spellbook.put("FireBall", new FireBall());
        spellbook.put("LightningStrike", new LightningStrike());
        spellbook.put("Heal", new Heal());
        spellbook = Collections.unmodifiableMap(spellbook);
    }

    public SpellCaster(State state, Ability ability, MagicianFeature magicianFeature) {
        super(state, ability);
        this.magicianFeature = magicianFeature;
        isHealer = false;
        isPriest = false;
    }

    public boolean getIsHealer() {
        return isHealer;
    }

    public boolean getIsPriest() {
        return isPriest;
    }

    public void cast(String spellName, Unit enemy) throws UnitIsDeadException, NotEnoughManaException {
        this.getState().isAlive();
        this.magicianFeature.spendMana(spellbook.get(spellName).getSpellCost());
        spellbook.get(spellName).spellAction(this, enemy);
    }

    @Override
    public void attack(Unit enemy) throws UnitIsDeadException, IncompatibleAbilityException {
        this.getState().isAlive();
        this.ability.action(enemy, this.getState().getDamage());
        this.counterAttack(enemy);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Mana: " + magicianFeature.getMana() + "/" + magicianFeature.getMaxMana() + "\n";
    }
}
