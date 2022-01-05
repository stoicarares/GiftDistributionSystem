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

<<<<<<< HEAD
    public InputGift(InputGift gift) {
        this.productName = gift.productName;
        this.price = gift.price;
        this.category = gift.category;
=======
    public InputGift(final InputGift inputGift) {
        this.productName = inputGift.productName;
        this.price = inputGift.price;
        this.category = inputGift.category;
>>>>>>> 13256612200098be0add51ec260c0b47d25d25d8
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