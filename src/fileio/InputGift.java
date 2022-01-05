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

    @Override
    public String toString() {
        return "InputGift{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}