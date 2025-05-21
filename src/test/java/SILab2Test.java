import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SILab2Test {
    @Test
    public void testAllItemsNull() {
        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(null, "1234567812345678")
        );
        assertEquals("allItems list can't be null!", ex.getMessage());
    }

    @Test
    public void testEmptyItemName() {
        List<Item> items = List.of(new Item("", 1, 100, 0));
        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(items, "1234567812345678")
        );
        assertEquals("Invalid item!", ex.getMessage());
    }

    @Test
    public void testInvalidCardCharacter() {
        List<Item> items = List.of(new Item("Banana", 1, 100, 0));
        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(items, "1234abcd12345678")
        );
        assertEquals("Invalid character in card number!", ex.getMessage());
    }

    @Test
    public void testInvalidCardLength() {
        List<Item> items = List.of(new Item("Orange", 1, 100, 0));
        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(items, "12345678")
        );
        assertEquals("Invalid card number!", ex.getMessage());
    }

    @Test
    public void testHighPriceDiscountAndQuantity() {
        List<Item> items = List.of(new Item("Apple", 11, 400, 0.1));
        double result = SILab2.checkCart(items, "1234567812345678");
        // Calculation: -30 + 400 * (1 - 0.1) * 11 = -30 + 3960 = 3930
        assertEquals(3930.0, result);
    }

    @Test
    public void testNormalItemNoDiscount() {
        List<Item> items = List.of(new Item("Mango", 2, 100, 0));
        double result = SILab2.checkCart(items, "1234567812345678");
        // sum = 100 * 2 = 200 (no discount, no penalty)
        assertEquals(200.0, result);
    }

    @Test
    public void testNormalItemWithDiscount() {
        List<Item> items = List.of(new Item("Peach", 2, 150, 0.2));
        double result = SILab2.checkCart(items, "1234567812345678");
        // -30 + 150 * (1 - 0.2) * 2 = -30 + 240 = 210
        assertEquals(210.0, result);
    }


    private final String validCard = "1234567812345678";

    // TC1: A=false, B=false, C=false
    @Test
    public void test_TC1() {
        Item item = new Item("Item1", 5, 100, 0); // A=false, B=false, C=false
        double result = SILab2.checkCart(List.of(item), validCard);
        assertEquals(500.0, result); // 100 * 5
    }

    // TC2: A=true, B=false, C=false
    @Test
    public void test_TC2() {
        Item item = new Item("Item2", 5, 350, 0); // A=true
        double result = SILab2.checkCart(List.of(item), validCard);
        // -30 + 350 * 5 = 1720
        assertEquals(1720.0, result);
    }

    // TC3: A=false, B=true, C=false
    @Test
    public void test_TC3() {
        Item item = new Item("Item3", 5, 100, 0.1); // B=true
        double result = SILab2.checkCart(List.of(item), validCard);
        // -30 + 100*0.9*5 = -30 + 450 = 420
        assertEquals(420.0, result);
    }

    // TC4: A=false, B=false, C=true
    @Test
    public void test_TC4() {
        Item item = new Item("Item4", 11, 100, 0); // C=true
        double result = SILab2.checkCart(List.of(item), validCard);
        // -30 + 100 * 11 = 1070
        assertEquals(1070.0, result);
    }

    // TC5: A=true, B=true, C=false
    @Test
    public void test_TC5() {
        Item item = new Item("Item5", 5, 400, 0.2); // A & B = true
        double result = SILab2.checkCart(List.of(item), validCard);
        // -30 + 400*0.8*5 = -30 + 1600 = 1570
        assertEquals(1570.0, result);
    }

    // TC6: A=true, B=false, C=true
    @Test
    public void test_TC6() {
        Item item = new Item("Item6", 11, 400, 0); // A & C = true
        double result = SILab2.checkCart(List.of(item), validCard);
        // -30 + 400*11 = 4370
        assertEquals(4370.0, result);
    }

    // TC7: A=false, B=true, C=true
    @Test
    public void test_TC7() {
        Item item = new Item("Item7", 11, 200, 0.1); // B & C = true
        double result = SILab2.checkCart(List.of(item), validCard);
        // -30 + 200*0.9*11 = -30 + 1980 = 1950
        assertEquals(1950.0, result);
    }

    // TC8: A=true, B=true, C=true
    @Test
    public void test_TC8() {
        Item item = new Item("Item8", 11, 400, 0.1); // A, B, C = true
        double result = SILab2.checkCart(List.of(item), validCard);
        // -30 + 400*0.9*11 = -30 + 3960 = 3930
        assertEquals(3930.0, result);
    }
}
