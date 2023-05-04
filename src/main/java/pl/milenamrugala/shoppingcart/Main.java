package pl.milenamrugala.shoppingcart;


import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        Product socks = new Product("socks", new BigDecimal("20"));
        Product hoodie = new Product("hoodie", new BigDecimal("400"));
        Product shoes = new Product("shoes", new BigDecimal("550"));
        Product cardigan = new Product("cardigan", new BigDecimal("700"));
        Product cap = new Product("cap", new BigDecimal("250"));

        cart.addProduct(socks, 3);
        cart.addProduct(shoes, 2);
        cart.addProduct(cap, 3);
        cart.addProduct(cardigan, 1);
        cart.addProduct(hoodie, 2);

        cart.getTotalSum();
        cart.getTotalQuantity();
        cart.removeProduct(shoes);
        cart.getTotalSum();
        cart.getTotalQuantity();
        cart.updateProduct(cardigan, 2);
        cart.getTotalSum();
        cart.getTotalQuantity();
        cart.printReceipt();

    }
}