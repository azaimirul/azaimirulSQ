// represents a non-player character (NPC) in the game
public class NPC extends Character {
    private String name;
    private String dialogue;

    public NPC() {
        // set default values for the NPC's stats
        this.name = "NPC";
        this.health = 50;
        this.maxHealth = 50;
        this.attack = 5;
        this.defense = 3;
        this.dialogue = "Hello, I am an NPC.";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDialogue() {
        return dialogue;
    }

    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }

    @Override
    public int attack() {
        // NPC's attack is based on their attack stat
        return attack;
    }
}
