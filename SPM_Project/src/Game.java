import java.util.Scanner;
import java.util.Random;

public class Game {
  Scanner input = new Scanner(System.in);
  // constants for the game map size
  private static final int MAP_WIDTH = 10;
  private static final int MAP_HEIGHT = 10;

  // the player character
  private Player player;

  // the game map
  private Tile[][] map;

  // random number generator
  private Random random;

  public Game() {
    // create the player character
    player = new Player();

    // create the game map
    map = new Tile[MAP_WIDTH][MAP_HEIGHT];
    for (int x = 0; x < MAP_WIDTH; x++) {
      for (int y = 0; y < MAP_HEIGHT; y++) {
        map[x][y] = new Tile();
      }
    }

    // place the player character on the map
    map[0][0].setEntity(player);

    // create the random number generator
    random = new Random();
  }

  // move the player character to a new position on the map
  public void movePlayer(int dx, int dy) {
    // calculate the new position of the player
    int newX = player.getX() + dx;
    int newY = player.getY() + dy;

    // check if the new position is within the bounds of the map
    if (newX >= 0 && newX < MAP_WIDTH && newY >= 0 && newY < MAP_HEIGHT) {
      // check if the new position is empty
      if (map[newX][newY].getEntity() == null) {
        // move the player to the new position
        // map[player.getX()][player.getY()].setEntity(null);
        player.setPosition(newX, newY);
        map[newX][newY].setEntity(player);
      } else {
        // the new position is not empty, so interact with the entity at that position
        Entity entity = map[newX][newY].getEntity();
        /*
         * if (entity instanceof NPC) {
         * // the entity is an NPC, so talk to it
         * NPC npc = (NPC) entity;
         * System.out.println(npc.getDialogue());
         * } else if (entity instanceof Item) {
         * // the entity is an item, so pick it up
         * Item item = (Item) entity;
         * player.addItem(item);
         * map[newX][newY].setEntity(null);
         * System.out.println("You picked up a " + item.getName() + "!");
         * }
         */
      }
    } else {
      // the new position is outside the bounds of the map, so do nothing
      System.out.println("You can't go that way!");
    }
  }

  // simulate a random event
  public void triggerRandomEvent() {
    // roll a random number between 1 and 10
    int event = random.nextInt(10) + 1;
    if (event <= 2) {
      // 20% chance of encountering a monster
      Monster monster = new Monster();
      System.out.println("You encountered a " + monster.getName() + "!");
      while (monster.isAlive() && player.isAlive()) {
        // the player can choose to attack or flee
        System.out.println("What do you want to do?");
        System.out.println("1. Attack");
        System.out.println("2. Flee");
        int choice = input.nextInt();
        if (choice == 1) {
          // attack the monster
          int damage = player.attack();
          monster.takeDamage(damage);
          System.out.println("You dealt " + damage + " damage to the " + monster.getName() + "!");
          if (monster.isAlive()) {
            // the monster attacks back
            damage = monster.attack();
            player.takeDamage(damage);
            System.out.println("The " + monster.getName() + " dealt " + damage + " damage to you!");
          }
        } else if (choice == 2) {
          // attempt to flee
          if (random.nextInt(2) == 0) {
            // successful flee
            System.out.println("You fled from the " + monster.getName() + "!");
            break;
          } else {
            // unsuccessful flee
            System.out.println("You failed to flee from the " + monster.getName() + "!");
          }
        }
      }
      if (!monster.isAlive()) {
        // the player defeated the monster
        System.out.println("You defeated the " + monster.getName() + "!");
        player.addExperience(monster.getExperience());
      }
    } else if (event <= 4) {
      // 20% chance of finding a treasure chest
      TreasureChest chest = new TreasureChest();
      System.out.println("You found a treasure chest!");
      System.out.println("It contains: ");
      for (Item item : chest.getContents()) {
        System.out.println("- " + item.getName());
      }
      System.out.println("Do you want to open the chest? (y/n)");
      if (input.nextBoolean()) {
        // open the chest and add its contents to the player's inventory
        for (Item item : chest.getContents()) {
          player.addItem(item);
        }
      }
    } else {
      // 60% chance of nothing happening
      System.out.println("Nothing interesting happens.");
    }
  }
}