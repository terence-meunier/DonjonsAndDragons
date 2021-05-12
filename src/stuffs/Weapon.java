package stuffs;

import characters.Character;
import characters.Warrior;

/**
 * Weapon class only for the Warrior class
 *
 * @author Meunier Terence
 * @version 1.0
 *
 * @see Stuff
 * @see Warrior
 */
public class Weapon extends Stuff {
	private int atqLevel;

	/**
	 * Constructor with name and atqLevel
	 * @param name name of the weapon
	 * @param atqLevel atq level of the weapon
	 */
	public Weapon(String name, int atqLevel) {
		super(name);
		this.atqLevel = atqLevel;
	}

	/**
	 * Action for assign weapon to the Warrior
	 * @param character character who receive the weapon
	 */
	@Override
	public void action(Character character) {
		if (character instanceof Warrior) {
			Warrior w = (Warrior) character;
			if (w.getWeapon() != null) {
				if (w.getWeapon().getAtqLevel() < this.atqLevel) {
					w.setWeapon(this);
				} else {
					System.out.println("Sort actuel conservée");
				}
			} else {
				w.setWeapon(this);
			}
		} else {
			System.out.println("Les armes ne sont que pour les guerriers");
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
		return super.toString() + " (atq : " + atqLevel + ")";
	}
}
