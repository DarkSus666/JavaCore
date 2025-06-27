package org.skypro.skyshop.search;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchables = new LinkedList<>();
    private int size;

    public LinkedList<Searchable> search(String name) {
        LinkedList<Searchable> results = new LinkedList<>();
        Iterator<Searchable> iterator = searchables.iterator();
        while (iterator.hasNext()) {
            Searchable current = iterator.next();
            if (current.getSearchableName().contains(name)) {
                results.add(current);
            }
        }
        if (results.isEmpty()) {
            System.out.println("Список пуст");
        }
        return results;
    }

    public void add(Searchable item) {
        searchables.add(item);
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
