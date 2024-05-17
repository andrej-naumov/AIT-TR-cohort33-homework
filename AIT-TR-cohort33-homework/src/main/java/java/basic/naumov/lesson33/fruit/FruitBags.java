package java.basic.naumov.lesson33.fruit;

import java.util.LinkedList;
import java.util.List;

public class FruitBags {

	public void displayFruits(List<String> fruitList) {
		for (int i = 0; i < fruitList.size(); i++) {
			System.out.print("\t[" + i + "]" + fruitList.get(i));
		}
		System.out.println();
	}

	public boolean removeFruit(List<String> fruitList, String removeFruit) {
		return fruitList.remove(removeFruit);
	}

	public void removeFruitFromLists(String fruit, @SuppressWarnings("unchecked") List<String>... fruitLists) {
		for (List<String> fruitList : fruitLists) {
			fruitList.remove(fruit);
		}
	}

	public boolean addFruit(List<String> fruitList, String addFruit) {
		return fruitList.add(addFruit);
	}

	public void addFruitToLists(String fruit, @SuppressWarnings("unchecked") List<String>... fruitLists) {
		for (List<String> fruitList : fruitLists) {
			fruitList.add(fruit);
		}
	}

	public void addFruitToPositionOrEnd(String fruit, int position, @SuppressWarnings("unchecked") List<String>... fruitLists) {
		for (List<String> fruitList : fruitLists) {
			addFruitToPositionOrEnd(fruit, position, fruitList);
		}
	}

	public void addFruitToPositionOrEnd(String fruit, int position, List<String> fruitList) {
		if (position < 0 || position >= fruitList.size()) {
			// Если позиция недопустима, добавляем фрукт в конец списка
			fruitList.add(fruit);
		} else {
			// Вставляем фрукт на указанную позицию
			fruitList.add(position, fruit);
		}
	}

	public boolean compareFruitBags(List<String> fruitList1, List<String> fruitList2) {
		if (fruitList1.size() != fruitList2.size()) {
			return false;
		}

		// Сортируем списки для сравнения
		List<String> sortedList1 = new LinkedList<>(fruitList1);
		List<String> sortedList2 = new LinkedList<>(fruitList2);
		sortedList1.sort(String::compareTo);
		sortedList2.sort(String::compareTo);

		return sortedList1.equals(sortedList2);
	}

	public List<String> deepCompare(List<String> fruitList1, List<String> fruitList2) {
		List<String> info = new LinkedList<>();

		for (int i = 0; i < fruitList1.size(); i++) {
			String fruitFromList_1 = fruitList1.get(i);
			if (i < fruitList2.size()) {
				String fruitFromList_2 = fruitList2.get(i);
				if (!fruitFromList_1.equals(fruitFromList_2)) {
					info.add("Различие во фрукте с индексом " + i + ":");
					info.add("List 1[" + i + "] = " + fruitFromList_1);
					info.add("List 2[" + i + "] = " + fruitFromList_2);

					int foundIndex = fruitList1.indexOf(fruitFromList_2);
					if (foundIndex >= 0) {
						info.add("Вы можете найти " + fruitFromList_2 + " в List 1[" + foundIndex + "]");
					}

					foundIndex = fruitList2.indexOf(fruitFromList_1);
					if (foundIndex >= 0) {
						info.add("Вы можете найти " + fruitFromList_1 + " в List 2[" + foundIndex + "]");
					}
				}
			} else {
				info.add("List 2 не содержит фрукта с индексом " + i + ":");
				info.add("List 1[" + i + "] = " + fruitFromList_1);
			}
		}

		for (int i = fruitList1.size(); i < fruitList2.size(); i++) {
			String item2 = fruitList2.get(i);
			info.add("List 1 не содержит фрукта с индексом " + i + ":");
			info.add("List 2[" + i + "] = " + item2);
		}

		return info;
	}
}
