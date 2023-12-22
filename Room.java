public class Room {
    //instance variables
    private String name;
    private String description;

    private Room toEast;
    private Room toWest;
    private Room toNorth;
    private Room toSouth;

    //constructor
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //set each room's directions
    public void setRooms(Room toNorth, Room toSouth, Room toEast, Room toWest) {
        this.toNorth = toNorth;
        this.toSouth = toSouth;
        this.toEast = toEast;
        this.toWest = toWest;
    }

    //access name
    public String getName() {
        return name;
    }
    // access room description
    public String getDescription() {
        return description;
    }
    //north
    public Room getToNorth() {
        return toNorth;
    }
    //south
    public Room getToSouth() {
        return toSouth;
    }
    //east
    public Room getToEast() {
        return toEast;
    }
    //west
    public Room getToWest() {
        return toWest;
    }
}