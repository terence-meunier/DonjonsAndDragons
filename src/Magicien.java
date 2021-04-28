
public class Magicien {
	private String name;
	private int lifeLevel;
	private int strongLevel;
	private Spell spell;
	private String filter;
	
	private int RandNum() {
		Double j = 5 + Math.random()*5;
		return j.intValue();
	}
	
	public Magicien() {
		this.name = null;
		this.lifeLevel = RandNum();
		this.strongLevel = RandNum();
		this.spell = new Spell("Eclair", 40);
		this.filter = "Soin";
	}
	
	public Magicien(String name) {
		this.name = name;
		this.lifeLevel = RandNum();
		this.strongLevel = RandNum();
		this.spell = new Spell("Eclair", 40);
		this.filter = "Soin";
	}
	
	public Magicien(String name, int lifeLevel, int strongLevel) {
		this.name = name;
		this.lifeLevel = lifeLevel;
		this.strongLevel = strongLevel;
		this.spell = new Spell("Eclair", 40);
		this.filter = "Soin";
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

	public Spell getSpell() {
		return spell;
	}

	public void setSpell(Spell spell) {
		this.spell = spell;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	@Override
	public String toString() {
		return "Magicien [name=" + name + ", lifeLevel=" + lifeLevel + ", strongLevel=" + strongLevel + ", spell="
				+ spell + ", filter=" + filter + "]";
	}
	
}