import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Game game = new Game();
        Player player = game.getPlayer();
      
        // set up the game map
        game.setUpMap();
      
        System.out.println("Welcome to the adventure game!");
        System.out.println("Enter your name: ");
        player.setName(Input.getStringInput());
        System.out.println("Hello, " + player.getName() + "! Your journey begins now.");
      
        // main game loop
        while (true) {
          // print the player's current position and the entities on adjacent tiles
          game.printMap();
          System.out.println("What do you want to do?");
          System.out.println("1. Move");
          System.out.println("2. Open inventory");
          int choice = Input.getIntInput();
          if (choice == 1) {
            System.out.println("Which direction do you want to move?");
            System.out.println("1. North");
            System.out.println("2. East");
            System.out.println("3. South");
            System.out.println("4. West");
            int direction = Input.getIntInput();
            if (direction == 1) {
              game.movePlayer(Direction.NORTH);
            } else if (direction == 2) {
              game.movePlayer(Direction.EAST);
            } else if (direction == 3) {
              game.movePlayer(Direction.SOUTH);
            } else if (direction == 4) {
                game.movePlayer(Direction.WEST);
              }
            } else if (choice == 2) {
              // open the player's inventory
              System.out.println("Inventory:");
              List<Item> inventory = player.getInventory();
              for (int i = 0; i < inventory.size(); i++) {
                Item item = inventory.get(i);
                System.out.println((i + 1) + ". " + item.getName() + " (" + item.getValue() + " gold)");
              }
              System.out.println("What do you want to do with your inventory?");
              System.out.println("1. Use item");
              System.out.println("2. Drop item");
              System.out.println("3. Go back");
              int inventoryChoice = Input.getIntInput();
              if (inventoryChoice == 1) {
                System.out.println("Which item do you want to use?");
                int itemIndex = Input.getIntInput() - 1;
                if (itemIndex >= 0 && itemIndex < inventory.size()) {
                  Item item = inventory.get(itemIndex);
                  // use the item
                  player.removeItem(item);
                  System.out.println("You used the " + item.getName() + ".");
                } else {
                  System.out.println("Invalid item index.");
                }
                else if (inventoryChoice == 2) {
                    System.out.println("Which item do you want to drop?");
                    int itemIndex = Input.getIntInput() - 1;
                    if (itemIndex >= 0 && itemIndex < inventory.size()) {
                      Item item = inventory.get(itemIndex);
                      // drop the item
                      player.removeItem(item);
                      game.getMap()[player.getX()][player.getY()].setEntity(item);
                      System.out.println("You dropped the " + item.getName() + ".");
                    } else {
                      System.out.println("Invalid item index.");
                    }                
                }
             
              }
            }
        }
}
