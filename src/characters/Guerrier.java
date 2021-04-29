package characters;

import stuffs.Weapon;

public class Guerrier extends Character {
	private Weapon weapon;
	private String shield;

	public Guerrier() {
		this(null);
	}

	public Guerrier(String name) {
		this(name, 5, 5);
	}

	public Guerrier(String name, int lifeLevel, int strongLevel) {
		super(name, lifeLevel, strongLevel);
		this.weapon = null;
		this.shield = "Ecu";
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public String getShield() {
		return shield;
	}

	public void setShield(String shield) {
		this.shield = shield;
	}

}
