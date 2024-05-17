package java.basic.naumov.lesson41.iteration;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class CountriesInSet {

    final private Set<String> countries;

    public CountriesInSet() {
        countries = new HashSet<>();
    }

    public void addCountries(List<String> countries) {
        this.countries.addAll(countries);
    }

    public void addCountry(String country) {
        if (!countries.contains(country)) {
            countries.add(country);
            log.info("Добавлена страна: {}", country);
        }
    }

    public boolean hasCountry(String country) {
        log.info("Поступил запрос на проверку страны: {}", country);
        if (countries.contains(country)) {
            log.info("Страна {} находится в списке", country);
            return true;
        } else {
            log.warn("Страны {} в списке нет", country);
            return false;
        }
    }

    public List<String> getCountries() {
        return new ArrayList<>(countries);
    }
}
