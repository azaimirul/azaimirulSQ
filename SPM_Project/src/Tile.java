// represents a tile on the game map
public class Tile {
    private Entity entity;

    public Tile() {
        this.entity = null;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}
