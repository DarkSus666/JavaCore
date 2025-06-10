package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        productBasket.addProduct(new SimpleProduct("продукт 1", 666));
        productBasket.addProduct(new DiscountedProduct("продукт 2", 777, 150));
        productBasket.addProduct(new SimpleProduct("продукт премиум 3", 888));
        productBasket.addProduct(new FixPriceProduct("продукт 4"));
        productBasket.addProduct(new SimpleProduct("продукт премиум 5", 0));
        productBasket.addProduct(new SimpleProduct("     ", 333));
        productBasket.print();
        System.out.println("В корзине товара на " + productBasket.basketPrice() + " руб.");
        System.out.println("Наличие продукта 6 в корзине: " + productBasket.searchProduct("продукт 6"));
        productBasket.clearBasket();
        productBasket.print();
        System.out.println("В корзине товара на " + productBasket.basketPrice() + " руб.");
        System.out.println("Наличие продукта 3 в корзине: " + productBasket.searchProduct("продукт 3"));
        productBasket.addProduct(new FixPriceProduct("продукт премиум 200"));
        productBasket.addProduct(new DiscountedProduct("продукт 10", 1000, 15));
        productBasket.addProduct(new SimpleProduct("продукт 7", 111));
        productBasket.addProduct(new DiscountedProduct("продукт 8", 300, 20));
        productBasket.addProduct(new SimpleProduct("продукт 9", 444));
        System.out.println();
        productBasket.print();

        System.out.println();

        SearchEngine searchEngine = new SearchEngine(15);
        searchEngine.add(new SimpleProduct("продукт 1", 666));
        searchEngine.add(new DiscountedProduct("продукт 2", 777, 30));
        searchEngine.add(new SimpleProduct("продукт премиум 3", 888));
        searchEngine.add(new FixPriceProduct("продукт 4"));
        searchEngine.add(new SimpleProduct("продукт премиум 5", 555));
        searchEngine.add(new SimpleProduct("продукт 6", 333));
        searchEngine.add(new FixPriceProduct("продукт премиум 200"));
        searchEngine.add(new DiscountedProduct("продукт 10", 1000, 15));
        searchEngine.add(new SimpleProduct("продукт 7", 111));
        searchEngine.add(new DiscountedProduct("продукт 8", 300, 20));
        searchEngine.add(new SimpleProduct("продукт 9", 444));

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
        System.out.println("поиск по 'лучшему товару':" + "\n" + searchEngine.bestResult("скоба") + "\n");
        System.out.println("поиск по 'лучшему товару':" + "\n" + searchEngine.bestResult("товар") + "\n");

    }
}
