package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws BestResultNotFound {
        ProductBasket productBasket = new ProductBasket();
        try {
            productBasket.addProduct(new SimpleProduct("продукт 1", 666));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            productBasket.addProduct(new DiscountedProduct("продукт 2", 777, 150));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            productBasket.addProduct(new SimpleProduct("продукт премиум 3", 888));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            productBasket.addProduct(new FixPriceProduct("продукт 4"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            productBasket.addProduct(new SimpleProduct("продукт премиум 5", 0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            productBasket.addProduct(new SimpleProduct("     ", 333));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        productBasket.print();
        System.out.println("В корзине товара на " + productBasket.basketPrice() + " руб.");
        System.out.println("Наличие продукта 6 в корзине: " + productBasket.searchProduct("продукт 6"));
        productBasket.clearBasket();
        productBasket.print();
        System.out.println("В корзине товара на " + productBasket.basketPrice() + " руб.");
        System.out.println("Наличие продукта 3 в корзине: " + productBasket.searchProduct("продукт 3"));
        try {
            productBasket.addProduct(new FixPriceProduct("продукт премиум 200"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            productBasket.addProduct(new DiscountedProduct("продукт 10", 1000, 15));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            productBasket.addProduct(new SimpleProduct("продукт 7", 111));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            productBasket.addProduct(new DiscountedProduct("продукт 8", 300, 20));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            productBasket.addProduct(new SimpleProduct("продукт 9", 444));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        productBasket.print();

        System.out.println();

        SearchEngine searchEngine = new SearchEngine(15);
        try {
            searchEngine.add(new SimpleProduct("продукт 1", 666));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.add(new DiscountedProduct("продукт 2", 777, 150));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.add(new SimpleProduct("продукт премиум 3", 888));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.add(new FixPriceProduct("продукт 4"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.add(new SimpleProduct("продукт премиум 5", 0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.add(new SimpleProduct("    ", 333));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.add(new FixPriceProduct("продукт премиум 200"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.add(new DiscountedProduct("продукт 10", 1000, 15));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.add(new SimpleProduct("продукт 7", 111));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.add(new DiscountedProduct("продукт 8", 300, 20));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.add(new SimpleProduct("продукт 9", 444));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Article article1 = new Article("товар", "статья о товаре");
        Article article2 = new Article("товарчик", "рассказ о товарчике");
        Article article3 = new Article("товаришка", "повесть о товаришке товар товар");
        Article article4 = new Article("товаришка", "повесть о товаришке товарик товарчонок товарото");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);

        System.out.println("поиск по 'продукту':" + "\n" + Arrays.toString(searchEngine.search("продукт")) + "\n");
        System.out.println("поиск по 'товару':" + "\n" + Arrays.toString(searchEngine.search("товар")) + "\n");
        System.out.println("поиск по 'премиуму':" + "\n" + Arrays.toString(searchEngine.search("премиум")) + "\n");
        System.out.println("поиск по 'ARTICLE':" + "\n" + Arrays.toString(searchEngine.search("ARTICLE")) + "\n");
        try {
            System.out.println("поиск по 'лучшей скобе':" + "\n" + searchEngine.bestResult("скоба") + "\n");
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }
        try {
            System.out.println("поиск по 'лучшему товару':" + "\n" + searchEngine.bestResult("товар") + "\n");
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }

    }
}
