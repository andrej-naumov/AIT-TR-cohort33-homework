package lv.naumov.lesson44.book.library;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();
        ObjectMapper objectMapper = new ObjectMapper();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Меню библиотеки:");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Удалить книгу");
            System.out.println("3. Найти книгу по названию");
            System.out.println("4. Вывести список всех книг");
            System.out.println("5. Выход");
            System.out.print("Введите ваш выбор: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Введите название книги: ");
                    String title = scanner.nextLine();
                    System.out.print("Введите автора: ");
                    String author = scanner.nextLine();
                    System.out.print("Введите ISBN: ");
                    String isbn = scanner.nextLine();
                    Book book = new Book(title, author, isbn);
                    catalog.addBook(book);
                    break;
                case "2":
                    System.out.print("Введите название книги для удаления: ");
                    String bookTitleToRemove = scanner.nextLine();
                    catalog.removeBook(bookTitleToRemove);
                    break;
                case "3":
                    System.out.print("Введите название книги для поиска: ");
                    String bookTitleToFind = scanner.nextLine();
                    Book foundBook = catalog.findBookByTitle(bookTitleToFind);
                    if (foundBook != null) {
                        System.out.println("Название: " + foundBook.getTitle() + ", Автор: " + foundBook.getAuthor() + ", ISBN: " + foundBook.getISBN());
                    }
                    break;
                case "4":
                    String json = catalog.listAllBooks();

                    try {
                        // Parse the JSON array into an ArrayList of MyObject instances
                        ArrayList<Book> books = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Book.class));

                        if(books.isEmpty()) {
                            System.out.println("Каталог книг пустой");
                            break;
                        }
                        // Now you have the ArrayList of objects
                        for (Book myBook : books) {
                            System.out.println("Название: " + myBook.getTitle() + ", Автор: " + myBook.getAuthor() + ", ISBN: " + myBook.getISBN());
                        }
                    } catch (Exception e) {
                        // TODO LOGGER
                        e.printStackTrace();
                    }

                    break;
                case "5":
                    System.out.println("Завершение работы приложения.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }
}
