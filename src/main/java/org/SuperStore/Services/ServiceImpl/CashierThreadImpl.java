package org.SuperStore.Services.ServiceImpl;

import org.SuperStore.Exceptions.CheckOutException;
import org.SuperStore.Exceptions.CreteriaException;
import org.SuperStore.Exceptions.SellProductException;
import org.SuperStore.Models.Cashier;
import org.SuperStore.Models.Customer;

public class CashierThreadImpl implements Runnable{
    private Cashier cashier;
    private Customer customer;
    public CashierThreadImpl(Cashier cashier, Customer customer){
        this.cashier = cashier;
        this.customer = customer;
    }

    @Override
    public void run() {
        try {
            cashier.customerCheck(customer);
            Thread.sleep(5000);

        }catch(InterruptedException e){
            e.printStackTrace();
        } catch (CheckOutException e) {
             e.getMessage();
        } catch (SellProductException e) {
            e.getMessage();
        } catch (CreteriaException e) {
            e.getMessage();
        }
    }
}
