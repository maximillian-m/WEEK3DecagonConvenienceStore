import org.SuperStore.Exceptions.CreteriaException;
import org.SuperStore.Models.*;
import org.SuperStore.Services.ServiceImpl.ManagerImpl;
import org.SuperStore.Services.ServiceImpl.cashierServImplm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    public Manager manager;
    public Store store;
    public ManagerImpl managerI;
    public Applicants applicants1;
    public Applicants applicants2;
    public Cashier cashier;
    public cashierServImplm cashierServImplm;
    public ReadProductList readProductList;



    @BeforeEach
    void setUp() {
        managerI = new ManagerImpl(store);
        store = new Store("Wendy's shop", 400000);
        manager = new Manager("manager", managerI);
        applicants1 = new Applicants("Emmanuel", 20, 4);
        applicants2 = new Applicants("Cheryl", 17, 1);
        readProductList = new ReadProductList();
        cashierServImplm = new cashierServImplm(readProductList);
    }

    @Test
    void hireCashier() throws CreteriaException {
        manager.hireCashier(applicants1);
        cashier = new Cashier(applicants1.getName(), cashierServImplm);
        boolean a = applicants1.isHired();
        assertTrue(a);
    }@Test
    void notHireCashier() {

        CreteriaException e = assertThrows(CreteriaException.class, () -> {
            manager.hireCashier(applicants2);
        });
        assertEquals("Dear Cheryl You are not Eligible for this job", e.getMessage());
    }

    @Test
    void fireCashier() throws CreteriaException {
        manager.hireCashier(applicants1);
        cashier = new Cashier(applicants1.getName(), cashierServImplm);
        manager.strikeCashier(cashier);
        manager.strikeCashier(cashier);
        manager.strikeCashier(cashier);
        manager.fireCashier(cashier);
        boolean a = cashier.isCashier();
        assertFalse(a);

    }

}