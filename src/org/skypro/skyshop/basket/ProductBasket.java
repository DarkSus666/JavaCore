package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private List<Product> products = new LinkedList<>();
    private int size;

    public void addProduct(Product product) {
        products.add(product);
        size++;
    }

    public LinkedList<Product> deleteProductByName(String name) {
        LinkedList<Product> deletedProducts = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product current = iterator.next();
            if (current.getName().equals(name)) {
                deletedProducts.add(current);
                iterator.remove();
                size--;
            }
        }
        if (deletedProducts.isEmpty()) {
            System.out.println("Список пуст");
        }
        return deletedProducts;
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

    public void print() {
        int specials = 0;
        if (size == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
                if (product.isSpecial()) {
                    specials++;
                }
            }
        }
        System.out.println("Итого: " + basketPrice() + " руб.");
        System.out.println("Специальных товаров: " + specials);
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
        products = new LinkedList<>();
        size = 0;
    }

}
