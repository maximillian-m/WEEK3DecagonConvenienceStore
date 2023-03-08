import org.SuperStore.Models.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ProductTest {

    private Product unitTest;

    @BeforeEach
    void setUp() {
        unitTest = new Product("rice","food", 50000.0, 6);
    }
    @Test
    void toCheckNameOfProduct(){
        String name = unitTest.getName();
        assertEquals("rice", name);

    }@Test
    void toCheckQuantityOfProduct(){
       int qty = unitTest.getQuantity();
        assertEquals(6, qty);

    }@Test
    void toCheckIfNotPriceOfProduct(){
        double price = unitTest.getPrice();
        assertNotEquals(70000.0, price);
    } @Test
    void toCheckIfNotNameOfProduct(){
        String name = unitTest.getName();
        assertNotEquals("noodles", name);

    }@Test
    void toCheckIfNotQuantityOfProduct(){
       int qty = unitTest.getQuantity();
        assertNotEquals(10, qty);

    }@Test
    void toCheckPriceOfProduct(){
        double price = unitTest.getPrice();
        assertEquals(50000.0, price);
    }
    @Test
    void toSetQuantity(){
         unitTest.setQuantity(50);
        assertEquals(50, unitTest.getQuantity());

    }@Test
    void toSetPrice(){
         unitTest.setPrice(500.0);
        assertEquals(500.0, unitTest.getPrice());
    }@Test
    void toSetName(){
        unitTest.setName("beans");
        assertEquals("beans",unitTest.getName());
    }

}
