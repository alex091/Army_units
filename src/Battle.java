import Exceptions.IncompatibleAbilityException;
import Exceptions.NotEnoughManaException;
import Exceptions.UnitIsDeadException;
import SpellCasters.Wizard;
import Units.*;

public class Battle {
    public static void main(String[] args) throws UnitIsDeadException, IncompatibleAbilityException, NotEnoughManaException {
        Unit s1 = new Soldier();
        Unit s2 = new Soldier();
        Unit rogue = new Rogue();
        Unit berserker = new Berserker();
        Unit vampire = new Vampire();
        Werewolf werewolf = new Werewolf();
        Wizard wiz = new Wizard();

        System.out.println(s1);
        /**System.out.println(werewolf);
        System.out.println(s2);
        System.out.println(rogue);
        System.out.println(berserker);
        System.out.println(vampire);
        */
        System.out.println(wiz);

        wiz.cast("FireBall", s1);

        //vampire.attack(s1);
        //s1.attack(vampire);
        //s1.attack(vampire);
        //vampire.attack(s1);
        //werewolf.transform();


        //s1.attack(s2);
        //s1.attack(s2);
        //s2.attack(s1);
        //berserker.attack(s2);
        //rogue.attack(s1);

        System.out.println(s1);
        //System.out.println(werewolf);
        //System.out.println(s2);
        //System.out.println(rogue);
        //System.out.println(berserker);
        //System.out.println(vampire);
        System.out.println(wiz);
    }
}
