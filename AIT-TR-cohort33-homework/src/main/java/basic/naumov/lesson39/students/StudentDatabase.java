package basic.naumov.lesson39.students;

import java.util.HashSet;
import java.util.Set;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * Класс StudentDatabase:
 * 
 * Поля: students (HashSet): коллекция для хранения данных студентов. Методы:
 * Конструктор для инициализации коллекции students. addStudent(Student
 * student): должен добавлять объект Student в students, если такого студента
 * еще нет в базе данных. removeStudent(Student student): должен удалять объект
 * Student из students, если он там есть. containsStudent(Student student):
 * должен проверять, содержится ли объект Student в students.
 * printAllStudents(): должен выводить на экран данные всех студентов в
 * students.
 * 
 * возможность расширения функциональности, добавив дополнительные методы в
 * StudentDatabase, например, для поиска студента по имени или для получения
 * списка студентов в определенном возрастном диапазоне.
 */

@Slf4j
public class StudentDatabase {

	private static final String MSG_PRINT_ALL = "Список всех студентов в базе данных:";
	private static final String MSG_PRINT_NAMES = "Список студентов с именем %s";
	private static final String MSG_PRINT_AGE_RANGE = "Список студентов с возрастом от %s до %s";
	private static final String MSG_EMPTY = "Список студентов пуст";

	private Set<Student> students;

	public StudentDatabase() {
		students = new HashSet<>();
	}

	public boolean addStudent(@NonNull Student student) {		
		if (!students.contains(student)) {
			students.add(student);
			log.info("Студент с id: " + student.getId() + " и именем: \"" + student.getName()
					+ "\" добавлен в базу данных.");
			return true;
		}

		log.info("Студент с id: " + student.getId() + " и именем: " + student.getName() + " уже есть в базе данных.");
		return false;
	}

	public boolean removeStudentById(int studentId) {
		Student studentToRemove = null;

		for (Student student : students) {
			if (student.getId() == studentId) {
				studentToRemove = student;
				break;
			}
		}

		if (studentToRemove != null) {
			String studentName = findStudentById(studentId).getName();
			students.remove(studentToRemove);
			log.info("Студент \"" + studentName + "\" с ID " + studentId
					+ " удален из базы данных.");
			return true;
		} else {
			log.info("Студент с ID " + studentId + " не найден в базе данных.");
			return false;
		}
	}

	public boolean containsStudent(Student student) {
		return students.contains(student);
	}

	/*
	 * Поиск со звёздочкой> если в строке запроса стоит звёздочка в начале или
	 * конце, это означает любой символ, если звёздочки нет, то ищем точно по слову
	 */
	public Set<Student> findStudentsByName(String name) {
		Set<Student> studentsByName = new HashSet<>();
		boolean wildcardAtStart = name.startsWith("*");
		boolean wildcardAtEnd = name.endsWith("*");

		if (wildcardAtStart) {
			name = name.substring(1);
		}

		if (wildcardAtEnd) {
			name = name.substring(0, name.length() - 1);
		}

		for (Student student : students) {
			if ((wildcardAtStart && wildcardAtEnd) || student.getName().contains(name)) {
				studentsByName.add(student);
			} else if (wildcardAtStart && student.getName().endsWith(name)) {
				studentsByName.add(student);
			} else if (wildcardAtEnd && student.getName().startsWith(name)) {
				studentsByName.add(student);
			} else if (!wildcardAtStart && !wildcardAtEnd && student.getName().equals(name)) {
				studentsByName.add(student);
			}
		}

		return studentsByName;
	}

	public Set<Student> getStudentsInAgeRange(int minAge, int maxAge) {
		Set<Student> studentsInAgeRange = new HashSet<>();
		for (Student student : students) {
			if (student.getAge() >= minAge && student.getAge() <= maxAge) {
				studentsInAgeRange.add(student); // Добавляем студента в set
			}
		}
		return studentsInAgeRange;
	}

	/*
	 * стоит в условии задачи
	 */
	public void printAllStudents() {
		printStudents(this.students, MSG_PRINT_ALL);
	}

	/*
	 * не обязательно в этом классе
	 */
	public void printStudentsByName(String searchName) {
		printStudents(findStudentsByName(searchName), String.format(MSG_PRINT_NAMES, searchName));
	}

	/*
	 * не обязательно в этом классе
	 */
	public void printStudentsByAge(int minAge, int maxAge) {
		printStudents(getStudentsInAgeRange(minAge, maxAge), String.format(MSG_PRINT_AGE_RANGE, minAge, maxAge));
	}

	private Student findStudentById(int studentId) {
		for (Student student : students) {
			if (student.getId() == studentId) {
				return student;
			}
		}
		return null; // Если студент с указанным ID не найден
	}

	private void printStudents(Set<Student> students, String message) {
		if(students.isEmpty()) {
			System.out.println(MSG_EMPTY);
			return;
		}
		
		System.out.println(message);
		for (Student student : students) {
			System.out.println(
					"ID: " + student.getId() + "\t\t Фамилия: " + student.getName() + "\t\t\t Возраст: " + student.getAge());
		}
	}

}
