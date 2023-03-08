package org.SuperStore.Services.ServiceImpl;

import org.SuperStore.Exceptions.CheckOutException;
import org.SuperStore.Exceptions.SellProductException;
import org.SuperStore.Models.*;
import org.SuperStore.Services.ICashierServices;

import java.util.*;

public class cashierServImplm implements ICashierServices{
    public Object lock = new Object();
    private double customerCheck;
    private ReadProductList list;
    private Queue<Customer> customerList = new LinkedList<>();
    private boolean checkPriority;

    public cashierServImplm(ReadProductList list) {
        this.list = list;
    }

    public double getCustomerCheck() {
        return customerCheck;
    }

    public void setCustomerCheck(double customerCheck) {
        this.customerCheck = customerCheck;
    }



@Override
    public void checkOutMethod(boolean useFIFO) throws CheckOutException, SellProductException {
        if (customerList == null || customerList.isEmpty()) {
            System.out.println("There is no Customer on the Queue");
            return;
        }
        if (useFIFO) {
            Iterator it = customerList.iterator();
            while (it.hasNext()) {
                Customer cst = (Customer) it.next();
                if (cst != null) {
                    customerCheck(cst);
                    System.out.println("You have used FIFO method to sell to customers");
                    it.remove();
                }
            }
        } else {
            setCheckPriority(true);
            PriorityQueue<Customer> priority = new PriorityQueue<>(customerList.size(), new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return o2.getCart().size() - o1.getCart().size();
                }
            });
            priority.addAll(customerList);
            while (!priority.isEmpty()) {
                Customer customers = priority.poll();
                if (customers != null) {
                    customerCheck(customers);
                    customerList.poll();
                    System.out.println("Checking out using priority method");
                }
            }
        }
    }


    public void setCheckPriority(boolean set){
        this.checkPriority = set;
    }
@Override
    public boolean isCheckPriority() {
        return checkPriority;
    }

    public Queue<Customer> getCustomerList() {
        return customerList;
    }
@Override
    public void addCustomersToList(Customer customer){
        customerList.add(customer);
    }
@Override
public synchronized double customerCheck(Customer customer){
    double output = 0.0;
    List<Product> cart = customer.getCart();
    Iterator<Product> cartIterator = cart.iterator();

    while (cartIterator.hasNext()) {
        Product a = cartIterator.next();
        for (Product b : list.getProducts()) {
            if (b.getName().equals(a.getName())) {
                if (b.getQuantity() == 0) {
                    cartIterator.remove();
                    System.out.println(a.getName() + " is Out of Stock");
                   // throw new CheckOutException(a.getName() + " is Out of Stock");
                } else if (b.getQuantity() < a.getQuantity()) {
                    cartIterator.remove();
                    System.out.println("we have limited quantity of " + b.getName());
//                    throw new CheckOutException("We have Limited quantity of " + b.getName());
                } else {
                    b.setQuantity(b.getQuantity() - a.getQuantity());
                    output += a.getPrice() * a.getQuantity();
                }
            }
            }
            setCustomerCheck(output);
    }
    sellProducts(customer);
    return output;
}


    @Override
        public void sellProducts (Customer customer) {
            if(getCustomerCheck() > customer.getWallet()){
                System.out.println("Insufficient wallet balance for " + customer.getName());
                //throw new SellProductException(" Insufficient wallet amount to Purchase goods");
            }else{
                try{
                    Thread.sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Purchase successful.... Here is your receipt");
                issueReceipt(customer);
                customer.getCart().clear();
            }
        }

        private void issueReceipt(Customer customer){
            System.out.println("RECEIPT OF PURCHASE");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("Your purchases include: ");
            for(Product item : customer.getCart()){
                System.out.println("item :" + item.getName() + "   QTY:" + item.getQuantity() + "   price:" + item.getPrice());
                System.out.println();
            }
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("Total : NGN" + getCustomerCheck());
            System.out.println();
            System.out.println();
            customer.setWallet(customer.getWallet() - getCustomerCheck());
//            customer.getCart().clear();
        }

}
