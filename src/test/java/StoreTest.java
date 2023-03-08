import org.SuperStore.Models.Store;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class StoreTest {

    private Store unitTest;
    @BeforeEach
         void setUp(){
        unitTest = new Store("Kc's Shop", 10000.0);
    }
    @Test
    @Description("Checking if the actual store cash is equal to the provided")
    void itShouldReturnTheStoreCash(){
        double getCash = unitTest.getStoreCash();
        assertEquals(10000.0, getCash);
    }

    @Test
    @Description("checking if the store cash is not equal to provided")
    void itShouldCheckTheValueNotEqualsStoreCash(){
        double getCash = unitTest.getStoreCash();
        assertNotEquals(2000, getCash);
    }
    @Test
    @Description("setting value to the store cash")
    void itShouldBeAbleToSetValueForTheStoreCashPrice(){
         unitTest.setStoreCash(50000);
        assertEquals(50000, unitTest.getStoreCash());
    }
    @Test
    @Description("setting value to the store cash")
    void itShouldBeAbleToCheckIfTheStoreCashPriceIsNotEquals(){
        unitTest.setStoreCash(50000);
        assertNotEquals(500, unitTest.getStoreCash());
    }
    @Test
    void itShouldBeAbleToUpdateCashBalanceToaNewOne(){
        double fromSells = 30000.0;
        double sum = unitTest.getStoreCash() + fromSells;
        unitTest.setStoreCash(sum);
        assertEquals(40000.0, unitTest.getStoreCash());
    }@Test
    void itShouldBeAbleToNotUpdateCashBalanceToaNewOne(){
        double fromSells = 30000.0;
        double sum = unitTest.getStoreCash() + fromSells;
        unitTest.setStoreCash(sum);
        assertNotEquals(120000.0, unitTest.getStoreCash());

    }

}
