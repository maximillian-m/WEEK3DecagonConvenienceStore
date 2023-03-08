package org.SuperStore.Services;

import org.SuperStore.Exceptions.SellProductException;
import org.SuperStore.Exceptions.CheckOutException;
import org.SuperStore.Models.Customer;

import java.util.Queue;

public interface ICashierServices{
        public void sellProducts(Customer customer) throws SellProductException;
    public double customerCheck(Customer customer) throws CheckOutException, SellProductException, InterruptedException;
    public void checkOutMethod(boolean useFIFO) throws CheckOutException, SellProductException;
    public void addCustomersToList(Customer customer);
    public boolean isCheckPriority();
    public Queue<Customer> getCustomerList();
    public void setCheckPriority(boolean set);
}

