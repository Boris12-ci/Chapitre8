package bookstoread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookShelfSpec {

    private BookShelf shelf;

    @BeforeEach
    void init() {
        shelf = new BookShelf();
    }

    @Test
    public void shelfEmptyWhenNoBookAdded() {
        List<String> books = shelf.books();
        assertTrue(books.isEmpty(), () -> "BookShelf should be empty.");
    }

    @Test
    void bookshelfContainsTwoBooksWhenTwoBooksAdded() {
        shelf.add("Effective Java", "Code Complete");
        List<String> books = shelf.books();
        assertEquals(2, books.size(), () -> "BookShelf should have two books.");
    }

    @Test
    void bookshelfArrangedByBookTitle() {
        shelf.add("Effective Java", "Code Complete", "The Mythical Man-Month");
        List<String> books = shelf.arrange();
        assertEquals(Arrays.asList("Code Complete", "Effective Java", "The Mythical Man-Month"), books,
                () -> "Books in a bookshelf should be arranged lexicographically by book title");
    }

    @Test
    void booksInBookShelfAreInInsertionOrderAfterCallingArrange() {
        shelf.add("Effective Java", "Code Complete", "The Mythical Man-Month");
        shelf.arrange();
        List<String> books = shelf.books();
        assertEquals(Arrays.asList("Effective Java", "Code Complete", "The Mythical Man-Month"), books,
                "Books in bookshelf are in insertion order",
    }

    @Test
    void bookshelfArrangedByUserProvidedCriteria() {
        shelf.add("Effective Java", "Code Complete", "The Mythical Man-Month");
        List<String> books = shelf.arrange(Comparator.<String>naturalOrder().reversed());
        assertEquals(Arrays.asList("The Mythical Man-Month", "Effective Java", "Code Complete"), books,
                "Books in bookshelf are in insertion order";
    }
}