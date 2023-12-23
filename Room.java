public class Room {
    //instance variables
    private String name;

    private String[] views;

    //constructor
    public Room(String name, String[] views) {
        this.name = name;
        this.views = views;
    }

    //set each room's directions
    public void setViews(String[] views) {
        this.views = views;
    }
}