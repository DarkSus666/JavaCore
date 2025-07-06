package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        List<Product> productList = products.getOrDefault(product.getName(), new LinkedList<>());
        productList.add(product);
        products.put(product.getName(), productList);
    }

    public List<Product> deleteProductByName(String name) {
        List<Product> deletedProducts = new LinkedList<>();
        for (Map.Entry<String, List<Product>> listEntry : products.entrySet()) {
            for (Product product : listEntry.getValue()) {
                if (product.getName().equals(name)) {
                    deletedProducts.add(product);
                    listEntry.getValue().remove(product);
                }
            }
            if (deletedProducts.isEmpty()) {
                System.out.println("Список пуст");
            }
        }
        products.remove(name);
        return deletedProducts;
    }

    public int basketPrice() {
        int total = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null) {
                    total += product.getPrice();
                }
            }
        }
        return total;
    }

    public void print() {
        int specials = 0;
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null) {
                    System.out.println(product);
                    if (product.isSpecial()) {
                        specials++;
                    }
                }
            }
        }
        System.out.println("Итого: " + basketPrice() + " руб.");
        System.out.println("Специальных товаров: " + specials);
    }

    public boolean searchProduct(String name) {
        return products.containsKey(name);
    }

    public void clearBasket() {
        products = new HashMap<>();
    }

}
