package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        productBasket.addProduct(new SimpleProduct("продукт 1", 666));
        productBasket.addProduct(new DiscountedProduct("продукт 2", 777, 30));
        productBasket.addProduct(new SimpleProduct("продукт 3", 888));
        productBasket.addProduct(new FixPriceProduct("продукт 4"));
        productBasket.addProduct(new SimpleProduct("продукт 5", 555));
        productBasket.addProduct(new SimpleProduct("продукт 6", 333));
        productBasket.print();
        System.out.println("В корзине товара на " + productBasket.basketPrice() + " руб.");
        System.out.println("Наличие продукта 6 в корзине: " + productBasket.searchProduct("продукт 6"));
        productBasket.clearBasket();
        productBasket.print();
        System.out.println("В корзине товара на " + productBasket.basketPrice() + " руб.");
        System.out.println("Наличие продукта 3 в корзине: " + productBasket.searchProduct("продукт 3"));
        productBasket.addProduct(new FixPriceProduct("продукт 200"));
        productBasket.addProduct(new DiscountedProduct("продукт 10", 1000, 15));
        productBasket.addProduct(new SimpleProduct("продукт 7", 111));
        productBasket.addProduct(new DiscountedProduct("продукт 8", 300, 20));
        productBasket.addProduct(new SimpleProduct("продукт 9", 444));
        System.out.println();
        productBasket.print();
    }
}
