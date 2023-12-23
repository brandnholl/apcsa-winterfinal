import java.util.Scanner;

class Main {
    private static Room currentRoom; //currentRoom is the room the user is in at each moment
    private static String[] inventory = new String[3];
    private static int playerDir;
    private static String[] playerView;

    public static void main(String[] args) {
        //scanner for user input
        Scanner input = new Scanner(System.in);

        //instantiating the items
        Item torch = new Item("Torch", false, "A brightly lit torch");
        Item rustykey = new Item("Rusty Key", false, "A rusty old key");
        Item goldenartifact = new Item("Artifact", false, "A shimmering golden artifact");

        //room descriptions
        String[] templeDescription = {
                "\nYou find yourself standing in front of the entrance to the temple. The doors are made of solid bronze, depicting scenes of battle and sacrifice. The doors are framed by a series of carved pillars, each one adorned with intricate patterns and symbols. Above the doors, a stone lintel bears the inscription \"Knowledge is power.\"",
                "\nTo your right, there's a similar path, leading away from the temple in the opposite direction. There are smaller shrubs and bushes along the side of the path, and you can see a fountain off in the distance, the sound of rushing water reaching your ears.",
                "\nBehind you, the path you followed to get here stretches out, leading back the way you came.",
                "\nTo your left, you see a path winding away from the temple. The path is lined with tall trees, their branches reaching up towards the sky. You can hear the rustling of leaves in the gentle breeze."
        };

        String[] hallwayDescription = {
                "\nTo front of you at the end of a hallway, you see the entrance to a chamber. As you squint in the dimly lit hallway, you can see that this chamber is full of ancient artifacts and treasures, objects that have been lost to the world for centuries.",
                "\nTo your right, the walls are rough and unfinished, the ancient carvings largely obscured by layers of grime and dust. The ceiling is low, and you have to duck to avoid hitting your head on the rough-hewn beams. You find a lit torch hanging on a pillar.",
                "\nBehind you, the doorway that you came through stands ominously. Through the bright sunlight, you can make out the winding path through the trees and shrubs.",
                "\nTo your left, the walls are adorned with intricate carvings and frescoes depicting the gods and goddesses of the ancient civilization that built the temple. The floor is made of polished marble, and the ceiling is supported by rows of massive stone columns. A faint smell of incense hangs in the air."
        };

        String[] chamberDescription = {
                "\nIn front of you, there is a stone sarcophagus containing the remains of an ancient queen. The sarcophagus is adorned with intricate carvings and inlaid with precious gems. Above the sarcophagus is an intricate design with a key-like hole.",
                "\nTo your right, there is a glass display case containing a collection of ancient coins. The coins are made of gold and silver, and each one is adorned with the image of a different god or goddess. The coins look extremely valuable.",
                "\nBehind you, you can see the dimly lit hallway in which you entered. Through the shadows, you can make out some of the inscriptions on the wall.",
                "\nTo your left, there is a stone pedestal containing a golden goblet encrusted with diamonds. The goblet is said to have belonged to an ancient king, and it is said to bring good fortune to whoever possesses it. Sandwiched in between them is a rusty bronze key."
        };

        String[] treasureroomDescription = {
                "\nIn front of you, there is a golden chalice sitting on a pedestal in the center of the room. The chalice is made of pure gold, and it is adorned with diamonds and other precious gems. You can see your reflection in the gleaming surface of the chalice. This is the artifact you have spent your life searching for.",
                "\nTo your right, there is a row of stone pillars supporting the ceiling. Each pillar is adorned with intricate carvings and patterns.",
                "\nBehind you, there is a row of stone benches, each one carved with intricate patterns. The benches are meant for the priests and other officials who perform the rituals in this room.",
                "\nTo your left, there is a stone altar adorned with intricate carvings and inlaid with precious gems. A pair of tall candles burn on either side of the altar, casting a warm glow throughout the room."
        };
        //instantiating all rooms
        Room outsideTemple = new Room("Outside", templeDescription);
        Room hallway = new Room("Hallway", hallwayDescription);
        Room chamber = new Room("Chamber", chamberDescription);
        Room treasureRoom = new Room("Treasure Room", treasureroomDescription);

        playerView = templeDescription;

        //intro message
        System.out.println("In this game, you play as a treasure hunter on a mission to find a valuable artifact that has been lost for centuries. As you explore the temple, you encounter a variety of objects and clues that help you on your quest.");
        commands();
        currentRoom = outsideTemple;
        while (!goldenartifact.pickedUp) {

            System.out.println();
            System.out.println(playerView[playerDir]);
            String askUser = input.nextLine();

            if (askUser.equals("turn left")) {
                playerDir = playerDir - 1;
                if (playerDir < 0) {
                    playerDir = 3;
                }
                System.out.println(playerView[playerDir]);
            } else if (askUser.equals("turn right")) {
                playerDir = playerDir + 1;
                if (playerDir > 3) {
                    playerDir = 0;
                }
                System.out.println(playerView[playerDir]);
            } else if (askUser.equals("turn around")) {
                playerDir = playerDir + 2;
                if (playerDir > 3) {
                    playerDir = playerDir - 4;
                }
                System.out.println(playerView[playerDir]);
            }

            // take logic
            else if (askUser.equals("take")) {
                if (playerView[playerDir].equals(hallwayDescription[1])) {
                    if (!torch.pickedUp) {
                        torch.pickUp();
                        inventory[1] = "Torch\n";
                        System.out.println("\nYou obtained a torch");
                    }
                }
                if (playerView[playerDir].equals(chamberDescription[3])) {
                    if (!rustykey.pickedUp) {
                        rustykey.pickUp();
                        inventory[1] = "Key\n";
                        System.out.println("\nYou obtained a key");
                    }
                }
            }
            //move logic
            if (askUser.equals("move")) {
                if (playerView[playerDir].equals(templeDescription[0])) {
                    playerView = hallwayDescription;
                    System.out.println(playerView[playerDir]);
                } else if (playerView[playerDir].equals(hallwayDescription[0]) && torch.pickedUp) {
                    playerView = chamberDescription;
                    System.out.println(playerView[playerDir]);
                } else if (playerView[playerDir].equals(hallwayDescription[0]) && !torch.pickedUp) {
                    System.out.println("The room ahead looks a little dark, see if you can find something that will help you see a little better.");
                } else if (playerView[playerDir].equals(chamberDescription[0]) && rustykey.pickedUp) {
                    playerView = treasureroomDescription;
                    System.out.println(playerView[playerDir]);
                    goldenartifact.pickUp();
                } else if (playerView[playerDir].equals(chamberDescription[0]) && !rustykey.pickedUp) {
                    System.out.println("You can't seem to find a way out of this room. Maybe you can find a key that will fit in the hole somewhere in the room");
                }
            }
            // misc logic
            else if (askUser.equals("inventory")) {
                System.out.println(inventory[0] + inventory[1] + inventory[2]);
            }
        }
        System.out.println("\nThanks for playing!");
    }

    public static void commands() {
        System.out.println("\nCommands:\nturn left\nturn right\nturn around\nmove\ntake\ninventory\n");
    }
}