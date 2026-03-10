package com.miguecode.tiendavirtualpoo.ui;

import com.miguecode.tiendavirtualpoo.domain.Product;

import java.util.List;

public class ProductPrinter {
    public static void printProducts(List<Product> products) {
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-24sCatalogo de productos\n","");

        if (products.isEmpty()) {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Aun no se encuentran productos registrados");
            return;
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-5s %-55s %-10s\n", "Id","Producto", "Valor");
        System.out.println("-----------------------------------------------------------------------");

        for(Product product : products) {
            System.out.println(product);
        }

        System.out.println("-----------------------------------------------------------------------");
    }
}
