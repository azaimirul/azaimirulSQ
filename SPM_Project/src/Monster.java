// represents a monster in the game
public class Monster extends Character {
    private String name;
    private int experience;

    public Monster() {
        // set default values for the monster's stats
        this.name = "Monster";
        this.health = 100;
        this.maxHealth = 100;
        this.attack = 10;
        this.defense = 5;
        this.experience = 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public int attack() {
        // monster's attack is based on their attack stat
        return attack;
    }
}