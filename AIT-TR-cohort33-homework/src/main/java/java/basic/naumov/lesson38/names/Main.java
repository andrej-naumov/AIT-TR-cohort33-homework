package java.basic.naumov.lesson38.names;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Введите количество имён: ");
		int count = scanner.nextInt();

		String[] names = NamesTool.generateNames(new Locale("lv-LV"), count);
		int arraySize = names.length;

		Set<String> namesSet = new HashSet<>(Arrays.asList(names));
		int setSize = namesSet.size();

		System.out.println("Количество всех имён в списке> \t\t" + arraySize);
		System.out.println("Количество уникальных имён в коллекции> " + setSize);
		System.out.println("---------------------------------------------------");
		System.out.println("\t\t\t Итого разница> " + (arraySize - setSize));

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
