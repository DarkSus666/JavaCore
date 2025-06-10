package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private String name;

    public Product(String name) {
        try {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Ошибка: Неправильное название продукта");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    void realPrice(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Ошибка: Неверная цена");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String getSearchableName() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getSearchTerm() {
        return name;
    }
}
