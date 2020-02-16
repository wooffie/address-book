package ru.spbstu.addressbook;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class Tests {

    @Test
    public void addHuman() {
        final AddressBook book = new AddressBook();
        assertTrue(book.addHuman("Connor", new Address("Groove", 47, 101)));
        assertFalse(book.addHuman("Connor", new Address("Groove", 47, 1110)));
        assertTrue(book.addHuman("White", new Address("Idlewood", 17, 2)));
        assertFalse(book.addHuman("Connor", new Address("Idlewood", 17, 2)));
        assertTrue(book.addHuman("Coofe", new Address("Idlewood", 17, 2)));
    }

    @Test
    public void deleteHuman() {
        final AddressBook book = new AddressBook();
        book.addHuman("Connor", new Address("Groove", 47, 101));

        assertFalse(book.deleteHuman("Richardson"));
        assertTrue(book.deleteHuman("Connor"));
        assertFalse(book.deleteHuman("Connor"));
    }

    @Test
    public void findAddress() {
        final AddressBook book = new AddressBook();
        book.addHuman("Connor", new Address("Groove", 47, 101));
        book.addHuman("White", new Address("Idlewood", 17, 2));

        assertEquals(new Address("Groove", 47, 101), book.findAddress("Connor"));
        assertEquals(new Address("Idlewood", 17, 2), book.findAddress("White"));
        assertEquals(book.findAddress("Connor"), book.findAddress("Connor"));
        assertNull(book.findAddress("Derton"));
    }

    @Test
    public void changeAddress() {
        final AddressBook book = new AddressBook();
        final Address oldAddress = new Address("Groove", 39, 12);
        final Address newAddress = new Address("Groove", 39, 1231);
        assertFalse(book.changeAddress("Connor", newAddress));
        assertTrue(book.addHuman("Connor", oldAddress));
        final Map<String, Address> dataClone = book.getData();
        assertEquals(book.getData(), dataClone);
        assertTrue(book.changeAddress("Connor", newAddress));
        assertFalse(book.changeAddress("Connor", newAddress));
        assertNotEquals(book.getData(), dataClone);
        assertTrue(book.changeAddress("Connor", oldAddress));
        assertEquals(book.getData(), dataClone);
    }

    @Test
    public void findPersons() {
        final AddressBook book = new AddressBook();
        book.addHuman("Connor", new Address("Groove", 47, 101));
        book.addHuman("White", new Address("Jefferson", 34, 2));
        book.addHuman("Jackson", new Address("Groove", 64, 74));
        book.addHuman("Thompson", new Address("Groove", 47, 52));
        book.addHuman("Fine", new Address("Jefferson", 34, 85));

        assertEquals(new HashSet<>(Arrays.asList("Connor", "Jackson", "Thompson")), book.findPersons("Groove"));
        assertEquals(new HashSet<>(Arrays.asList("Connor", "Jackson", "Thompson")), book.findPersons("Groove"));
        assertEquals(Collections.emptySet(), book.findPersons("Strip"));
        assertNotEquals(new HashSet<>(Arrays.asList("Connor", "Jackson", "Thompson")), book.findPersons("Groove", 47));
        assertEquals(new HashSet<>(Arrays.asList("Connor", "Thompson")), book.findPersons("Groove", 47));
        assertEquals(Collections.emptySet(), book.findPersons("Jefferson", 48));
        assertEquals(book.findPersons("Jefferson"), book.findPersons("Jefferson", 34));
    }

    @Test
    public void equals() {
        final AddressBook firstBook = new AddressBook();
        final AddressBook secondBook = new AddressBook();
        assertNotEquals(firstBook, 4);
        assertEquals(firstBook, firstBook);
        assertEquals(firstBook, secondBook);
        firstBook.addHuman("Man", new Address("Wall", 42, 44));
        assertNotEquals(firstBook, secondBook);
        secondBook.addHuman("Man", new Address("Wall", 42, 44));
        assertEquals(firstBook, secondBook);
        firstBook.addHuman("Woman", new Address("Wall", 42, 44));
        assertNotEquals(firstBook, secondBook);
    }

}

