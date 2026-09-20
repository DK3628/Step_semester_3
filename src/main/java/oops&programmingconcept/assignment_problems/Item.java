public class Item {
    String itemName;
    int stock;

    public Item(String itemName, int stock) {
        this.itemName = itemName;
        this.stock = stock;
    }

    public void restock(int stock) {
        this.stock += stock;
    }

    public static void main(String[] args) {
        Item[] inventory = {
            new Item("Samosa", 15),
            new Item("Tea Powder", 40),
            new Item("Bread", 8),
            new Item("Biscuit Packs", 25)
        };

        for (int i = 0; i < inventory.length; i++) {
            inventory[i].restock(20);
            System.out.println(inventory[i].itemName + " | Final Stock: " + inventory[i].stock);
        }
    }
}