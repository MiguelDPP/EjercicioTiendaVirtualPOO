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
}
