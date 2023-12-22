import java.util.Scanner;
import java.util.Random;

class Main {
    private static Room currentRoom; //currentRoom is the room the user is in at each moment
    private static String[] inventory = new String[3];

    public static void main(String[] args) {
        //scanner for user input
        Scanner input = new Scanner(System.in);

        //instantiating the items
        Item torch = new Item("Torch", false, "A brightly lit torch");
        Item rustykey = new Item("Rusty Key", false, "A rusty old key");
        Item goldenartifact = new Item("Artifact", false, "A shimmering golden artifact");


        //instantiating all rooms
        Room outsideTemple = new Room("Outside", "You are in your bedroom. There is a top drawer and a bed you can look at");
        Room hallway = new Room("Bathroom", "You are in your bathroom. There is a bathtub and a cupboard you can look at");
        Room chamber = new Room("Kitchen", "You are in your kitchen. There is a left and right cabinet you can look at");
        Room treasureRoom = new Room("Closet", "You are in your closet. There is a hamper you can look at");

        //setting rooms: has the rooms to the north, south, east, and west, and null as placeholders when there isn't a room in that direction
        bedroom.setRooms(kitchen, null, null, bathroom);;
        bathroom.setRooms(null, null, bedroom, null);
        kitchen.setRooms(null, bedroom, livingRoom, closet);


        //intro message
        System.out.println("You wake up in the middle of the night at the sound of someone breaking into your vacation home you’re staying at. You know that there is a safe in the closet locked with a weapon inside, and if you are able to get to it, you’d be guaranteed safety. You can’t call 911 because you live in the woods, and nobody else is home because they went to hike up the mountains to watch the sunrise. You’re only way out is if you are able to get to the safe and get your secret machine gun. \n \nProblem is…you don’t remember the combination to the safe. You hid different parts of the code all over your house in case this ever happened. The code consists of 3 numbers, meaning three sheets of paper.\n You keep all your valuables in one room with booby traps, and you know that the robber will be occupied there for a bit, but not for long. If you run into him before you get the gun, you will die. I’ll be your pair of eyes to warn you of any signs he’s near. Good luck!");
        //display commands with method
        commands();

        //first test of input: having them input their name
        System.out.print("What is your name?: ");
        String name = input.nextLine(); //saved as a variable
        System.out.println("Hello " + name + "!\n"); //prints a little greeting message

        //starting room is the bedroom
        currentRoom = bedroom;
        //only loops if the gun has not been picked up (game ends)
        while(!goldenartifact.pickedUp){
            System.out.println();
            //first checks if the user is in the secret room. if they are, they are confronted by the burglar and they die, and the game ends (loop breaks)

            //also prints the description of the room (what there is to look at or take)
            System.out.println(currentRoom.getDescription() + "\n");

            //prints the user's inventory
            System.out.println();
            System.out.print("Inventory: ");
            //for every item in the inventory that isn't null, print
            for (String item : inventory) {
                if (item != null) {
                    System.out.print(item + ", ");
                }
            }
            System.out.println();

            //if the user is in the safe room, they can open the safe with the right code and get the gun

            //user input of what action they want
            System.out.print("What would you like to do?: ");

            //inputDirection is the variable holding this main input
            String inputAction = input.nextLine();

            System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            //WASD controls the directions, respectively
            if (inputAction.equals("W")) {
                //each condition also checks to make sure there is a room in the direction the user wants to go. if there isn't it prints an "error message"
                if(currentRoom.getToNorth() != null){
                    currentRoom = currentRoom.getToNorth();
                }
                else{
                    System.out.println("There's nothing that way\n");
                }
            }

            else if (inputAction.equals("A")) {
                if(currentRoom.getToWest() != null){
                    currentRoom = currentRoom.getToWest();        }
                else{
                    System.out.println("There's nothing that way\n");
                }
            }

            else if (inputAction.equals("S")) {
                if(currentRoom.getToSouth() != null){
                    currentRoom = currentRoom.getToSouth();
                }
                else{
                    System.out.println("There's nothing that way\n");
                }
            }

            else if (inputAction.equals("D")) {
                if(currentRoom.getToEast() != null){
                    currentRoom = currentRoom.getToEast();
                }
                else{
                    System.out.println("There's nothing that way\n");
                }
            }
            //the method for the user to get a description of the things in the room: if they input to look around
            else if(inputAction.equals("look around")){
                System.out.println();
                //each room has a different description of the different items, and it also prints differently if the user has certain items
                if(currentRoom == bedroom){
                    //if the user has the red key, it prints that the drawer is unlocked, if they don't it prints that it is locked
                    if(redLock.pickedUp == false){
                        System.out.println("The top drawer has a red lock, there is nothing on the bed");
                    }
                    else if (redLock.pickedUp == true && card3.pickedUp == false){
                        System.out.println("There is a card inside the top drawer");
                    }
                    else{
                        System.out.println("There is nothing in the bedroom");
                    }
                }
                if(currentRoom == bathroom){
                    if(card1.pickedUp == false){
                        System.out.println("The bathtub is empty, there is a card sitting in the cupboard");
                    }
                    else{
                        System.out.println("The bathtub and the cupboard is empty");
                    }
                }
                //some rooms have no items inside
                if(currentRoom == kitchen){
                    System.out.println("There is nothing in either cabinet");
                }
                if(currentRoom == closet){
                    if(redKey.pickedUp == false){
                        System.out.println("The hamper has a red key inside");
                    }
                    else{
                        System.out.println("The hamper is empty");
                    }
                }
                if(currentRoom == garage){
                    if(carKey.pickedUp == false){
                        System.out.println("The car is locked, there is nothing on the shelf");
                    }
                    else if (card2.pickedUp == false){
                        System.out.println("There is a card on the car seat and there is nothing on the shelf");
                    }
                    else{
                        System.out.println("There is nothing interesting in the garage");
                    }
                }
                if(currentRoom == balcony){
                    if(carKey.pickedUp == false){
                        System.out.println("The bin is has your car key, there is nothing on the floor");
                    }
                    else{
                        System.out.println("The bin is empty, there is nothing on the floor");
                    }
                }
                if(currentRoom == livingRoom){
                    System.out.println("There is nothing interesting to see in the living room");
                }
            }
            //this is if the user wants to pick up an item
            if (inputAction.equals("take item")){
                //they input which item they want to take, and that is added
                System.out.print("What would you like to take?: ");
                String takeItem = input.nextLine();

                //if they want to pick up the card in the bathroom, they can input "card" while in the bathroom
                if(currentRoom == bathroom && takeItem.equals("card")){
                    System.out.println();
                    System.out.println("You picked up the card");
                    card1.pickedUp = true;
                    //prints the item description and adds it to the inventory
                    System.out.println("It says: " + card1.getDescription());
                    inventory[0] = card1.getName();
                }

                //same structure about all the other items
                if(currentRoom == closet && takeItem.equals("red key")){
                    System.out.println();
                    System.out.println("You picked up the red key");
                    redKey.pickedUp = true;
                    System.out.println(redKey.getDescription());
                    inventory[1] = redKey.getName();
                }

                if(currentRoom == garage && takeItem.equals("card")){
                    System.out.println();
                    System.out.println("You picked up the card");
                    card2.pickedUp = true;
                    System.out.println("It says: " + card2.getDescription());
                    inventory[2] = card2.getName();
                }

                if(currentRoom == balcony && takeItem.equals("car key")){
                    System.out.println();
                    System.out.println("You picked up the car key");
                    carKey.pickedUp = true;
                    System.out.println("It says: " + carKey.getDescription());
                    inventory[3] = carKey.getName();
                }

                if(currentRoom == bedroom && takeItem.equals("card")){
                    System.out.println();
                    System.out.println("You picked up the card");
                    card3.pickedUp = true;
                    System.out.println("It says: " + card3.getDescription());
                    inventory[4] = card3.getName();
                }
            }

            //if the user wants to use an item
            if(inputAction.equals("use item")){
                System.out.print("What would you like to use?: ");
                String useItem = input.nextLine();
                //if they want to use the red key, they can input "red key" while in the bedroom to unlock the red lock
                if(currentRoom == bedroom && useItem.equals("red key")){
                    redLock.pickedUp = true; //unlocks red lock
                    redKey.pickedUp = false;
                    //description as summary of what happened
                    System.out.println("You have unlocked the red lock. Look around again to see what's inside");
                }

                //same thing fpr car key and car
                if(currentRoom == garage && useItem.equals("car key")){
                    car.pickedUp = true;
                    carKey.pickedUp = false;
                    System.out.println("You have unlocked the car. Look around again to see what's inside");
                }
            }
        }
    }
    //method to print out the commands
    public static void commands(){
        System.out.println("\nUse WASD to move:  Other commands: \n W = north          take item = pick up an item  \n A = east           use item = use an item \n S = south          help = list of commands \n D = west           look around = know what's in the room \n");
    }
}