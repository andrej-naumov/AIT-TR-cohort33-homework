package lv.naumov.lesson38.names;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Введите количество имён: ");
		int count = scanner.nextInt();

		List<String> names = NamesTool.generateNames(new Locale("lv-LV"), count);
		int listSize = names.size();

		Set<String> namesSet = new HashSet<>(names);
		int setSize = namesSet.size();

		System.out.println("Количество всех имён в списке> \t\t" + listSize);
		System.out.println("Количество уникальных имён в коллекции> " + setSize);
		System.out.println("---------------------------------------------------");
		System.out.println("\t\t\t Итого разница> " + (listSize - setSize));

		System.out.print("Вывести повторяющиеся имена (1-да/0-нет): ");
		if (scanner.nextInt() == 1) {
			System.out.println("Повторяющиеся имена:");
			Set<String> repeatedNames = new HashSet<>();
			for (String name : names) {
				if (!repeatedNames.add(name)) {
					System.out.println(name);
				}
			}
		}
		scanner.close();
	}
}
