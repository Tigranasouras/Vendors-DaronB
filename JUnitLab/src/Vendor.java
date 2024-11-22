import java.util.HashMap;


//• As a User, I would like to restock items on a vendor so players can buy from him later. (Done)
//• As a User, I would like items added to the vendor’s inventory when restocking if they were unavailable so that the Vendor’s inventory can change over time.
//As a User, I would like to change the Name of an item at a vendor, so it is easy to manage the vendor-available items.
//• As a User, I would like for the vendor system to manage and print the inventory of 5 different vendors so that I can have multiple vendors available.
//As a User, I would like to remove an item from the vendor’s inventory if it is discontinued or no longer available.
//As a User, I would like the vendor system to track customer purchases for each item, providing insights on popular items and trends.
//As a User, I would like to check an item’s description or details before purchasing, so I can make informed choices on item benefits and uses.
//As a User, I would like to apply discounts to specific items or categories within the vendor’s inventory, allowing for seasonal sales or promotions.
// As a User, I would like for certain items to be marked as ”bestsellers” in the vendor’s inventory, enabling quicker access to commonly purchased items.

/**
 * Class for a Vending Machine.  Contains a hashtable mapping item names to item data, as
 * well as the current balance of money that has been deposited into the machine.
 */
class Vending {
    private static HashMap<String, Item> Stock = new HashMap<String,Item>();
    private double balance;

    Vending(int numCandy, int numGum) {
        Stock.put("Candy", new Item(1.25, numCandy));
        Stock.put("Gum", new Item(.5, numGum));
        this.balance = 0;
    }

    /** resets the Balance to 0 */
    void resetBalance () {
        this.balance = 0;
    }

    /** returns the current balance */
    double getBalance () {
        return this.balance;
    }

    /** adds money to the machine's balance
     * @param amt how much money to add
     * */
    void addMoney (double amt) {
        this.balance = this.balance + amt;
    }

    /** attempt to purchase named item.  Message returned if
     * the balance isn't sufficient to cover the item cost.
     *
     * @param name The name of the item to purchase ("Candy" or "Gum")
     */
    void select (String name) {
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
            if (balance >= item.price) {
                item.purchase(1);
                this.balance = this.balance - item.price;
            }
            else
                System.out.println("Gimme more money");
        }
        else System.out.println("Sorry, don't know that item");
    }


    /** Gets a copy of the current inventory */
    HashMap<String, Integer> getInventory() {
        HashMap<String, Integer> inventory = new HashMap<>();
        for (String name : Stock.keySet()) {
            inventory.put(name, Stock.get(name).stock);
        }
        return inventory;
    }

    /** Empties the inventory */
    void emptyInventory() {
        for (String name : Stock.keySet()) {
            Stock.get(name).stock = 0;
        }
    }
    void restockItem(String name, int amount, double price) {
        if (Stock.containsKey(name)) {
            Stock.get(name).restock(amount);
            System.out.println(name + " restocked by " + amount + " amount.");
        } else {
            Stock.put(name, new Item(price, amount));
            System.out.println("Item has now been restocked: " + name);
        }
    }




}