package lv.naumov.lesson36.superhero;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Superhero {
	@Getter
	@Setter
	private String name;

	@Getter
	private int power;

	@Getter
	@Setter
	private int age;

	public Superhero(String name, int power, int age) {
		this.name = name;
		// Убедимся, что уровень силы находится в диапазоне от 1 до 10
		if (power >= 1 && power <= 10) {
			this.power = power;
		} else {
			// Если значение не входит в диапазон, установим по умолчанию 5
			log.error("уровень силы не находится в диапазоне от 1 до 10");
			log.info("значение силы установлено по умолчанию 5");
			this.power = 5;
		}
		this.age = age;
	}

	public void setPower(int power) {
		// Убедимся, что уровень силы находится в диапазоне от 1 до 10.
		if (power >= 1 && power <= 10) {
			this.power = power;
		} else {
			log.error("уровень силы не находится в диапазоне от 1 до 10");
		}
	}

	// Переопределение метода toString
	@Override
	public String toString() {
		return "Имя: " + name + ", Сила: " + power + ", Возраст: " + age;
	}
}
