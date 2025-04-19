package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;
import java.util.Objects;

public class ProductBasket {
    private Product[] products = new Product[5];
    private int size;

    public void addProduct(String name, int price) {
        if (size >= products.length) {
            System.out.println("Невозможно добавить продукт");
        }
        Product product = new Product(name, price);
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                size++;
                break;
            }
        }
    }

    public int basketPrice() {
        int total = 0;
        for (Product product : products) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void basketContain() {
        if (size == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
            }
        }
        System.out.println("Итого: " + basketPrice() + " руб.");
    }

    public boolean searchProduct(String name) {
        if (size == 0) {
            return false;
        }
        for (Product product : products) {
            if (product != null && Objects.equals(product.getName(), name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        Arrays.fill(products, null);
        size = 0;
    }
}
