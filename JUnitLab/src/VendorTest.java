/*Daron Baltazar
 * 11/7/24
 * Backend File for running tests
 */
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VendorTest{
    @Test
    void addMoneyTest(){
    Vending bob = new Vending(5, 3);
    bob.addMoney(5);
    assertEquals(5, bob.getBalance(), "Can add Money to vending.");
    }

    @Test
    void buyItemTest(){

    }

    @Test
    void emptyVendorInventoryTest(){

    }


}
