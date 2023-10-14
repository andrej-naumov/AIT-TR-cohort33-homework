package lv.naumov.lesson36.superhero;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


public class SuperHero {
	@Getter @Setter	
	private String name;

	@Getter
	private int power;

	@Getter
	@Setter
	private int age;

	public void setPower(int power) {
		// Убедимся, что уровень силы находится в диапазоне от 1 до 10.
		if (power >= 1 && power <= 10) {
			this.power = power;
		} else {
			
		}
	}
}
