package org.SuperStore.Models;

import org.SuperStore.Exceptions.CheckOutException;
import org.SuperStore.Exceptions.CreteriaException;
import org.SuperStore.Exceptions.SellProductException;
import org.SuperStore.Services.ICashierServices;

import java.util.Queue;

public class Cashier extends Staff {

    private boolean isCashier;
    private Store store;
    private int cashierStrike = 0;
    private ICashierServices iCashierServices;
    public Cashier(String name, ICashierServices cashierServImplm) {
        super(name);
        this.iCashierServices = cashierServImplm;
        this.isCashier = true;
    }

    public void setCashier(boolean cashier) {
        isCashier = cashier;
    }
    public void sellProducts (Customer customer) throws SellProductException, CreteriaException {
        if (isCashier) {
            this.iCashierServices.sellProducts(customer);
        }else{
            throw new CreteriaException(" Sorry you are not hired yet to perform duties or you have been Fired");
        }
    }

    public double customerCheck(Customer customer) throws CheckOutException, SellProductException, CreteriaException, InterruptedException {
        if (isCashier) {
            return iCashierServices.customerCheck(customer);
        }else{
            throw new CreteriaException("Sorry you are not hired yet to perform duties or you have been Fired ");
        }
    }
    public void checkOutMethod(boolean useFIFO) throws CheckOutException, SellProductException, CreteriaException {
        if (isCashier) {
            iCashierServices.checkOutMethod(useFIFO);
        }else{
            throw new CreteriaException("Sorry you are not hired yet to perform duties or you have been Fired");
        }
    }
    public void addToCustomerList(Customer customer) throws CreteriaException{
        if (isCashier) {
            iCashierServices.addCustomersToList(customer);
        }else{
            throw new CreteriaException("Sorry you are not hired yet to perform duties or you have been Fired");
        }
    }
    public int getCashierStrike() {
        return cashierStrike;
    }

    public boolean isCashier() {
        return isCashier;
    }

    public boolean isCheckPriority() throws CreteriaException{
        if (isCashier) {
            return iCashierServices.isCheckPriority();
        }
        throw new CreteriaException("Sorry you are not hired yet to perform duties or you have been Fired");
    }
    public void setCashierStrike(int cashierStrike) {
        this.cashierStrike = cashierStrike;
    }
    public Queue<Customer> getCustomerList() throws CreteriaException{
        if (isCashier) {
            return iCashierServices.getCustomerList();
        }else{
            throw new CreteriaException("Sorry you are not hired yet to perform duties or you have been Fired");
        }
    }

    @Override
    String getStaffId() {
        return staffId;
    }

}
