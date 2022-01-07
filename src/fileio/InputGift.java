package fileio;

import enums.Category;

public final class InputGift {
    private String productName;
    private Double price;
    private Category category;

    public InputGift() {

    }

    public InputGift(final String productName, final Double price, final Category category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public InputGift(final InputGift gift) {
        this.category = gift .category;
        this.price = gift.price;
        this.productName = gift.productName;
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

    public void setProductName(final String productName) {
        this.productName = productName;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }
}
