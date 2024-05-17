package java.basic.naumov.lesson35.book.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.basic.naumov.lesson35.book.Book;

public class BookTest {

	private Book book;

	@BeforeEach
	public void setUp() {
		// Инициализация объекта Book перед каждым тестом
		book = new Book("1234567890", "Тестовая книга", "Тестовый автор");
	}

	@Test
	public void testConstructor() {
		// Проверка конструктора: убедимся, что объект Book инициализируется корректно
		assertNotNull(book);
		assertEquals("1234567890", book.getIsbn());
		assertEquals("Тестовая книга", book.getTitle());
		assertEquals("Тестовый автор", book.getAuthor());
	}

	@Test
	public void testSetIsbn() {
		// Проверка сеттера для ISBN
		book.setIsbn("9876543210");
		assertEquals("9876543210", book.getIsbn());
	}

	@Test
	public void testSetTitle() {
		// Проверка сеттера для названия книги
		book.setTitle("Новое название");
		assertEquals("Новое название", book.getTitle());
	}

	@Test
	public void testSetAuthor() {
		// Проверка сеттера для автора
		book.setAuthor("Новый автор");
		assertEquals("Новый автор", book.getAuthor());
	}
}
