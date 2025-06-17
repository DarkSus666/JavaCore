package org.skypro.skyshop.search;

public class BestResultNotFound extends Exception {
    private String search;

    public BestResultNotFound(String search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "Для запроса '" + search + "' не нашлось подходящей статьи";
    }
}