package com.miguecode.tiendavirtualpoo.domain;

public class Product {
    private static int lastId = 1;
    private int id;
    private String name;
    private double price;
    public Product(String name, double price) {
        this.id = lastId++;
        this.name = name;
        this.price = price;
    }

    // Subtotal
    public double calcPrice(int quantity) {
        return price * quantity;
    }

    public double getPrice() {
        return price;
    }

    public boolean checkId(int id) {
        return this.id == id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-55s $%-10.2f", this.id, this.name, this.price);
    }
}
