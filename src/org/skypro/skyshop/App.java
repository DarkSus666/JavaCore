package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        productBasket.addProduct("продукт 1", 666);
        productBasket.addProduct("продукт 2", 777);
        productBasket.addProduct("продукт 3", 888);
        productBasket.addProduct("продукт 4", 999);
        productBasket.addProduct("продукт 5", 555);
        productBasket.addProduct("продукт 6", 333);
        productBasket.basketContain();
        System.out.println("В корзине товара на " + productBasket.basketPrice() + " руб.");
        System.out.println("Наличие продукта 6 в корзине: " + productBasket.searchProduct("продукт 6"));
        productBasket.clearBasket();
        productBasket.basketContain();
        System.out.println("В корзине товара на " + productBasket.basketPrice() + " руб.");
        System.out.println("Наличие продукта 3 в корзине: " + productBasket.searchProduct("продукт 3"));
        productBasket.addProduct("продукт 7", 111);
        productBasket.addProduct("продукт 8", 222);
        productBasket.addProduct("продукт 9", 444);
        productBasket.basketContain();
    }
}
