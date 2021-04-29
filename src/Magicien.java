
public class Magicien extends Character {
	private String name;
	private int lifeLevel;
	private int strongLevel;
	private Spell spell;
	private String filter;
	
	private static int RandNum() {
		Double j = 3 + Math.random()*3;
		return j.intValue();
	}
	
	public Magicien() {
		this(null);
	}
	
	public Magicien(String name) {
		this(name, RandNum(), RandNum());
	}
	
	public Magicien(String name, int lifeLevel, int strongLevel) {
		super(name, lifeLevel, strongLevel);
		this.spell = new Spell("Eclair", 40);
		this.filter = "Soin";
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

}
