public class Item{
    //instance variables
    private String name;
    public boolean pickedUp;
    private String description;

    //constructor
    public Item(String name, boolean pickedUp, String description){
        this.name = name;
        this.pickedUp = pickedUp;
        this.description = description;
    }

    //accessor methods
    public String getName(){
        return name;
    }

    public boolean getPickedUp(){
        return pickedUp;
    }

    public String getDescription(){
        return description;
    }

    public void pickUp(){
        pickedUp = true;
    }
}