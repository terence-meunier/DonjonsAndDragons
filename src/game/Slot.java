package game;

import characters.Ennemy;
import stuffs.Potion;
import stuffs.Spell;
import stuffs.Weapon;

public class Slot {
    private Potion potion;
    private Weapon weapon;
    private Spell spell;
    private Ennemy ennemy;

    public Slot() {
        this.potion = null;
        this.weapon = null;
        this.spell = null;
        this.ennemy = null;
    }

    public Potion getPotion() {
        return potion;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Spell getSpell() {
        return spell;
    }

    public Ennemy getEnnemy() {
        return ennemy;
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setSpell(Spell spell) {
        this.spell = spell;
    }

    public void setEnnemy(Ennemy ennemy) {
        this.ennemy = ennemy;
    }

    public String toString() {
        if (potion != null) {
            return potion.getName();
        } else if (ennemy != null) {
            return ennemy.getName();
        } else if (spell != null) {
            return spell.getName();
        } else if (weapon != null) {
            return weapon.getName();
        } else {
            return "Case vide";
        }
    }
}
