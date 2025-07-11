package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;

public class App {
    public static void main(String[] args) {

        ProductBasket productBasket = new ProductBasket();
        try {
            productBasket.addProduct(new SimpleProduct("рыба", 150));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            productBasket.addProduct(new SimpleProduct("рыба", 170));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            productBasket.addProduct(new SimpleProduct("сыр", 300));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            productBasket.addProduct(new SimpleProduct("колбаса", 200));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            productBasket.addProduct(new SimpleProduct("бекон", 350));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            productBasket.addProduct(new DiscountedProduct("тухлая рыба", 150, 30));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            productBasket.addProduct(new DiscountedProduct("тухлый сыр", 300, 20));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        productBasket.print();
        System.out.println();
        System.out.println("Список удаленных продуктов:\n" + productBasket.deleteProductByName("тухлый сыр"));
        System.out.println();
        productBasket.print();
        System.out.println();
        System.out.println("Список удаленных продуктов:\n" + productBasket.deleteProductByName("мед"));
        System.out.println();
        System.out.println("В корзине товара на " + productBasket.basketPrice() + " руб.");
        System.out.println();
        System.out.println("Наличие рыбы в корзине: " + productBasket.searchProduct("рыба"));
        System.out.println();
        productBasket.clearBasket();
        System.out.println("В корзине товара на " + productBasket.basketPrice() + " руб.");
        System.out.println();
        System.out.println("Наличие молока в корзине: " + productBasket.searchProduct("молоко"));
        System.out.println();
        try {
            productBasket.addProduct(new DiscountedProduct("тухлая колбаса", 200, 60));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            productBasket.addProduct(new DiscountedProduct("тухлая колбаса", 222, 66));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            productBasket.addProduct(new DiscountedProduct("тухлый бекон", 350, 50));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            productBasket.addProduct(new FixPriceProduct("молоко"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            productBasket.addProduct(new FixPriceProduct("мед"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            productBasket.addProduct(new FixPriceProduct("масло"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            productBasket.addProduct(new FixPriceProduct("масло"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            productBasket.addProduct(new FixPriceProduct("хлеб"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        productBasket.print();

        SearchEngine searchEngine = new SearchEngine();
        try {
            searchEngine.add(new SimpleProduct("рыба", 150));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.add(new SimpleProduct("рыба", 170));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.add(new SimpleProduct("сыр", 300));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.add(new SimpleProduct("колбаса", 200));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.add(new SimpleProduct("бекон", 350));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.add(new DiscountedProduct("тухлая рыба", 150, 30));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.add(new DiscountedProduct("тухлый сыр", 300, 20));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.add(new DiscountedProduct("тухлая колбаса", 200, 60));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.add(new DiscountedProduct("тухлая колбаса", 222, 66));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.add(new DiscountedProduct("тухлый бекон", 350, 50));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.add(new FixPriceProduct("молоко"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.add(new FixPriceProduct("мед"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.add(new FixPriceProduct("масло"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.add(new FixPriceProduct("масло"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            searchEngine.add(new FixPriceProduct("хлеб"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Article article1 = new Article("товар", "статья о товаре");
        Article article2 = new Article("товарчик", "рассказ о товарчике");
        Article article3 = new Article("товаришка", "повесть о товаришке товар товар");
        Article article4 = new Article("товаришка", "повесть о товаришке товарик товарчонок товарото");
        Article article5 = new Article("товарчик", "еще один рассказ о товарчике");


        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);
        searchEngine.add(article5);

        System.out.println();
        System.out.println(searchEngine);
        System.out.println();

        System.out.println();
        System.out.println("поиск по 'сыру':" + "\n" + searchEngine.search("сыр") + "\n");
        System.out.println("поиск по 'товару':" + "\n" + searchEngine.search("товар") + "\n");
        System.out.println("поиск по 'рыбе':" + "\n" + searchEngine.search("рыба") + "\n");
        System.out.println("поиск по 'ARTICLE':" + "\n" + searchEngine.search("ARTICLE") + "\n");
        System.out.println("поиск по 'тухл':" + "\n" + searchEngine.search("тухл") + "\n");
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
