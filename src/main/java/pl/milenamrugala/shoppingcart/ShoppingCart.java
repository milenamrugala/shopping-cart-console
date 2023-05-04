package pl.milenamrugala.shoppingcart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<CartItem> cartItems;

    public ShoppingCart() {
        this.cartItems = new ArrayList<>();
    }

    public void addProduct(Product product, int quantity) {
        if (existsInShoppingCart(product)) {
            updateProduct(product, quantity);
        } else {
            this.cartItems.add(new CartItem(product, quantity));
            System.out.println("Product added.");
        }
    }

    private boolean existsInShoppingCart(Product product) {
        boolean exists = false;
        for (CartItem item : this.cartItems) {
            if (item.getProduct().equals(product)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public void removeProduct(Product product) {
        for (CartItem item : this.cartItems) {
            if (item.getProduct().equals(product)) {
                this.cartItems.remove(item);
                break;
            }
        }
        System.out.println("Product removed.");
    }

    public void updateProduct(Product product, int quantity) {
        for (CartItem item : this.cartItems) {
            if (item.getProduct().equals(product)) {
                item.setQuantity(item.getQuantity() + quantity);
                break;
            }
        }

        System.out.println("Product updated.");
    }

    public void getTotalQuantity() {
        int counter = 0;
        for (CartItem item : this.cartItems) {
            counter += item.getQuantity();
        }

        System.out.println("Shopping cart quantity [TOTAL]: " + counter);
    }

    public void getTotalSum() {
        BigDecimal totalSum = BigDecimal.ZERO;
        for (CartItem item : this.cartItems) {
            totalSum = totalSum.add(item.getSum());
        }
        System.out.println("Shopping cart price [TOTAL]: " + totalSum);
    }

    public void printReceipt() {
        for (int i = 0; i < this.cartItems.size(); i++) {
            CartItem item = this.cartItems.get(i);
            System.out.println(String.format("%s | %s %s x %s || %s",
                    (i + 1), item.getProduct(), item.getProduct().getPrice(), item.getQuantity(), (item.getSum())));
        }
        getTotalSum();
    }
}
