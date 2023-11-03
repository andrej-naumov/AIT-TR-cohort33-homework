package lv.naumov.lesson44.book.library.test;

import lv.naumov.lesson44.book.library.Book;
import lv.naumov.lesson44.book.library.LibraryCatalog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryCatalogTest {
    private LibraryCatalog libraryCatalog;

    @BeforeEach
    public void setUp() {
        libraryCatalog = new LibraryCatalog();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("Три мушкетёра", "А.Дюма", "ISBN-12345");
        libraryCatalog.addBook(book);
        assertTrue(libraryCatalog.listAllBooks().contains("Три мушкетёра"));
    }

    @Test
    public void testRemoveBook() {
        Book book = new Book("Три мушкетёра", "А.Дюма", "ISBN-12345");
        libraryCatalog.addBook(book);
        libraryCatalog.removeBook("Три мушкетёра");
        assertNull(libraryCatalog.findBookByTitle("Три мушкетёра"));
    }

    @Test
    public void testFindBookByTitle() {
        Book book = new Book("Три мушкетёра", "А.Дюма", "ISBN-12345");
        libraryCatalog.addBook(book);
        Book foundBook = libraryCatalog.findBookByTitle("Три мушкетёра");
        assertNotNull(foundBook);
        assertEquals("Три мушкетёра", foundBook.getTitle());
    }

    @Test
    public void testListAllBooks() {
        Book book1 = new Book("Три мушкетёра", "А.Дюма", "ISBN-12345");
        Book book2 = new Book("Колобок", "Народная сказка", "ISBN-2");
        libraryCatalog.addBook(book1);
        libraryCatalog.addBook(book2);
        String json = libraryCatalog.listAllBooks();
        assertTrue(json.contains("Три мушкетёра"));
        assertTrue(json.contains("Колобок"));
    }
}
