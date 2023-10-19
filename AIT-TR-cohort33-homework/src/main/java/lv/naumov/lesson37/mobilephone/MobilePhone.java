package lv.naumov.lesson37.mobilephone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Разработка классов модели:
 * 
 * MobilePhone: класс, представляющий мобильный телефон с атрибутами, такими как
 * id, brand, model, operatingSystem и price. Класс должен включать
 * конструкторы, методы доступа (геттеры и сеттеры)
 */
@AllArgsConstructor
@ToString
public class MobilePhone {

	@Getter
	@Setter
	private int id;
	@Getter
	@Setter
	private String brand;
	@Getter
	@Setter
	private String model;
	@Getter
	@Setter
	private String operatingSystem;
	@Getter
	@Setter
	private double price;
}
