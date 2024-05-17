package java.basic.naumov.lesson41.iteration.test;

import basic.naumov.lesson41.iteration.CountriesInArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountriesInArrayTest {
    private CountriesInArrayList countries;

    @BeforeEach
    void setUp() {
        countries = new CountriesInArrayList();
    }

    @Test
    void testAddCountries() {
        Assertions.assertEquals(0, countries.getCountriesList().size());
        List<String> countriesToAdd = Arrays.asList("США", "Великобритания", "Франция", "Чехия", "Германия", "Франция");
        countries.addCountries(countriesToAdd);

        // Проверяем, все ли страны зашли к нам
        assertEquals(countriesToAdd.size(), countries.getCountriesList().size());
    }

    @Test
    void testRemoveDuplicateCountries() {
        List<String> countriesToAdd = Arrays.asList("США", "Великобритания", "Франция", "Чехия", "Германия", "Франция");
        countries.addCountries(countriesToAdd);

        countries.removeDuplicateCountries();
        // Убираем из списка Францию
        List<String> expectedList = Arrays.asList("США", "Великобритания", "Франция", "Чехия", "Германия");
        assertEquals(expectedList, countries.getCountriesList());
    }
}