package lv.naumov.lesson37.mobilephone.test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lv.naumov.lesson37.mobilephone.InventoryManagement;
import lv.naumov.lesson37.mobilephone.MobilePhone;

public class InventoryManagementTest {
	private InventoryManagement inventory;

	@BeforeEach
	public void setUp() {
		inventory = new InventoryManagement();
	}

	@Test
	public void testAddMobilePhone() {
		MobilePhone phone = new MobilePhone(1, "Samsung", "Galaxy S20", "Android", 799.99);
		inventory.addMobilePhone(phone);
		assertEquals(1, inventory.listMobilePhones().size());
	}

	@Test
	public void testGetMobilePhoneNotNull() {
		MobilePhone phone = new MobilePhone(1, "Samsung", "Galaxy S20", "Android", 799.99);
		inventory.addMobilePhone(phone);
		MobilePhone retrievedPhone = inventory.getMobilePhone(1);
		assertNotNull(retrievedPhone);
		assertEquals("Samsung", retrievedPhone.getBrand());
	}

	@Test
	public void testGetMobilePhoneNull() {
		MobilePhone phone = new MobilePhone(1, "Samsung", "Galaxy S20", "Android", 799.99);
		inventory.addMobilePhone(phone);
		MobilePhone retrievedPhone = inventory.getMobilePhone(2);
		assertNull(retrievedPhone);
	}

	@Test
	public void testUpdateMobilePhone() {
		MobilePhone phone = new MobilePhone(1, "Samsung", "Galaxy S20", "Android", 799.99);
		inventory.addMobilePhone(phone);

		MobilePhone updatedPhone = new MobilePhone(1, "Apple", "iPhone 12", "iOS", 899.99);
		inventory.updateMobilePhone(updatedPhone);

		MobilePhone retrievedPhone = inventory.getMobilePhone(1);
		assertNotNull(retrievedPhone);
		assertEquals("Apple", retrievedPhone.getBrand());
	}

	@Test
	public void testDeleteMobilePhone() {
		MobilePhone phone = new MobilePhone(1, "Samsung", "Galaxy S20", "Android", 799.99);
		inventory.addMobilePhone(phone);
		inventory.deleteMobilePhone(1);
		assertEquals(0, inventory.listMobilePhones().size());
	}

	@Test
	public void testListMobilePhones() {
		MobilePhone phone1 = new MobilePhone(1, "Samsung", "Galaxy S20", "Android", 799.99);
		MobilePhone phone2 = new MobilePhone(2, "Apple", "iPhone 12", "iOS", 899.99);

		inventory.addMobilePhone(phone1);
		inventory.addMobilePhone(phone2);

		assertEquals(2, inventory.listMobilePhones().size());
	}

	@Test
	public void testSearchByBrand() {
		MobilePhone phone1 = new MobilePhone(1, "Samsung", "Galaxy S20", "Android", 799.99);
		MobilePhone phone2 = new MobilePhone(2, "Apple", "iPhone 12", "iOS", 899.99);
		MobilePhone phone3 = new MobilePhone(3, "Samsung", "Galaxy S21", "Android", 899.99);

		inventory.addMobilePhone(phone1);
		inventory.addMobilePhone(phone2);
		inventory.addMobilePhone(phone3);

		List<MobilePhone> samsungPhones = inventory.searchByBrand("Samsung");
		assertEquals(2, samsungPhones.size());
	}

	@Test
	public void testListMobilePhonesSortedByName() {
		MobilePhone phone1 = new MobilePhone(1, "Samsung", "Galaxy S20", "Android", 799.99);
		MobilePhone phone2 = new MobilePhone(2, "Apple", "iPhone 12", "iOS", 899.99);
		MobilePhone phone3 = new MobilePhone(3, "Samsung", "Galaxy S21", "Android", 699.99);

		inventory.addMobilePhone(phone1);
		inventory.addMobilePhone(phone2);
		inventory.addMobilePhone(phone3);

		List<MobilePhone> sortedPhones = inventory.listMobilePhonesSortedByName();

		// Проверяем, что телефоны отсортированы по имени
		assertEquals("Apple", sortedPhones.get(0).getBrand());
		assertEquals("Samsung", sortedPhones.get(1).getBrand());
		assertEquals("Samsung", sortedPhones.get(2).getBrand());
	}

	@Test
	public void testListMobilePhonesSortedByPrice() {
		MobilePhone phone1 = new MobilePhone(1, "Samsung", "Galaxy S20", "Android", 799.99);
		MobilePhone phone2 = new MobilePhone(2, "Apple", "iPhone 12", "iOS", 899.99);
		MobilePhone phone3 = new MobilePhone(3, "Samsung", "Galaxy S21", "Android", 699.99);

		inventory.addMobilePhone(phone1);
		inventory.addMobilePhone(phone2);
		inventory.addMobilePhone(phone3);

		List<MobilePhone> sortedPhones = inventory.listMobilePhonesSortedByPrice();

		// Проверяем, что телефоны отсортированы по цене
		assertEquals(699.99, sortedPhones.get(0).getPrice());
		assertEquals(799.99, sortedPhones.get(1).getPrice());
		assertEquals(899.99, sortedPhones.get(2).getPrice());
	}
}
