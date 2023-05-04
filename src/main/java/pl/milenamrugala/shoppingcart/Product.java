package pl.milenamrugala.shoppingcart;

import java.math.BigDecimal;

public class Product {

    private static Long nextId = 1L;

    private Long id;
    private String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.id = nextId++;
        this.name = name;
        setPrice(price);
    }

    public Long getId() {
        return id;
    }

    public void setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) >= 0) {
            this.price = price;
        } else {
            throw new RuntimeException("Only positive numbers.");
        }
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
