package fileio;

import enums.Category;

public final class InputGift {
    private String productName;
    private Double price;
    private Category category;
    private int quantity;

    public InputGift() {

    }

    public InputGift(final String productName, final Double price, final Category category,
                     final int quantity) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public InputGift(final InputGift gift) {
        this.category = gift .category;
        this.price = gift.price;
        this.productName = gift.productName;
        this.quantity = gift.quantity;
    }

    public String getProductName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setProductName(final String productName) {
        this.productName = productName;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }

    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }
}
