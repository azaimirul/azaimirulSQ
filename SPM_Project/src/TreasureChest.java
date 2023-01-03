import java.util.ArrayList;
import java.util.List;

// represents a treasure chest that can be opened by the player
public class TreasureChest extends Entity {
    private List<Item> contents;

    public TreasureChest() {
        // fill the chest with random items
        this.contents = new ArrayList<>();
        int numItems = (int) (Math.random() * 5) + 1;
        for (int i = 0; i < numItems; i++) {
            Item item = new Item();
            item.setName("Item " + (i + 1));
            item.setValue((int) (Math.random() * 100) + 1);
            contents.add(item);
        }
    }

    public List<Item> getContents() {
        return contents;
    }

    public void setContents(List<Item> contents) {
        this.contents = contents;
    }
}