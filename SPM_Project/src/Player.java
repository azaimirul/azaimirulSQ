import java.util.ArrayList;
import java.util.List;

// represents the player character
public class Player extends Character {
    private String name;
    private int experience;
    private int level;
    private List<Item> inventory;

    public Player() {
        // set default values for the player's stats
        this.name = "Player";
        this.health = 100;
        this.maxHealth = 100;
        this.attack = 10;
        this.defense = 5;
        this.experience = 0;
        this.level = 1;
        this.inventory = new ArrayList<>();
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int attack() {
        // player's attack is based on their level and attack stat
        return level * attack;
    }

    public void addExperience(int experience) {
        this.experience += experience;
        // level up if the player has enough experience
        int requiredExperience = level * 1000;
        if (this.experience >= requiredExperience) {
            this.experience -= requiredExperience;
            level++;
            maxHealth += 10;
            health = maxHealth;
            attack += 2;
            defense += 1;
            System.out.println("You have reached level " + level + "!");
            System.out.println("Your health has increased to " + maxHealth + ".");
            System.out.println("Your attack has increased to " + attack + ".");
            System.out.println("Your defense has increased to " + defense + ".");
        }
    }
}