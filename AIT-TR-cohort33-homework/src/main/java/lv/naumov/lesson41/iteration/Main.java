package lv.naumov.lesson41.iteration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String> countriesToAdd = Arrays.asList("США", "Великобритания", "Франция", "Чехия", "Германия" ,"Франция");

        // ARRAY-LIST
        // Создайте объект с названием countriesList
        CountriesInArrayList countriesList = new CountriesInArrayList();
        // Добавьте в countriesList следующие страны: США, Великобритания, Франция, Чехия, Германия ,Франция
        countriesList.addCountries(countriesToAdd);
        // Выведите на экран размер countriesList
        printCountries(countriesList.getCountriesList());
        // Удалите дубликаты из countriesList и выведите список снова.
        countriesList.removeDuplicateCountries();
        printCountries(countriesList.getCountriesList());

        // HASH-SET
        // Создайте объект с названием countriesSet
        CountriesInSet countriesSet = new CountriesInSet();
        // Добавьте в countriesSet те же страны, что и в countriesList
        countriesSet.addCountries(countriesToAdd);
        // Выведите на экран размер countriesSet
        // Выведите на экран все элементы countriesSet
        printCountries(countriesSet.getCountries());

        // HASH-MAP
        // Создайте объект с названием capitalMap.
        CountriesCapitalMap countriesMap = new CountriesCapitalMap();
        // Добавьте следующие страны и их столицы: - Чехия - Прага - США - Вашингтон - Великобритания - Лондон - Франция - Париж - Германия - Берлин c. Выведите на экран размер capitalMap.
        countriesMap.addCountryAndCapital("Чехия", "Прага");
        countriesMap.addCountryAndCapital("США", "Вашингтон");
        countriesMap.addCountryAndCapital("Великобритания", "Лондон");
        countriesMap.addCountryAndCapital("Франция", "Париж");
        countriesMap.addCountryAndCapital("Германия", "Берлин");
        // Выведите на экран размер capitalMap.
        // выведите все пары страна-столица из capitalMap
        printCountries(map2String(countriesMap.getCountries()));

        // Дополнительные задания
        // Проверьте, содержит ли countriesSet страну "Испания".
        if( !countriesSet.hasCountry("Испания")){
            // Если нет, добавьте "Испания" в countriesSet
            countriesSet.addCountry("Испания");
        }
        printCountries(countriesSet.getCountries());

        // Проверьте, содержит ли Map страну "Испания".
        // Если нет, добавьте "Испания"  и "Мадрид" в capitalMap как столицу Испании.
        if( !countriesMap.hasCountry("Испания")) {
            countriesMap.addCountryAndCapital("Испания", "Мадрид");
        }
        printCountries(map2String(countriesMap.getCountries()));
    }

    private static void printCountries(List<String> countriesList) {
        System.out.println("-----");
        System.out.println("Список стран содержит элементов: " + countriesList.size());
        countriesList.forEach(System.out::println);
        System.out.println("-----");
    }

    private static List<String> map2String (Map<String, String> countriesMap) {
        List<String> map2List = new ArrayList<>();
        countriesMap.forEach((key, value) -> map2List.add(key + " -> " + value));
    return map2List;
    }

}
