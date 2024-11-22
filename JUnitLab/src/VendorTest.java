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

        HashMap<String, Integer> inventory = bob.getInventory(); // Get the inventory after emptying


        assertEquals(0, inventory.get("Candy"), "Candy stock should be 0 after emptying.");
        assertEquals(0, inventory.get("Gum"), "Gum stock should be 0 after emptying.");
    }


}
