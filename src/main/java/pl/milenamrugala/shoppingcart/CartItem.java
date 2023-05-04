package pl.milenamrugala.shoppingcart;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CartItem {

    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSum() {
        BigDecimal price = new BigDecimal(String.valueOf(getProduct().getPrice()));
        BigDecimal quantity = new BigDecimal(getQuantity());
        return price.multiply(quantity).setScale(2, RoundingMode.HALF_UP);
    }
}
