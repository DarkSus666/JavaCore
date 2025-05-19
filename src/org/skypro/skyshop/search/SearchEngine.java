package org.skypro.skyshop.search;

public class SearchEngine {
    private Searchable[] searchables;
    private int size;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
        this.size = 0;
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultCounter = 0;
        for (int i = 0; i < size && resultCounter < 5; i++) {
            if (searchables[i].getSearchTerm().contains(query)) {
                results[resultCounter++] = searchables[i];
            }
        }
        return results;
    }

    public void add(Searchable item) {
        if (size < searchables.length) {
            searchables[size++] = item;
        } else {
            throw new IllegalStateException("Массив запросов переполнен");
        }
    }
}
