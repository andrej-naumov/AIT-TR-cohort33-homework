package java.basic.naumov.lesson41.iteration;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CountriesInArrayList {
    private final List<String> countriesList;

    public CountriesInArrayList() {
        this.countriesList = new ArrayList<>();
    }

    public void addCountries(List<String> countriesList) {
        this.countriesList.addAll(countriesList);
    }

    public List<String> getCountriesList() {
        return new ArrayList<>(countriesList);
    }

    public void removeDuplicateCountries() {
        Set<String> uniqueCountries = new LinkedHashSet<>(this.countriesList);
        this.countriesList.clear();
        this.countriesList.addAll(uniqueCountries);
    }
}
