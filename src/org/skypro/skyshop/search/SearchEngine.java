package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> searchables = new HashSet<>();

    public TreeSet<Searchable> search(String query) {
        TreeSet<Searchable> results = searchables
                .stream()
                .filter(i -> i.getSearchTerm().contains(query))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
        return results;
    }

    public static class SearchableComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            int lengthCompare = Integer.compare(s2.getSearchTerm().length(), s1.getSearchTerm().length());
            if (lengthCompare != 0) {
                return lengthCompare;
            }
            return s1.getSearchTerm().compareTo(s2.getSearchTerm());
        }
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

    @Override
    public String toString() {
        return "SearchEngine{" +
                "searchables=" + searchables +
                '}';
    }
}
