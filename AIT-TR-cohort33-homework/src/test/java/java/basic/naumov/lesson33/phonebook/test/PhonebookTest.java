package java.basic.naumov.lesson33.phonebook.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import basic.naumov.lesson.phonebook.Contact;
import basic.naumov.lesson.phonebook.Phonebook;

public class PhonebookTest {

    private Phonebook phonebook;

    @BeforeEach
    void setUp() {
        phonebook = new Phonebook();
    }

    @Test
    void testAddValidContact() {
        Contact contact = new Contact("Andrej Naumov", "+371 29564873");
        assertTrue(phonebook.addContact(contact));
        assertEquals(contact, phonebook.findContactByName("Andrej Naumov"));
    }

    @Test
    void testAddDuplicateContact() {
        Contact contact1 = new Contact("Ozolins", "+371 29784512");
        Contact contact2 = new Contact("Ozolins", "+371 28315875");
        assertTrue(phonebook.addContact(contact1));
        assertFalse(phonebook.addContact(contact2));
    }

    @Test
    void testAddNullContact() {
        Contact contact = null;
        assertFalse(phonebook.addContact(contact));
    }

    @Test
    void testDeleteExistingContact() {
        Contact contact = new Contact("Смирнов", "+007 854 585212");
        assertTrue(phonebook.addContact(contact));
        assertTrue(phonebook.deleteContact("Смирнов"));
        assertNull(phonebook.findContactByName("Смирнов"));
    }

    @Test
    void testDeleteNonexistentContact() {
        assertFalse(phonebook.deleteContact("Не помню кто такой"));
    }

    @Test
    void testFindExistingContact() {
        Contact contact = new Contact("Иванов", "+007 258 56874");
        assertTrue(phonebook.addContact(contact));
        assertEquals(contact, phonebook.findContactByName("Иванов"));
    }

    @Test
    void testFindNonexistentContact() {
        assertNull(phonebook.findContactByName("Не успел записать :("));
    }
}

