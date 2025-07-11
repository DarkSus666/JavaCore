package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int discount;
    private int basePrice;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Ошибка: Неправильная скидка");
        }
        this.discount = discount;
        realPrice(basePrice);
        this.basePrice = basePrice;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int getPrice() {
        return basePrice * (1 - discount / 100);
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discount + "%)";
    }
}
