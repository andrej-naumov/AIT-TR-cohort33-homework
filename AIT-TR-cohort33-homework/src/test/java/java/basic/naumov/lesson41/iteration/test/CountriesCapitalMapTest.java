package java.basic.naumov.lesson41.iteration.test;

import basic.naumov.lesson41.iteration.CountriesCapitalMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountriesCapitalMapTest {
    private CountriesCapitalMap countriesCapitalMap;

    @BeforeEach
    void setUp() {
        countriesCapitalMap = new CountriesCapitalMap();
    }

    @Test
    void addCountryAndCapital() {
        assertEquals(0, countriesCapitalMap.getCountries().size());

        countriesCapitalMap.addCountryAndCapital("Чехия", "Прага");
        countriesCapitalMap.addCountryAndCapital("США", "Вашингтон");

        assertTrue(countriesCapitalMap.hasCountry("Чехия"));
        assertEquals("Прага", countriesCapitalMap.getCountries().get("Чехия"));
        assertTrue(countriesCapitalMap.hasCountry("США"));
        assertEquals("Вашингтон", countriesCapitalMap.getCountries().get("США"));

        assertEquals(2, countriesCapitalMap.getCountries().size());
    }

    @Test
    void testReplaceCapital() {
        // Add a country-capital pair
        countriesCapitalMap.addCountryAndCapital("США", "Вашингтон");

        // Replace the capital of an existing country
        countriesCapitalMap.replaceCapital("США", "Сан-Франциско");
        assertEquals("Сан-Франциско", countriesCapitalMap.getCountries().get("США"));
    }

    @Test
    void hasCountry() {
        countriesCapitalMap.addCountryAndCapital("США", "Вашингтон");
        countriesCapitalMap.addCountryAndCapital("Франция", "Париж");

        assertTrue(countriesCapitalMap.hasCountry("США"));
        assertTrue(countriesCapitalMap.hasCountry("Франция"));
        assertFalse(countriesCapitalMap.hasCountry("Германия"));
    }
}