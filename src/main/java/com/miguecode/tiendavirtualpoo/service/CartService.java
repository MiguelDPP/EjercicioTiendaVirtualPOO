package com.miguecode.tiendavirtualpoo.service;

import com.miguecode.tiendavirtualpoo.domain.CartItem;
import com.miguecode.tiendavirtualpoo.domain.Product;
import com.miguecode.tiendavirtualpoo.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    private final ProductService productService;
    private final List<CartItem> cartProducts = new ArrayList<>();
    private double total = 0;

    public CartService(ProductService productService) {
        this.productService = productService;
    }

    public CartItem getCartProductByProductId(int productId){
        for (CartItem cartItem : cartProducts) {
            if (cartItem.checkProduct(productId)) {
                return cartItem;
            }
        }

        return null;
    }
    public List<CartItem> getCartProducts(){
        return cartProducts;
    }

    private void recalculateTotal(){
        this.total = 0;
        for  (CartItem cartItem : cartProducts) {
            this.total += cartItem.getSubTotal();
        }
    }

    public double getTotal(){
        return this.total;
    }

    public void addProduct(int productId, int quantity) {
        Product product = this.productService.getProductById(productId);

        if (product == null) {
            throw new EntityNotFoundException("Producto con el id "+productId+" no encontrado");
        }

        CartItem cartItem = getCartProductByProductId(productId);
        if (cartItem == null) {
            cartItem = new CartItem(product, quantity);
            this.cartProducts.add(cartItem);
        }else {
            cartItem.sumQuantity(quantity);
        }

        this.recalculateTotal();
    }


    public String getCartSummary() {
        String data = "";
        for (CartItem cartItem : cartProducts) {
            data = data.concat(cartItem.toString()) + "\n";
        }

        return data;
    }
}
