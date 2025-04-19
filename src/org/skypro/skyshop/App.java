package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        productBasket.addProduct(new Product("продукт 1", 666));
        productBasket.addProduct(new Product("продукт 2", 777));
        productBasket.addProduct(new Product("продукт 3", 888));
        productBasket.addProduct(new Product("продукт 4", 999));
        productBasket.addProduct(new Product("продукт 5", 555));
        productBasket.addProduct(new Product("продукт 6", 333));
        productBasket.print();
        System.out.println("В корзине товара на " + productBasket.basketPrice() + " руб.");
        System.out.println("Наличие продукта 6 в корзине: " + productBasket.searchProduct("продукт 6"));
        productBasket.clearBasket();
        productBasket.print();
        System.out.println("В корзине товара на " + productBasket.basketPrice() + " руб.");
        System.out.println("Наличие продукта 3 в корзине: " + productBasket.searchProduct("продукт 3"));
        productBasket.addProduct(new Product("продукт 7", 111));
        productBasket.addProduct(new Product("продукт 8", 222));
        productBasket.addProduct(new Product("продукт 9", 444));
        productBasket.print();
    }
}
