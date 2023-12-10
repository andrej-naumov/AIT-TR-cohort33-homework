package lv.naumov.kino;

import lv.naumov.kino.CinemaHall;
import lv.naumov.kino.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class CinemaHallTest {
    @Test
    public void testAddMovieToSchedule() {
        CinemaHall cinemaHall = new CinemaHall(1, 100);
        Movie movie = new Movie("Movie Title", LocalDateTime.now(), LocalDateTime.now().plusHours(2), 75);

        cinemaHall.addMovie(movie);
        int availableSeats = cinemaHall.getAvailableSeats(movie);

        Assertions.assertEquals(25, availableSeats);
    }
}