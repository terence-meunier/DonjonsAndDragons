abstract public class Character {
    private String name;
    private int lifeLevel;
    private int strongLevel;

    public Character(String name, int lifeLevel, int strongLevel) {
        this.name = name;
        this.lifeLevel = lifeLevel;
        this.strongLevel = strongLevel;
    }

    public String toString() {
        String output = "";
        output += "Nom : " + name + "\n";
        output += "-----------------------\n";
        output += "\n";
        output += "niveau de vie : " + lifeLevel + "\n";
        output += "niveau d'atttaque : " + strongLevel + "\n";
        output += "-----------------------------------------\n";
        return output;
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
}
