package basic.naumov.lesson37.mobilephone;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

/**
 * Разработка класса управления инвентарем:
 * 
 * InventoryManagement: класс должен содержать List<MobilePhone>, который будет
 * использоваться для хранения объектов MobilePhone. Необходимо реализовать
 * методы для выполнения следующих операций: addMobilePhone(MobilePhone phone):
 * добавление нового мобильного телефона в список. getMobilePhone(int id): поиск
 * и получение мобильного телефона по ID. updateMobilePhone(MobilePhone phone):
 * обновление информации о существующем мобильном телефоне.
 * deleteMobilePhone(int id): удаление мобильного телефона по ID.
 * listMobilePhones(): получение списка всех мобильных телефонов в инвентаре.
 */
@Slf4j
public class InventoryManagement {
	private List<MobilePhone> inventory;

	public InventoryManagement() {
		this.inventory = new ArrayList<>();
	}

	public void addMobilePhone(MobilePhone phone) {
		inventory.add(phone);
	}

	public MobilePhone getMobilePhone(UUID id) {
		log.info("Поиск мобильного телефона с указанным ID " + id);
		for (MobilePhone phone : inventory) {
			if (phone.getId() == id) {
				log.info("Мобильный телефона с указанным ID " + id + " найден " + phone);
				return phone;
			}
		}
		log.info("Мобильный телефон с указанным ID " + id + " не найден");
		return null;
	}

	public boolean updateMobilePhone(MobilePhone updatedPhone) {
		for (int i = 0; i < inventory.size(); i++) {
			MobilePhone phone = inventory.get(i);
			if (phone.getId() == updatedPhone.getId()) {
				log.info("Информация о мобильном телефоне с ID " + phone.getId() + " будет обновлена: " + phone);
				inventory.set(i, updatedPhone);
				log.info(
						"Информация о мобильном телефоне с ID " + updatedPhone.getId() + " обновлена: " + updatedPhone);
				return true;
			}
		}
		log.info("Мобильный телефон с ID " + updatedPhone.getId() + " не найден, информация не может быть обновлена.");
		return false;
	}

	public boolean deleteMobilePhone(UUID id) {
		// стрелочная функция
		boolean removed = inventory.removeIf(phone -> {
	        if (phone.getId().equals(id)) {
	            return true;
	        }
	        return false;
	    });

	    if (removed) {
	    	log.info("Мобильный телефон с ID " + id + " удален из инвентаря.");
	        return true;
	    } else {
	        log.info("Мобильный телефон с ID " + id + " не найден в инвентаре и не может быть удален.");
	        return false;
	    }
	}

	/*
	 * использовать для поиска мобильных телефонов по их марке
	 */
    public List<MobilePhone> searchByBrand(String brand) {
        List<MobilePhone> result = new ArrayList<>();
        for (MobilePhone phone : inventory) {
            if (phone.getBrand().equalsIgnoreCase(brand)) {
                result.add(phone);
            }
        }
        log.info("Поиск мобильных телефонов марки " + brand + ": найдено " + result.size() + " мобильных телефонов.");
        return result;
    }

	public List<MobilePhone> listMobilePhones() {
		return new ArrayList<>(inventory);
	}

	public List<MobilePhone> listMobilePhonesSortedByName() {
		return inventory.stream()
				.sorted(Comparator.comparing(MobilePhone::getBrand).thenComparing(MobilePhone::getModel))
				.collect(Collectors.toList());
	}

	public List<MobilePhone> listMobilePhonesSortedByPrice() {
		return inventory.stream().sorted(Comparator.comparingDouble(MobilePhone::getPrice))
				.collect(Collectors.toList());
	}
}
