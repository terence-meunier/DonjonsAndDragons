package stuffs;

import characters.Character;
import characters.Warrior;
import characters.Wizard;

public class Weapon extends Stuff {
	private int atqLevel;
	
	public Weapon(String name, int atqLevel) {
		super(name);
		this.atqLevel = atqLevel;
	}

	@Override
	public void action(Character character) {
		if (character instanceof Warrior) {
			if (((Warrior) character).getWeapon() != null) {
				if (((Warrior) character).getWeapon().getAtqLevel() < this.atqLevel) {
					((Warrior) character).setWeapon(this);
				} else {
					System.out.println("Sort actuel conservée");
				}
			} else {
				((Warrior) character).setWeapon(this);
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
