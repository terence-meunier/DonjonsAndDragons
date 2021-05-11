package stuffs;

import characters.Character;
import characters.Warrior;
import characters.Wizard;

public class Spell extends Stuff {

    private int atqLevel;

    public Spell(String name, int atqLevel) {
        super(name);
        this.atqLevel = atqLevel;
    }

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
