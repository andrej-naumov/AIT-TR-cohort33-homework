package lv.naumov.lesson37.mobilephone;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
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
	private UUID id;
	@Getter
	private String brand;
	@Getter
	private String model;
	@Getter
	private String operatingSystem;
	@Getter
	private double price;
}
