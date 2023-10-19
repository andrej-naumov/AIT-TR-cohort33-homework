package lv.naumov.lesson37.mobilephone.test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lv.naumov.lesson37.mobilephone.InventoryManagement;
import lv.naumov.lesson37.mobilephone.MobilePhone;

public class InventoryManagementTest {
	private InventoryManagement inventory;

	@BeforeEach
	void setUp() {
		inventory = new InventoryManagement();
	}

	@Test
	void testAddMobilePhone() {
		UUID id = UUID.randomUUID();
		MobilePhone phone = new MobilePhone(id, "Samsung", "Galaxy S20", "Android", 799.99);
		inventory.addMobilePhone(phone);
		assertEquals(1, inventory.listMobilePhones().size());
	}

	@Test
	void testGetMobilePhoneNotNull() {
		UUID id = UUID.randomUUID();
		MobilePhone phone = new MobilePhone(id, "Samsung", "Galaxy S20", "Android", 799.99);
		inventory.addMobilePhone(phone);
		MobilePhone retrievedPhone = inventory.getMobilePhone(id);
		assertNotNull(retrievedPhone);
		assertEquals("Samsung", retrievedPhone.getBrand());
	}

	@Test
	void testGetMobilePhoneNull() {
		UUID id = UUID.randomUUID();
		MobilePhone phone = new MobilePhone(id, "Samsung", "Galaxy S20", "Android", 799.99);
		inventory.addMobilePhone(phone);
		MobilePhone retrievedPhone = inventory.getMobilePhone(UUID.randomUUID());
		assertNull(retrievedPhone);
	}

	@Test
	void testUpdateMobilePhone() {
		UUID id = UUID.randomUUID();
		MobilePhone phone = new MobilePhone(id, "Samsung", "Galaxy S20", "Android", 799.99);
		inventory.addMobilePhone(phone);

		MobilePhone updatedPhone = new MobilePhone(id, "Apple", "iPhone 12", "iOS", 899.99);
		assertTrue(inventory.updateMobilePhone(updatedPhone));

		MobilePhone retrievedPhone = inventory.getMobilePhone(id);
		assertNotNull(retrievedPhone);
		assertEquals("Apple", retrievedPhone.getBrand());
	}

	@Test
	void testDeleteMobilePhone() {
		UUID id = UUID.randomUUID();
		MobilePhone phone = new MobilePhone(id, "Samsung", "Galaxy S20", "Android", 799.99);
		inventory.addMobilePhone(phone);
		assertTrue(inventory.deleteMobilePhone(id));
		assertEquals(0, inventory.listMobilePhones().size());
	}

	@Test
	void testListMobilePhones() {
		MobilePhone phone1 = new MobilePhone(UUID.randomUUID(), "Samsung", "Galaxy S20", "Android", 799.99);
		MobilePhone phone2 = new MobilePhone(UUID.randomUUID(), "Apple", "iPhone 12", "iOS", 899.99);

		inventory.addMobilePhone(phone1);
		inventory.addMobilePhone(phone2);

		assertEquals(2, inventory.listMobilePhones().size());
	}

	@Test
	public void testSearchByBrand() {
		MobilePhone phone1 = new MobilePhone(UUID.randomUUID(), "Samsung", "Galaxy S20", "Android", 799.99);
		MobilePhone phone2 = new MobilePhone(UUID.randomUUID(), "Apple", "iPhone 12", "iOS", 899.99);
		MobilePhone phone3 = new MobilePhone(UUID.randomUUID(), "Samsung", "Galaxy S21", "Android", 899.99);

		inventory.addMobilePhone(phone1);
		inventory.addMobilePhone(phone2);
		inventory.addMobilePhone(phone3);

		List<MobilePhone> samsungPhones = inventory.searchByBrand("Samsung");
		assertEquals(2, samsungPhones.size());
	}

	@Test
	public void testListMobilePhonesSortedByName() {
		MobilePhone phone1 = new MobilePhone(UUID.randomUUID(), "Samsung", "Galaxy S20", "Android", 799.99);
		MobilePhone phone2 = new MobilePhone(UUID.randomUUID(), "Apple", "iPhone 12", "iOS", 899.99);
		MobilePhone phone3 = new MobilePhone(UUID.randomUUID(), "Samsung", "Galaxy S21", "Android", 699.99);

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
		MobilePhone phone1 = new MobilePhone(UUID.randomUUID(), "Samsung", "Galaxy S20", "Android", 799.99);
		MobilePhone phone2 = new MobilePhone(UUID.randomUUID(), "Apple", "iPhone 12", "iOS", 899.99);
		MobilePhone phone3 = new MobilePhone(UUID.randomUUID(), "Samsung", "Galaxy S21", "Android", 699.99);

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
