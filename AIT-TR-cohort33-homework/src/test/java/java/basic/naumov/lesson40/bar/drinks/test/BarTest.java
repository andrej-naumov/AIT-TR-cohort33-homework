package java.basic.naumov.lesson40.bar.drinks.test;

import java.basic.naumov.lesson40.bar.drinks.Bar;
import java.basic.naumov.lesson40.bar.drinks.Drink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class BarTest {
    private Bar bar;
    @BeforeEach
    public void setUp() {
        bar = new Bar(new HashMap<>());
    }

    @Test
    public void testAddDrink() {
        Drink drink = new Drink("Маргарита", "Алкогольный", 200.0);
        bar.addDrink("1", drink);
        assertEquals(drink, bar.getDrink("1"));
    }

    @Test
    public void testAddDrinkWithDuplicateID() {
        Drink drink1 = new Drink("Молоко", "Безалкогольный", 300.0);
        Drink drink2 = new Drink("Молотова", "Охеренный", 250.0);

        bar.addDrink("1", drink1);
        // добавить напиток с уже существующим ID
        bar.addDrink("1", drink2);

        assertNotEquals(drink1, bar.getDrink("1"));
        assertEquals(drink2, bar.getDrink("1"));
    }

    @Test
    public void testGetDrink() {
        Drink drink = new Drink("Спрайт", "Безалкогольный", 355.0);
        bar.addDrink("2", drink);
        assertEquals(drink, bar.getDrink("2"));
    }

    @Test
    public void testGetNonExistentDrink() {
        assertNull(bar.getDrink("3"));
    }
}