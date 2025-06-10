package org.skypro.skyshop.product;

import java.util.Objects;

public class DiscountedProduct extends Product {
    private int discount;
    private int basePrice;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        try {
            if (discount < 0 || discount > 100) {
                throw new IllegalArgumentException("Ошибка: Неправильная скидка");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        this.discount = discount;
        try {
            realPrice(basePrice);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountedProduct that = (DiscountedProduct) o;
        return basePrice == that.basePrice && discount == that.discount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), basePrice, discount);
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discount + "%)";
    }
}
