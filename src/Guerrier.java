
public class Guerrier {
	private String name;
	private int lifeLevel;
	private int strongLevel;
	private String weapon;
	private String shield;
	
	private int RandNum() {
		Double j = 5 + Math.random()*5;
		return j.intValue();
	}
	
	public Guerrier() {
		this.name = null;
		this.lifeLevel = RandNum();
		this.strongLevel = RandNum();
		this.weapon = "Epée";
		this.shield = "Ecu";
	}
	
	public Guerrier(String name) {
		this.name = name;
		this.lifeLevel = RandNum();
		this.strongLevel = RandNum();
		this.weapon = "Epée";
		this.shield = "Ecu";
	}
	
	public Guerrier(String name, int lifeLevel, int strongLevel) {
		this.name = name;
		this.lifeLevel = lifeLevel;
		this.strongLevel = strongLevel;
		this.weapon = "Epée";
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

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
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
		return "Guerrier [name=" + name + ", lifeLevel=" + lifeLevel + ", strongLevel=" + strongLevel + ", weapon="
				+ weapon + ", shield=" + shield + "]";
	}
}
