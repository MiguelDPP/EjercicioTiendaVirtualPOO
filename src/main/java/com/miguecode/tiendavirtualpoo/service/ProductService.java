package com.miguecode.tiendavirtualpoo.service;

import com.miguecode.tiendavirtualpoo.domain.CartItem;
import com.miguecode.tiendavirtualpoo.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return this.products;
    }

    public boolean productsIsEmpty() {
        return this.products.isEmpty();
    }

    public Product getProductById(int productId) {
        for (Product product : products) {
            if (product.checkId(productId)) return product;
        }

        return null;
    }

    public void addProduct(String name, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must be a positive number");
        }
        Product product = new Product(name, price);

        this.products.add(product);
    }
}
