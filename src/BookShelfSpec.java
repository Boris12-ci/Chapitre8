package bookstoread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail; // Import manquant ajouté

public class BookShelfSpec {

    private BookShelf shelf;

    @BeforeEach
    void init() {
        shelf = new BookShelf();
    }

    @Test
    void booksInBookShelfAreInInsertionOrderAfterCallingArrange() {
        shelf.add("Effective Java", "Code Complete", "The Mythical Man-Month");
        shelf.arrange();
        List<String> books = shelf.books();
        assertEquals(Arrays.asList("Effective Java", "Code Complete", "The Mythical Man-Month"), books, "Books in bookshelf are in insertion order");
    }

    @Test
    void bookshelfArrangedByUserProvidedCriteria() {
        shelf.add("Effective Java", "Code Complete", "The Mythical Man-Month");
        List<String> books = shelf.arrange(Comparator.<String>naturalOrder().reversed());
        assertEquals(Arrays.asList("The Mythical Man-Month", "Effective Java", "Code Complete"), books, "Books in bookshelf are in insertion order");
    }

    @Test
    void booksReturnedFromBookShelfIsImmutableForClient() {
        BookShelf shelf = new BookShelf();
        shelf.add("Effective Java", "Code Complete");
        List<String> books = shelf.books();
        try {
            books.add("The Mythical Man-Month");
            fail("Should not be able to add book to books");
        } catch (Exception e) {
            assertTrue(e instanceof UnsupportedOperationException, () -> "Should throw UnsupportedOperationException.");
        }
    }
}