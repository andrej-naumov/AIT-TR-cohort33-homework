package lv.naumov.lesson39.students;

import java.util.Scanner;

import com.github.javafaker.Faker;

public class Main {

	public static void main(String[] args) {
		int nextId = 1;
		Faker faker = new Faker(new java.util.Locale("ru", "RU"));
		StudentDatabase database = new StudentDatabase();

		Scanner scanner = new Scanner(System.in);

		System.out.print("Введите количество студентов: ");
		int numberOfStudents = scanner.nextInt();

		for (int i = 0; i < numberOfStudents; i++) {
			String name = faker.name().lastName();
			int age = faker.number().numberBetween(18, 30); // Генерация случайного возраста от 18 до 30 лет
			Student student = new Student(nextId, name, age);
			database.addStudent(student);
			nextId++;
		}

		while (true) {
			System.out.println("Меню:");
			System.out.println("1. Добавить студента");
			System.out.println("2. Удалить студента");
			System.out.println("3. Найти студентов по имени");
			System.out.println("4. Найти студентов по возрасту");
			System.out.println("5. Показать всех студетов");
			System.out.println("0. Выйти из программы");
			System.out.print("Выберите опцию: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Чтобы перевести курсор на новую строку после ввода числа

			switch (choice) {
			case 0:
				System.out.println("Выход из программы.");
				scanner.close();
				System.exit(0);
			case 1:
				// Опция для добавления студента
				System.out.println("Введите имя студента:");
				String name = scanner.nextLine(); // Считываем имя с консоли
				System.out.println("Введите возраст студента:");
				int age = scanner.nextInt(); // Считываем возраст с консоли
				scanner.nextLine(); // Очищаем перевод строки после ввода возраста

				Student newStudent = new Student(nextId, name, age);
				database.addStudent(newStudent);
				nextId++;
				System.out.println("Студент " + newStudent.getName() + " добавлен с id " + newStudent.getId());
				
				break;
			case 2:
				// Опция для удаления студента
				System.out.println("Введите ID студента, которого вы хотите удалить:");
				int idToDelete = scanner.nextInt();
				scanner.nextLine(); // Очищаем перевод строки после ввода ID

				if (database.removeStudentById(idToDelete)) {
					System.out.println("Студент успешно удален.");
				} else {
					System.out.println("Студент не найден.");
				}

				break;
			case 3:
				// Опция для поиска студентов по имени
				System.out.println("Введите имя студента (или часть имени):");
				String searchName = scanner.nextLine();
				database.printStudentsByName(searchName);

				break;
			case 4:
				// Опция для поиска студентов по возрасту
				System.out.println("Введите минимальный возраст:");
				int minAge = scanner.nextInt();
				System.out.println("Введите максимальный возраст:");
				int maxAge = scanner.nextInt();
				database.printStudentsByAge(minAge, maxAge);

				break;
			case 5:
				database.printAllStudents();
				break;
			default:
				System.out.println("Некорректный выбор опции. Попробуйте снова.");
			}

		}
	}
}
