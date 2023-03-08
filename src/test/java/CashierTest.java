import org.SuperStore.Exceptions.CheckOutException;
import org.SuperStore.Exceptions.CreteriaException;
import org.SuperStore.Exceptions.SellProductException;
import org.SuperStore.Models.*;
import org.SuperStore.Services.ServiceImpl.CustomerServImpl;
import org.SuperStore.Services.ServiceImpl.cashierServImplm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CashierTest {
    private Customer unitTest;
    private Customer unitTest2;
    private org.SuperStore.Services.ServiceImpl.cashierServImplm cashierServImplm;
    private Cashier cashier;
    private CustomerServImpl customerServ;
    private ReadProductList productList;
    private Store store;
    private List<Product> list = new ArrayList<>();

    @BeforeEach
    void setUp() throws SellProductException, CreteriaException, CheckOutException {
        productList = new ReadProductList();
        productList.readListOfFromFile("/Users/decagon/IdeaProjects/Week2Convenience/src/main/resources/utils/ListOfProducts.xlsx");
        unitTest = new Customer("Frank", 445000.0, productList);
        unitTest2 = new Customer("Wendy", 50000, productList);
        customerServ = new CustomerServImpl(unitTest);
        cashierServImplm = new cashierServImplm(productList);
        unitTest2.addToCart("Nike", 2);
       cashier = new Cashier("Wendy", cashierServImplm);
        try {
            cashier.customerCheck(unitTest2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public int checker() {
        int i = 0;
        for (Product r : productList.getProducts()) {
            if (r.getName().equals("Rice")) {
                i += r.getQuantity();
            }
        }
        return i;
    }

    @Test
    void ToGetCustomerCheck() throws SellProductException, CreteriaException, CheckOutException, InterruptedException {
        customerServ.addToCart("Rice", 3);
        cashier.customerCheck(unitTest);
        double b = cashierServImplm.getCustomerCheck();
        boolean a = b > 0.0;
        assertTrue(a);
    }

    @Test
    void ToCheckIfNotCustomerCheck() throws SellProductException, CreteriaException, CheckOutException, InterruptedException{
        customerServ.addToCart("Rice", 3);
        cashier.customerCheck(unitTest);
        double b = cashierServImplm.getCustomerCheck();
        boolean a = b < 0.0;
        assertFalse(a);
    }

    @Test
    void ToCheckForReducingQuantity() throws SellProductException, CreteriaException, CheckOutException, InterruptedException{
        customerServ.addToCart("Rice", 3);
        int a = checker();
        cashier.customerCheck(unitTest);
        int b = checker();
        boolean c = (a == b);
        assertFalse(c);


    }  @Test
    void ToCheckCustomerCartEmpty() throws SellProductException, CreteriaException, CheckOutException, InterruptedException {
        customerServ.addToCart("Rice", 3);
        cashier.customerCheck(unitTest);
        boolean b = unitTest.getCart().isEmpty();
        assertTrue(b);

    }@Test
    void ToCheckForFIFO() throws CreteriaException{
        unitTest.addToCart("pencils", 12);
        cashier.addToCustomerList(unitTest);
        cashier.addToCustomerList(unitTest2);
       String a= cashier.getCustomerList().peek().getName();
       assertEquals("Frank", a);
    }@Test
    void ToCheckUsingPriorityQueue() throws CheckOutException, SellProductException, CreteriaException {
        unitTest.addToCart("pencils", 12);
        cashier.addToCustomerList(unitTest);
        cashier.addToCustomerList(unitTest2);
        cashier.checkOutMethod(false);
        boolean a = cashier.isCheckPriority();
        assertTrue(a);
    }
}