package characters;

import stuffs.Spell;

public class Magicien extends Character {
	private Spell spell;
	private String filter;

	public Magicien() {
		this(null);
	}
	
	public Magicien(String name) {
		this(name, 3, 8);
	}
	
	public Magicien(String name, int lifeLevel, int strongLevel) {
		super(name, lifeLevel, strongLevel);
		this.spell = null;
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
