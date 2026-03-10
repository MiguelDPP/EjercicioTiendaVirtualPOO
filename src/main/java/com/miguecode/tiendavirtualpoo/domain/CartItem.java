package com.miguecode.tiendavirtualpoo.domain;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return this.product.calcPrice(this.quantity);
    }
    public boolean checkProduct(int productId) {
        return this.product.checkId(productId);
    }

    public void sumQuantity(int quantity) {
        this.quantity += quantity;
    }

    @Override
    public String toString() {
        return String.format("%-30s $%-9.2f %-10s $%-10.2f", this.product.getName(), this.product.getPrice(), this.quantity, this.getSubTotal());
    }
}
