package java.basic.naumov.lesson40.bar.drinks;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
@AllArgsConstructor
public class Bar {
    private HashMap<String, Drink> drinkMap;

    public void addDrink(String key, Drink drink) {
        log.info("В Бар будет записано>" + key + " с названием> " + drink);
        drinkMap.put(key,drink);
    }
    public Drink getDrink(String id) {
        Drink drink = drinkMap.get(id);
        log.info("Достаём из бара: " + drink);
        return drink;
    }

}
