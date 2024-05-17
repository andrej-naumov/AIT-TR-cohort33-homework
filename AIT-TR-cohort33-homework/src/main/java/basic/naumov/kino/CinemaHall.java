package basic.naumov.kino;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс CinemaHall
 * Поля:
 * int hallNumber: Номер кинозала.
 * List<Movie> moviesSchedule: Список фильмов в расписании зала.
 * Методы:
 * void addMovie(Movie movie): Добавляет фильм в расписание, предварительно
 * проверив на пересечение времени показа с уже запланированными фильмами.
 * boolean isScheduleConflict(LocalDateTime newMovieStart,
 * LocalDateTime newMovieEnd): Проверяет наличие пересечения времени сеансов.
 */
@Slf4j
public class CinemaHall {
    private int hallNumber;
    private List<Movie> moviesSchedule;

    private int seats;

    private static final long MINIMUM_INTERVAL_BETWEEN_MOVIES_MINUTES = 15;


    public CinemaHall(int hallNumber, int seats) {
        this.hallNumber = hallNumber;
        this.seats = seats;
        this.moviesSchedule = new ArrayList<>();
    }

    public void addMovie(Movie movie) throws ScheduleConflictException{
        try {
            checkScheduleConflict(movie);
            moviesSchedule.add(movie);
            log.info("Фильм \"" + movie.getTitle() + "\" добавлен в расписание зала " + hallNumber);
        } catch (IllegalArgumentException | ScheduleConflictException e) {
            log.error(e.getMessage());
            throw new ScheduleConflictException(e.getMessage());
        }
    }

    private void checkScheduleConflict(Movie newMovie) throws ScheduleConflictException {
        for (Movie scheduledMovie : moviesSchedule) {
            if (scheduledMovie.isTimeOverlapping(newMovie)) {
                throw new ScheduleConflictException("Конфликт времени! Фильм \"" + newMovie.getTitle() + "\" не может быть добавлен.");
            }

            LocalDateTime endOfScheduledMoviePlusInterval = scheduledMovie.getEndTime()
                    .plusMinutes(MINIMUM_INTERVAL_BETWEEN_MOVIES_MINUTES);
            if (endOfScheduledMoviePlusInterval.isAfter(newMovie.getStartTime())) {
                throw new ScheduleConflictException("Не успеваем проветрить зал и убрать мусор для фильма \"" + newMovie.getTitle() + "\".");
            }
        }
    }

    public void bookTicket(Movie movie, int numOfTickets) throws SoldOutException {
        if (!moviesSchedule.contains(movie)) {
            throw new IllegalArgumentException("Фильм \"" + movie.getTitle() + "\" не найден в расписании.");
        }

        int availableSeats = getAvailableSeats(movie);
        if (availableSeats >= numOfTickets) {
            // Продажа билетов
            movie.setSoldTickets(movie.getSoldTickets() + numOfTickets);
            log.info("Продано " + numOfTickets + " билетов для фильма \"" + movie.getTitle() + "\".");
        } else {
            throw new SoldOutException("Недостаточно свободных билетов для фильма \"" + movie.getTitle() + "\".");
        }
    }

    public int getAvailableSeats(Movie movie) {
        // Это может быть сравнение общего количества билетов на фильм с уже проданными билетами
        return seats - movie.getSoldTickets();
    }
}
