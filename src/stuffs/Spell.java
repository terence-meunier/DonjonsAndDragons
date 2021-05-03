package stuffs;

public class Spell extends Stuff {

	private int atqLevel;
	
	public Spell(String name, int atqLevel) {
		super(name);
		this.atqLevel = atqLevel;
	}

	public int getAtqLevel() {
		return atqLevel;
	}

	public void setAtqLevel(int atqLevel) {
		this.atqLevel = atqLevel;
	}

	@Override
	public String toString() {
		return super.toString() + "(atq : " + atqLevel + ")";
	}
}
