package org.SuperStore.Models;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private String category;
    public Product(String name, String category, double price, int qty) {
        this.name = name;
        this.price = price;
        this.category = category;
        quantity = qty;

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category +
                ", price=" + price +
                ", quantity=" + quantity + '\'' +
                '}';
    }

}
