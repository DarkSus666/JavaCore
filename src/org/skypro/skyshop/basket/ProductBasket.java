package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {
    private Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        List<Product> productList = products.getOrDefault(product.getName(), new LinkedList<>());
        productList.add(product);
        products.put(product.getName(), productList);
    }

    public LinkedList<Product> deleteProductByName(String name) {
        LinkedList<Product> deletedProducts = products.values()
                .stream()
                .flatMap(Collection::stream)
                .filter(i -> i.getName().equals(name))
                .collect(Collectors.toCollection(LinkedList::new));
        products.remove(name);
        return deletedProducts;
    }

    public int basketPrice() {
        return products.values()
                .stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void print() {
        products.values()
                .stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);
        System.out.println("Итого: " + basketPrice() + " руб.");
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    private Long getSpecialCount() {
        return products.values()
                .stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public boolean searchProduct(String name) {
        return products.containsKey(name);
    }

    public void clearBasket() {
        products = new HashMap<>();
    }

}
