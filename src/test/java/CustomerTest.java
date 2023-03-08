import org.SuperStore.Models.Customer;
import org.SuperStore.Models.Product;
import org.SuperStore.Models.ReadProductList;
import org.SuperStore.Services.ServiceImpl.CustomerServImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerTest {
    private Customer unitTest;
    private CustomerServImpl customerServ;
    private Product cart;
    private Product cart1;
    private Product cart2;
    private ReadProductList productList;
    private List<Product> list = new ArrayList<>();

    @BeforeEach
    void setUp() {
        productList = new ReadProductList();
        productList.readListOfFromFile("/Users/decagon/IdeaProjects/Week2Convenience/src/main/resources/utils/ListOfProducts.xlsx");
        unitTest = new Customer("Frank", 45000.0,productList);
        customerServ = new CustomerServImpl(unitTest);
        cart = new Product("bean", "food", 200, 8);
        cart1 = new Product("rice", "food", 50.0, 4);
        cart2 = new Product("garri", "food",  30.0, 5);
        list.add(cart);
        list.add(cart1);
        list.add(cart2);
    }

    @Test
    void toCheckTheWallet() {
        double wallet = unitTest.getWallet();
        assertEquals(45000.0, wallet);


    }@Test
    void toCheckAddedProduct() {
        unitTest.addToCart("Rice", 2);
        String b = customerServ.getCart().get(0).getName();
        assertEquals(b, "Rice");
    }

    @Test
    void toCheckProductNotAdded() {
        unitTest.addToCart("chocolate", 2);
        boolean b = customerServ.getCart().isEmpty();
        assertTrue(b);
    }


    @Test
    void toSetWallet() {
       unitTest.setWallet(1000.0);
       double a = customerServ.getWallet();
       assertEquals(1000.0, a);
        }

}
