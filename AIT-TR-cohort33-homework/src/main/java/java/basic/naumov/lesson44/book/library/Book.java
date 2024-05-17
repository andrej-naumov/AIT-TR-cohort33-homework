package java.basic.naumov.lesson44.book.library;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Book: Класс, представляющий сущность книги в каталоге
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    private String title;
    private String author;
    private String ISBN;

    @Override
    public String toString() {
        return "Книга{" +
                "Название='" + title + '\'' +
                ", Автор='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}
