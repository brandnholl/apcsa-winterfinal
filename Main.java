import java.util.Scanner;

public class Main {
    private static String askUser = "";
    private static int playerDir = 0;
    private static int playGame = 1;
    private static Room currentRoom;
    private static Item[] inventory = new Item[4];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Treasure Hunt Game!");
        System.out.println("Would you like to play? (yes/no)");
        askUser = scanner.nextLine();
        if (askUser.equalsIgnoreCase("yes")) {
            initializeGame();
            mainLoop();
        } else if (askUser.equalsIgnoreCase("no")) {
            System.out.println("Alright, have a nice day!");
        } else {
            System.out.println("Invalid choice. Please enter 'yes' to play or 'no' to exit.");
        }
    }

    private static void userInputs() {
        askUser = scanner.nextLine();

        // Handle user input based on game logic
        if (askUser.equalsIgnoreCase("turn left")) {
            playerDir = (playerDir - 1 + 4) % 4;
            System.out.println(currentRoom.getView(playerDir));
        } else if (askUser.equalsIgnoreCase("turn right")) {
            playerDir = (playerDir + 1) % 4;
            System.out.println(currentRoom.getView(playerDir));
        } else if (askUser.equalsIgnoreCase("take")) {
            // Handle taking items logic
            Item[] itemsInRoom = currentRoom.getItems();
            for (Item item : itemsInRoom) {
                inventory[playerDir] = item;
                currentRoom.removeItem(item);
                System.out.println("\nYou obtained a ");
            }
        } else if (askUser.equalsIgnoreCase("move")) {
            // Handle moving logic
            // (You need to implement the logic for moving between rooms)
        } else if (askUser.equalsIgnoreCase("inventory")) {
            // Handle displaying inventory logic
            for (Item item : inventory) {
                if (item != null) {
                    System.out.println(item);
                }
            }
        } else if (askUser.equalsIgnoreCase("help")) {
            // Handle displaying help logic
            System.out.println("Commands:\nturn left\nturn right\ntake\nmove\ninventory\n");
        }
    }

    private static void initializeGame() {
        // Initialize the game with rooms and items
        Item torch = new Item("Torch", "A brightly lit torch", false);
        Item key = new Item("Key", "A rusty old key", false);
        Item artifact = new Item("Artifact", "A mystical golden artifact", false);

        Room outsideTemple = new Room(new String[]{"view1", "view2", "view3", "view4"}, new Item[]{torch});
        Room hallway = new Room(new String[]{"view1", "view2", "view3", "view4"}, new Item[]{});
        Room chamber = new Room(new String[]{"view1", "view2", "view3", "view4"}, new Item[]{key});
        Room treasureRoom = new Room(new String[]{"view1", "view2", "view3", "view4"}, new Item[]{artifact});

        // Set starting room
        currentRoom = outsideTemple;
    }

    private static void mainLoop() {
        while (playGame == 1) {
            System.out.println("\nWhat would you like to do?\n(Type 'help' for commands)\n");
            userInputs();
        }

        System.out.println("\nThanks for playing!");
    }
}