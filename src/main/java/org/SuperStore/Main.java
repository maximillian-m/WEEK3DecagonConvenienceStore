package org.SuperStore;

import org.SuperStore.Exceptions.CheckOutException;
import org.SuperStore.Exceptions.CreteriaException;
import org.SuperStore.Exceptions.SellProductException;
import org.SuperStore.Models.*;
import org.SuperStore.Services.ICashierServices;
import org.SuperStore.Services.IManagerServices;
import org.SuperStore.Services.ServiceImpl.CashierThreadImpl;
import org.SuperStore.Services.ServiceImpl.ManagerImpl;
import org.SuperStore.Services.ServiceImpl.cashierServImplm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws CreteriaException, SellProductException, CheckOutException {
        //Initialization of a new Store

        ReadProductList productList = new ReadProductList();
        productList.readListOfFromFile("/Users/decagon/IdeaProjects/Week2Convenience/src/main/resources/utils/ListOfProducts.xlsx");
        System.out.println(productList.getProducts());

        Store store1 = new Store("Tony's Store", 100000.0);
        System.out.println("=====================================================");
        System.out.println();
        System.out.println();

        // manager initialization .......
      IManagerServices managerImpl = new ManagerImpl(store1);
        Manager manager = new Manager("Kunle", managerImpl);
        System.out.println("=====================================================");

        Applicants applicant1 = new Applicants("Wendy", 20, 4);
        manager.hireCashier(applicant1);

        System.out.println("=====================================================");
        System.out.println();
        System.out.println();
        //instantiating a cashier
        ICashierServices cashierserv = new cashierServImplm(productList);
        Cashier cashier1 = new Cashier(applicant1.getName(), cashierserv);

        System.out.println("=====================================================");
        System.out.println();
        System.out.println();
//
        //instantiating a new customer
        Customer customer1 = new Customer("Customer1", 410000, productList);
        Customer customer2 = new Customer("Nne", 700000, productList);
        Customer customer3 = new Customer("Wendy", 500000, productList);
        customer1.addToCart("Rice", 10);
        customer2.addToCart("Rice", 2);
        customer2.addToCart("Beef", 6);
        customer2.addToCart("Cocacola", 10);
        customer3.addToCart("Mcvites", 3);
        customer3.addToCart("Nike", 2);


        //Threading on customers to check
        CashierThreadImpl forCustomer1 = new CashierThreadImpl(cashier1, customer1);
        CashierThreadImpl forCustomer2 = new CashierThreadImpl(cashier1, customer2);
        CashierThreadImpl forCustomer3 = new CashierThreadImpl(cashier1, customer3);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(forCustomer1);
        executor.execute(forCustomer2);
        executor.execute(forCustomer3);

        executor.shutdown();
//        new Thread(forCustomer1).start();
//        new Thread(forCustomer2).start();
//        new Thread(forCustomer3).start();
//
//
//
//        cashier1.addToCustomerList(customer2);
//        cashier1.addToCustomerList(customer1);
//        cashier1.addToCustomerList(customer3);
//        cashier1.checkOutMethod(false);


//        System.out.println(customer1.getWallet());// customer checks wallet

        //System.out.println("=====================================================");
//        System.out.println();
//        System.out.println();
//
//
//
//        System.out.println();
//        System.out.println();

        //customer buys product when wallet amount is enough
//
//        System.out.println("=====================================================");
//        System.out.println();
//        System.out.println();
//
//        System.out.println("=====================================================");
//        System.out.println();
//        System.out.println();

        //manager gets the store account to check if it's update
//        System.out.println(manager.getStoreCash());
//        System.out.println(customer1.getWallet());
//
//        System.out.println(productList.getProducts());
//        System.out.println(customer1.getCart());
    }
}
