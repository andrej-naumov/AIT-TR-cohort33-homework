package java.basic.naumov.lesson33.fruit.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.basic.naumov.lesson33.fruit.FruitBags;

public class FruitBagsTest {

    private FruitBags fruitBags;

    @BeforeEach
    public void setUp() {
        fruitBags = new FruitBags();
    }

	
	@SuppressWarnings("unchecked")
	@Test
	public void testAddRemoveFruit() {
		List<String> list1 = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));
		List<String> list2 = new ArrayList<>(Arrays.asList("Apple", "Banana", "Kiwi"));

		// Добавляем фрукты в два списка
		fruitBags.addFruitToLists("Mango", list1, list2);

		// Проверяем, что фрукты успешно добавлены в оба списка
		Assertions.assertTrue(list1.contains("Mango"));
		Assertions.assertTrue(list2.contains("Mango"));

		// Удаляем фрукт из двух списков
		fruitBags.removeFruitFromLists("Cherry", list1, list2);

		// Проверяем, что фрукты успешно удалены из обоих списков
		Assertions.assertFalse(list1.contains("Cherry"));
		Assertions.assertFalse(list2.contains("Cherry"));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testAddFruitToPositionOrEnd() {
		List<String> list1 = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));
		List<String> list2 = new ArrayList<>(Arrays.asList("Apple", "Banana", "Kiwi"));

		// Добавляем фрукт "Mango" на позицию 1 в два списка
		fruitBags.addFruitToPositionOrEnd("Mango", 1, list1, list2);

		// Проверяем, что фрукт успешно добавлен на указанную позицию в оба списка
		Assertions.assertEquals("Mango", list1.get(1));
		Assertions.assertEquals("Mango", list2.get(1));

		// Добавляем фрукт "Grapes" на позицию 10 в два списка (должен быть добавлен в
		// конец)
		fruitBags.addFruitToPositionOrEnd("Grapes", 10, list1, list2);

		// Проверяем, что фрукт успешно добавлен в конец обоих списков
		Assertions.assertEquals("Grapes", list1.get(list1.size() - 1));
		Assertions.assertEquals("Grapes", list2.get(list2.size() - 1));
	}

	@Test
	public void testCompareFruitBags() {
		List<String> list1 = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));
		List<String> list2 = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));

		// Сравниваем два идентичных списка
		boolean result = fruitBags.compareFruitBags(list1, list2);
		Assertions.assertTrue(result);

		list2.add("Kiwi");

		// Сравниваем два различных списка
		result = fruitBags.compareFruitBags(list1, list2);
		Assertions.assertFalse(result);
	}
}
