package org.SuperStore.Services.ServiceImpl;

import org.SuperStore.Models.Customer;
import org.SuperStore.Models.Product;
import org.SuperStore.Services.ICustomerServices;

import java.util.List;


public class CustomerServImpl implements ICustomerServices {
    private Customer customer;

    public CustomerServImpl(Customer customer) {
        this.customer = customer;
    }

    public void addToCart(String product, int quantity) {
       customer.addToCart(product, quantity);
    }
    public double getWallet() {
        return customer.getWallet();
    }
    public List<Product> getCart() {
        return customer.getCart();
    }
    public void setWallet(double wallet) {

        customer.setWallet(wallet);
    }
}
