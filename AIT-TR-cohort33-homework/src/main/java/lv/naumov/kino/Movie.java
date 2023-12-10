package lv.naumov.kino;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 1. Класс Movie
 * Поля:
 * String title: Название фильма.
 * LocalDateTime startTime: Время начала показа фильма.
 * LocalDateTime endTime: Время окончания показа фильма.
 * Методы:
 * Конструктор для инициализации всех полей.
 * Геттеры для title, startTime, и endTime.
 * Метод для проверки, не пересекаются ли времена показа с другими фильмами
 */
@Setter
@Getter
@AllArgsConstructor
public class Movie {
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int soldTickets;

    // Метод для проверки, не пересекаются ли времена показа с другими фильмами
    public boolean isTimeOverlapping(Movie otherMovie) {
        return (this.startTime.isBefore(otherMovie.endTime) && this.endTime.isAfter(otherMovie.startTime)) ||
                (this.startTime.isEqual(otherMovie.endTime) || this.endTime.isEqual(otherMovie.startTime));
    }
}
