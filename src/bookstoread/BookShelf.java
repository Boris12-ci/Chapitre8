package bookstoread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookShelf {
    private final List<String> books = new ArrayList<>();

    public List<String> books() {
        return Collections.unmodifiableList(books);
    }

    public void add(String... booksToAdd) {
        for (String book : booksToAdd) {
            books.add(book);
        }
    }

    public List<String> arrange() {
        return books.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> arrange(Comparator<String> criteria) {
        return books.stream()
                .sorted(criteria)
                .collect(Collectors.toList());
    }
}