<<<<<<< HEAD
package lv.naumov.lesson40.bar.drinks;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

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
	
	private Map<String, Drink> drinks;
	
    public Bar() {
		super();
		this.drinks = new HashMap<>();
	}

    public void addDrink(String key, Drink drink) {
        this.drinks.put(key,drink);
    }
    public Drink getDrink(String id) {
        return drinks.get(id);
    }

}
=======
package lv.naumov.lesson40.bar.drinks;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;

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
>>>>>>> branch 'master' of https://github.com/andrej-naumov/AIT-TR-cohort33-homework.git
