package lv.naumov.lesson40.bar.drinks;

import lombok.AllArgsConstructor;

import java.util.HashMap;

/**
 * Внутри этого класса создайте HashMap,
 * где ключом будет являться String (ID напитка),
 * а значением — объект класса Drink.
 * <p>
 * Методы:
 * addDrink(String id, Drink drink): добавляет напиток в коллекцию.
 * getDrink(String id): возвращает напиток по ID.
 */
@AllArgsConstructor
public class Bar {
    private HashMap<String, Drink> drinkMap;

    public void addDrink(String key, Drink drink) {
        drinkMap.put(key,drink);
    }
    public Drink getDrink(String id) {
        return drinkMap.get(id);
    }

}
