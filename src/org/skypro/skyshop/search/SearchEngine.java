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
        if (size >= searchables.length) {
            throw new IllegalStateException("Массив запросов переполнен");
        }
        searchables[size++] = item;
    }

    public Searchable bestResult(String search) throws BestResultNotFound {
        Searchable best = null;
        int bestCount = 0;
        for (Searchable searchable : searchables) {
            if (searchable != null) {
                String str = searchable.getSearchTerm();
                String substring = search;
                int count = 0;
                int index = 0;
                int substringIndex = str.indexOf(substring, index);
                while (substringIndex != -1) {
                    count++;
                    index = substringIndex + substring.length();
                    substringIndex = str.indexOf(substring, index);
                }
                if (count > bestCount) {
                    best = searchable;
                    bestCount = count;
                }
            }
        }
        if (bestCount == 0) {
            throw new BestResultNotFound(search);
        }
        return best;
    }
}
