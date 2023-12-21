public class Item {
    private String itemName;
    private String itemDescription;

    private Boolean hasItem;

    public Item(String itemName, String itemDescription, Boolean hasItem) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.hasItem = hasItem;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public Boolean getItemStatus() {
        return hasItem;
    }
}
