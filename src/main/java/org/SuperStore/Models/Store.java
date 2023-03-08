package org.SuperStore.Models;

public class Store {
    private double storeCash;
    private String name;
    public Store(String name, double cash) {
        storeCash = cash;
        this.name = name;
        System.out.println(name + " has been initialized and has an account of NGN"+ storeCash);
    }
    public double getStoreCash() {
        return storeCash;
    }

    public void setStoreCash(double cash) {
        this.storeCash = cash;
    }

}
