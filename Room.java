class Room {
    private String[] views;
    private Item[] items;

    public Room(String[] views, Item[] items) {
        this.views = views;
        this.items = items;
    }

    public String getView(int direction) {
        return views[direction];
    }

    public Item[] getItems() {
        return items;
    }

    public void removeItem(Item item) {
        // Remove the item from the room
    }
}