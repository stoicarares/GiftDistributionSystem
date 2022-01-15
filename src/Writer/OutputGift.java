package writer;

import enums.Category;
import fileio.InputGift;

public class OutputGift {
    private String productName;
    private Double price;
    private Category category;

    public OutputGift(final InputGift gift) {
        this.category = gift .getCategory();
        this.price = gift.getPrice();
        this.productName = gift.getProductName();
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
