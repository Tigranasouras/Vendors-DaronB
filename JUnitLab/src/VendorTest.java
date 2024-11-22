/*Daron Baltazar
 * 11/7/24
 * Backend File for running tests
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;


public class VendorTest{
    @Test
    void addMoneyTest(){
    Vending bob = new Vending(5, 3);
    bob.addMoney(5);
    assertEquals(5, bob.getBalance(), "Can add Money to vending.");
    }

    @Test
    void buyItemTest(){
        Vending bob = new Vending(5, 3);
        bob.addMoney(1.25);
        bob.select("Candy");
        assertEquals(0,bob.getBalance(), "Bob Bought 1 candy");
    }

    @Test
    void emptyVendorInventoryTest() {
        Vending bob = new Vending(1, 0);
        bob.emptyInventory();

        assertEquals(0, bob.getInventory().get("Candy"), "Candy stock should be 0 after emptying.");
        assertEquals(0, bob.getInventory().get("Gum"), "Gum stock should be 0 after emptying.");
    }

    @Test
    void restockItemTest() {
        Vending bob = new Vending(5, 3);
        bob.restockItem("Candy", 10, 1.75);
        bob.restockItem("Gum", 5, 0.5);

        assertEquals(15, bob.getInventory().get("Candy"), "Candy = 15 after restocking.");
        assertEquals(8, bob.getInventory().get("Gum"), "Gum = 8 after restocking.");
    }


    @Test
    void dynamicRestockTest() {
        Vending bob = new Vending(5, 3);

        bob.restockItem("Candy", 10, 1.25);
        assertEquals(15, bob.getInventory().get("Candy"), "Candy should have 15 items after restocking.");

        bob.restockItem("Chips", 20, 1.75);
        assertEquals(20, bob.getInventory().get("Chips"), "Chips should have 20 items after adding to inventory.");

        assertEquals(1.75, bob.getInventory().containsKey("Chips") ? 1.75 : -1, "Chips should have a price of 1.75.");
    }



}
