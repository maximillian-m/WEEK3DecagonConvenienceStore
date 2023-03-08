package org.SuperStore.Models;

import org.SuperStore.Services.ICustomerServices;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person implements ICustomerServices {
    public double totalCashOfProducts;
    private double wallet;
    private ReadProductList productList;
    private List<Product> cart = new ArrayList<>();
    public Customer(String name, double wallet, ReadProductList productList) {
        super(name);
        this.wallet = wallet;
        this.productList = productList;
    }
    public Customer (String name, ReadProductList productList){
        super(name);
        this.productList = productList;
    }


    public void setWallet(double wallet) {
        this.wallet = wallet;
    }
@Override
    public void addToCart(String product, int quantity) {
       for(Product p : productList.getProducts()){
           if(p.getName().equals(product)){
               Product pro = new Product(product, p.getCategory(), p.getPrice(), quantity);
               cart.add(pro);
               System.out.println("you added " + p.getName() + " To your cart");
           }
           }
            if(getCart().isEmpty()){
                System.out.println("product is not available");
            }
       }

    public double getWallet() {
        return wallet;
    }

    public List<Product> getCart() {
        return cart;
    }
    public void ListOfProducts (){
        productList.getProducts();
    }

}
