package SpellCasters;

import Exceptions.NotEnoughManaException;

public class MagicianFeature {
    private int mana;
    private int maxMana;

    public MagicianFeature(int mana) {
        this.mana = mana;
        this.maxMana = mana;
    }

    public int getMana() {
        return mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void spendMana(int cost) throws NotEnoughManaException {
        if ( cost > this.mana ) {
            throw new NotEnoughManaException();
        }
        this.mana -= cost;
    }

    public void addMana(int extra) {
        int total = this.mana + extra;

        if ( total > this.maxMana ) {
            this.mana = this.maxMana;
        } else {
            this.mana = total;
        }
    }
}
