package lv.naumov.lesson41.iteration;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;


@Slf4j
public class CountriesCapitalMap {

    final private HashMap<String, String> countries;

    public CountriesCapitalMap() {
        countries = new HashMap<>();
    }

    public void addCountryAndCapital(String country, String capital) {
        // проверить есть ли эта страна, и только если нет добавлять
        if (!countries.containsKey(country)) {
            countries.put(country, capital);
            log.info("Добавлена страна {} со столицей: {} ", country, capital);
        } else {
            log.warn("Страна {} со столицей {} уже существует", country, capital);
        }
    }

    public void replaceCapital(String country, String capital) {
        // если есть эта страна, то поменять столицу, если нет вызвать метод addCountryAndCapital
        if (countries.containsKey(country)) {
            countries.put(country, capital);
            log.info("Столица государства {} заменена на {}", country, capital);
        } else {
            log.info("Государство {} не найдено", country);
        }
    }

    public boolean hasCountry(String country) {
        log.info("Поступил запрос на проверку страны: {}", country);
        if (countries.containsKey(country)) {
            return true;
        } else {
            log.warn("Страны {} в списке нет", country);
            return false;
        }
    }

    public Map<String, String> getCountries() {
        return new HashMap<>(countries);
    }

}
