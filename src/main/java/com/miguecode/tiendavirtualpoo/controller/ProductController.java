package com.miguecode.tiendavirtualpoo.controller;

import com.miguecode.tiendavirtualpoo.domain.CartItem;
import com.miguecode.tiendavirtualpoo.domain.Product;
import com.miguecode.tiendavirtualpoo.exception.EntityNotFoundException;
import com.miguecode.tiendavirtualpoo.service.CartService;
import com.miguecode.tiendavirtualpoo.service.ProductService;
import com.miguecode.tiendavirtualpoo.ui.MenuView;
import com.miguecode.tiendavirtualpoo.ui.ProductPrinter;
import com.miguecode.tiendavirtualpoo.util.Console;
import com.miguecode.tiendavirtualpoo.util.Validator;

import java.util.List;

public class ProductController {
    private final ProductService productService = new ProductService();
    private final CartService cartService = new CartService(productService);

    public void run() {
        short op = 0;

        System.out.println("---- Bienvenido a su Tienda WSHOPS (World Shop Solution) ----");
        do {
            MenuView.showInitialMenu();
            op = Console.readValidator("Seleccione una opción: ", Short::parseShort, Validator::positiveNumber);

            switch (op) {
                case 1:
                    showProducts();
                    break;
                case 2:
                    addProductCart();
                    break;
                case 3:
                    showCart();
                    break;
                case 4:
                    addProduct();
                    break;
                case 5:
                    System.out.println("--- Ha salido del sistema ---");
                    break;
                default:
                    System.out.println("--- Opción incorrecta ---");
            }
        } while (op != 5);
    }

    private void showProducts() {
        ProductPrinter.printProducts(this.productService.getProducts());
    }

    private void addProductCart() {
        System.out.println("---- Añadir Producto Al Carrito ----");
        if (productService.productsIsEmpty()) {
            System.out.println("No hay productos registrados");
            return;
        }

        String keyExit = "s";
        do {
            this.showProducts();;
            int productId = Console.readValidator("Ingrese El Id Del Producto Que Desea Agregar Al Carrito: ", Integer::parseInt, Validator::positiveNumber);
            int quantity = Console.readValidator("Ingrese la cantidad de productos que sea agregar al carrito: ", Integer::parseInt,  Validator::positiveNumber);

            try {
                this.cartService.addProduct(productId, quantity);
                System.out.println("---- Producto agregado correctamente al carrito ----");
                keyExit = Console.read(
                        "Si desea agregar otro producto al carrito presione la tecla [S], de lo contrario presione cualquier otra tecla: ",
                        String::toString
                );
            } catch (EntityNotFoundException e) {
                this.resolveException(e);
            }
        } while (keyExit.equalsIgnoreCase("s"));
    }

    private void showCart() {
        System.out.printf("%-24sresumen del carrito\n","");
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-30s %-10s %-10s %-10s\n", "Producto", "Valor", "Cantidad", "Subtotal");
        System.out.println("-----------------------------------------------------------------------");
        System.out.print(this.cartService.getCartSummary());
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-52s $%-10.2f\n", "TOTAL:", this.cartService.getTotal());
        System.out.println("-----------------------------------------------------------------------");
    }

    private void addProduct() {
        System.out.println("---- Agregar Un Producto ----");
        String nombre = Console.readValidator("Ingrese El Nombre Del Producto: ", String::toString, Validator::isNotEmpty);
        double price = Console.readValidator("Ingrese El Precio Del Producto: ", Double::parseDouble, Validator::positiveNumber);

        try {
            this.productService.addProduct(nombre, price);
            System.out.println("---- Producto Agregado Correctamente Al Catalogo ----");
        } catch (IllegalStateException e) {
            this.resolveException(e);
        }
    }

    private void resolveException(RuntimeException e) {
        System.out.printf("--- Ha ocurrido un error: %s ---\n",  e.getMessage());
    }
}
