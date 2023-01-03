// represents an item that can be picked up by the player
public class Item extends Entity {
    private String name;
    private int value;

    public Item() {
        // set default values for the item
        this.name = "Item";
        this.value = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}