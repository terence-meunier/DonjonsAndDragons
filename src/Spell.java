
public class Spell {
	private String name;
	private int atqLevel;
	
	public Spell(String name, int atqLevel) {
		this.name = name;
		this.atqLevel = atqLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAtqLevel() {
		return atqLevel;
	}

	public void setAtqLevel(int atqLevel) {
		this.atqLevel = atqLevel;
	}

	@Override
	public String toString() {
		return "Weapon [name=" + name + ", atqLevel=" + atqLevel + "]";
	}
	
}
