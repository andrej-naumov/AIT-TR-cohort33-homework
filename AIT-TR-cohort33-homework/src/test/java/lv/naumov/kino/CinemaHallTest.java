package lv.naumov.kino;

import lv.naumov.kino.CinemaHall;
import lv.naumov.kino.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class CinemaHallTest {
    @Test
    public void testAddMovieToSchedule() {
        String movieTitle = "Movie Title";
        int seatsInHall = 100;
        int soldTicket = 75;
        CinemaHall cinemaHall = new CinemaHall(1, seatsInHall);
        Movie movie = new Movie(movieTitle, LocalDateTime.now(), LocalDateTime.now().plusHours(2), soldTicket);

        cinemaHall.addMovie(movie);
        int availableSeats = cinemaHall.getAvailableSeats(movie);

        Assertions.assertEquals(seatsInHall - soldTicket, availableSeats);
        Assertions.assertEquals(movie.getTitle(), movieTitle);
    }

    @Test
    public void testBookTicket() throws SoldOutException {
        String movieTitle = "Movie Title";
        int seatsInHall = 100;
        int soldTickets = 10;
        int bookTickets = 10;
        CinemaHall cinemaHall = new CinemaHall(2, seatsInHall);
        Movie movie = new Movie(movieTitle, LocalDateTime.now(), LocalDateTime.now().plusHours(1), soldTickets);

        cinemaHall.addMovie(movie);
        cinemaHall.bookTicket(movie, bookTickets);

        Assertions.assertEquals(movie.getSoldTickets(), soldTickets + bookTickets);
        Assertions.assertEquals(cinemaHall.getAvailableSeats(movie), seatsInHall - soldTickets - bookTickets );
    }

    @Test
    public void testScheduleConflictExceptionTimeOverlap() {
        CinemaHall cinemaHall = new CinemaHall(1, 100);
        Movie movie1 = new Movie("Movie 1", LocalDateTime.now(), LocalDateTime.now().plusHours(2), 100);
        Movie movie2 = new Movie("Movie 2", LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(3), 100);

        cinemaHall.addMovie(movie1);

        // Проверяем, что при добавлении второго фильма, который пересекается по времени с первым, будет выброшено исключение
        Assertions.assertThrows(ScheduleConflictException.class, () -> cinemaHall.addMovie(movie2));
    }
}