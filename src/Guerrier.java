
public class Guerrier {
	private String name;
	private int lifeLevel;
	private int strongLevel;
	private Weapon weapon;
	private String shield;
	
	private int RandNum() {
		Double j = 5 + Math.random()*5;
		return j.intValue();
	}
	
	public Guerrier() {
		this.name = null;
		this.lifeLevel = RandNum();
		this.strongLevel = RandNum();
		this.weapon = new Weapon("Epée", 50);
		this.shield = "Ecu";
	}
	
	public Guerrier(String name) {
		this.name = name;
		this.lifeLevel = RandNum();
		this.strongLevel = RandNum();
		this.weapon = new Weapon("Epée", 50);
		this.shield = "Ecu";
	}
	
	public Guerrier(String name, int lifeLevel, int strongLevel) {
		this.name = name;
		this.lifeLevel = lifeLevel;
		this.strongLevel = strongLevel;
		this.weapon = new Weapon("Epée", 50);
		this.shield = "Ecu";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLifeLevel() {
		return lifeLevel;
	}

	public void setLifeLevel(int lifeLevel) {
		this.lifeLevel = lifeLevel;
	}

	public int getStrongLevel() {
		return strongLevel;
	}

	public void setStrongLevel(int strongLevel) {
		this.strongLevel = strongLevel;
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

	@Override
	public String toString() {
		String output = "";
		output += "Nom du guerrier : " + name + "\n";
		output += "-----------------------\n";
		output += "\n";
		output += "niveau de vie : " + lifeLevel + "\n";
		output += "niveau d'atttaque : " + strongLevel + "\n";
		output += "-----------------------------------------\n";
		return output;
	}
}
