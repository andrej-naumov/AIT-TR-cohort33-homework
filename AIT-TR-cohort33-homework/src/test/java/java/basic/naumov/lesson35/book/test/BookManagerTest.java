package java.basic.naumov.lesson35.book.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import basic.naumov.lesson35.book.Book;
import basic.naumov.lesson35.book.BookManager;

public class BookManagerTest {

    private BookManager bookManager;

    @BeforeEach
    public void setUp() {
        // Инициализация объекта BookManager перед каждым тестом
        bookManager = new BookManager();
    }

    @Test
    public void testAddBook() {
        // Проверка корректного добавления книги
        Book book = new Book("1234567890", "Тестовая книга", "Тестовый автор");
        bookManager.addBook(book);
        assertEquals(1, bookManager.getBooks().size());
    }

    @Test
    public void testAddBookWithDuplicateISBN() {
        // Проверка выбрасывания исключения при попытке добавить книгу с существующим ISBN
        Book book1 = new Book("1234567890", "Тестовая книга", "Тестовый автор");
        bookManager.addBook(book1);

        Book book2 = new Book("1234567890", "Другая книга", "Другой автор");

        assertThrows(IllegalArgumentException.class, () -> {
            bookManager.addBook(book2);
        });
    }

    @Test
    public void testFindBookByISBN() {
        // Проверка поиска книги по ISBN
        Book book = new Book("1234567890", "Тестовая книга", "Тестовый автор");
        bookManager.addBook(book);

        Book foundBook = bookManager.findBookByISBN("1234567890");
        assertNotNull(foundBook);
        assertEquals(book, foundBook);
    }

    @Test
    public void testFindBookByISBNNotFound() {
        // Проверка, что метод возвращает null, если книга с данным ISBN отсутствует
        Book foundBook = bookManager.findBookByISBN("9876543210");
        assertNull(foundBook);
    }

    @Test
    public void testRemoveBook() {
        // Проверка удаления книги по ISBN
        Book book = new Book("1234567890", "Тестовая книга", "Тестовый автор");
        bookManager.addBook(book);

        boolean removed = bookManager.removeBook("1234567890");
        assertTrue(removed);
        assertEquals(0, bookManager.getBooks().size());
    }

    @Test
    public void testRemoveBookNotFound() {
        // Проверка, что метод возвращает false, если книга с данным ISBN отсутствует
        boolean removed = bookManager.removeBook("9876543210");
        assertFalse(removed);
    }
}
