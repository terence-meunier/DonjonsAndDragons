package stuffs;

public class Weapon extends Stuff {
	private int atqLevel;
	
	public Weapon(String name, int atqLevel) {
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
		return super.toString() + " atq : " + atqLevel;
	}
}
