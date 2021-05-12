package stuffs;

import characters.Character;
import characters.Wizard;

/**
 * Spell Class for the Wizard Only
 *
 * @author Meunier Terence
 * @version 1.0
 *
 * @see Stuff
 * @see Wizard
 */
public class Spell extends Stuff {

    private int atqLevel;

    /**
     * Constructor with name and atqLevel of the Spell
     * @param name name of the spell
     * @param atqLevel atq level of the spell
     */
    public Spell(String name, int atqLevel) {
        super(name);
        this.atqLevel = atqLevel;
    }

    /**
     * Action for assign spell to the wizard
     * @param character character who receive the spell
     */
    @Override
    public void action(Character character) {
        if (character instanceof Wizard) {
            Wizard w = (Wizard) character;
            if (w.getSpell() != null) {
                if (w.getSpell().getAtqLevel() < this.atqLevel) {
                    w.setSpell(this);
                } else {
                    System.out.println("Sort actuel conservée");
                }
            } else {
                w.setSpell(this);
            }
        } else {
            System.out.println("Les sorts ne sont que pour les magiciens");
        }
    }

    public int getAtqLevel() {
        return atqLevel;
    }

    public void setAtqLevel(int atqLevel) {
        this.atqLevel = atqLevel;
    }

    @Override
    public String toString() {
        return super.toString() + "(atq : " + atqLevel + ")";
    }
}
