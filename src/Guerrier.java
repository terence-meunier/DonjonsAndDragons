
public class Guerrier extends Character {
	private String name;
	private int lifeLevel;
	private int strongLevel;
	private Weapon weapon;
	private String shield;

	private static int RandNum() {
		Double j = 5 + Math.random()*5;
		return j.intValue();
	}
	
	public Guerrier() {
		this(null);
	}

	public Guerrier(String name) {
		this(name, RandNum(), RandNum());
	}

	public Guerrier(String name, int lifeLevel, int strongLevel) {
		super(name, lifeLevel, strongLevel);
		this.weapon = new Weapon("Epee", 50);
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
