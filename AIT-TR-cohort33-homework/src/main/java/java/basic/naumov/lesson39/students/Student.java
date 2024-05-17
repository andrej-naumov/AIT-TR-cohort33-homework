package java.basic.naumov.lesson39.students;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс Student:
 * 
 * Поля: id (int): уникальный идентификатор студента. name (String): имя
 * студента. age (int): возраст студента. Методы: Конструктор для инициализации
 * всех полей. Геттеры/Сеттеры.
 */
@Getter
@Setter
@AllArgsConstructor
public class Student {
	private int id;
	private String name;
	private int age;

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Student student = (Student) obj;
		return id == student.id;
	}
}
