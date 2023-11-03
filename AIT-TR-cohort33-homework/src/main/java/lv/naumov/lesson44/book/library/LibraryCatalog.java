package lv.naumov.lesson44.book.library;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * LibraryCatalog: Класс для управления коллекцией книг,
 * включая методы addBook, removeBook, findBookByTitle, и listAllBooks.
 */
public class LibraryCatalog {
    private final List<Book> books;
    ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger LOGGER = Logger.getLogger(LibraryCatalog.class.getName());
    Logger myFileLogger = Logger.getLogger("MyLogger");

    public LibraryCatalog() {
        books = new ArrayList<>();
        try {
            FileHandler fileHandler = new FileHandler("myLibraryLog.log");
            myFileLogger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addBook(Book book) {
        books.add(book);
        LOGGER.info("Добавлена книга: " + book.getTitle());
        myFileLogger.setLevel(Level.INFO);
    // только для теста запись в файл
        myFileLogger.info("Добавлена книга: " + book.getTitle());
    }

    public void removeBook(String title) {
        Book bookToRemove = null;
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            LOGGER.info("Удалена книга: " + title);
        } else {
            LOGGER.severe("Книга для удаления не найдена: " + title);
        }
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                LOGGER.info("Найдена книга: " + book.getTitle());
                return book;
            }
        }
        LOGGER.severe("Книга не найдена: " + title);
        return null;
    }

    public String listAllBooks() {
        String json = null;
        try {
            // Serialize the list to JSON
             json = objectMapper.writeValueAsString(books);
            LOGGER.info("Книги в формате JSON ---> " + json);

        } catch (Exception e) {
            LOGGER.severe("Ошибка преобразования списка книг в JSON");
            e.printStackTrace();
        }
        return json;
    }
}

