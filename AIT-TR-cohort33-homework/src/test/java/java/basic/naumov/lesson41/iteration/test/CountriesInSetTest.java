package java.basic.naumov.lesson41.iteration.test;

import basic.naumov.lesson41.iteration.CountriesInSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CountriesInSetTest {

    private CountriesInSet countries;

    @BeforeEach
    void setUp() {
        countries = new CountriesInSet();
    }

    @Test
    void testAddCountries() {
        assertEquals(0, countries.getCountries().size());
        // добавляем с дубликатом
        List<String> countriesToAdd = Arrays.asList("США", "Великобритания", "Франция", "Чехия", "Германия", "Франция");
        countries.addCountries(countriesToAdd);
        int expectedSize = countriesToAdd.size() - 1;
        assertEquals(expectedSize, countries.getCountries().size());
    }

    @Test
    void testGetCountries() {
        List<String> countriesToAdd = Arrays.asList("США", "Великобритания", "Франция", "Чехия", "Германия");
        countries.addCountries(countriesToAdd);

        assertTrue(countries.getCountries().contains("США"));
        assertTrue(countries.getCountries().contains("Великобритания"));
        assertTrue(countries.getCountries().contains("Франция"));
        assertTrue(countries.getCountries().contains("Чехия"));
        assertTrue(countries.getCountries().contains("Германия"));
    }

    @Test
    void testGetCountriesCount() {
        assertEquals(0, countries.getCountries().size());
        List<String> countriesToAdd = Arrays.asList("США", "Великобритания");
        countries.addCountries(countriesToAdd);
        assertEquals(countriesToAdd.size(), countries.getCountries().size());
    }
}

