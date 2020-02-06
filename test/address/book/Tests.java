package address.book;


import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class Tests {

    @Test
    public void addHuman() {
        final AddressBook book = new AddressBook();
        assertTrue(book.addHuman("Овсянников", new Address("Науки", 47, 101)));
        assertFalse(book.addHuman("Овсянников", new Address("Науки", 47, 1110)));
        assertTrue(book.addHuman("Мазнин", new Address("Политехническая", 17, 2)));
        assertFalse(book.addHuman("Овсянников", new Address("Политехническая", 17, 2)));
        assertTrue(book.addHuman("Черныш", new Address("Политехническая", 17, 2)));
    }

    @Test
    public void deleteHuman() {
        final AddressBook book = new AddressBook();
        book.addHuman("Овсянников", new Address("Науки", 47, 101));

        assertFalse(book.deleteHuman("Попов"));
        assertTrue(book.deleteHuman("Овсянников"));
        assertFalse(book.deleteHuman("Овсянников"));
    }

    @Test
    public void findAddress() {
        final AddressBook book = new AddressBook();
        book.addHuman("Овсянников", new Address("Науки", 47, 101));
        book.addHuman("Мазнин", new Address("Политехническая", 17, 2));

        assertEquals(new Address("Науки", 47, 101), book.findAddress("Овсянников"));
        assertEquals(new Address("Политехническая", 17, 2), book.findAddress("Мазнин"));
        assertEquals(book.findAddress("Овсянников"), book.findAddress("Овсянников"));
        assertNull(book.findAddress("Картелев"));
    }

    @Test
    public void changeAddress() {
        final AddressBook book = new AddressBook();
        final Address oldAddress = new Address("Науки", 39, 12);
        final Address newAddress = new Address("Науки", 39, 1231);
        assertFalse(book.changeAddress("Овсянников", newAddress)); // изменяем не записанного человека
        assertTrue(book.addHuman("Овсянников", oldAddress)); // добавляем человека
        final Map<String, Address> dataClone = new HashMap<>(book.getData());
        assertEquals(book.getData(), dataClone);  // сравниваем данные
        assertTrue(book.changeAddress("Овсянников", newAddress));  // изменяем адрес
        assertFalse(book.changeAddress("Овсянников", newAddress));  // пытаемся изменить адрес на такой же
        assertNotEquals(book.getData(), dataClone);  // сравниваем данные до и после изменения
        assertTrue(book.changeAddress("Овсянников", oldAddress));  // возвращаем старый адрес
        assertEquals(book.getData(), dataClone);  // сравниваем данные
    }

    @Test
    public void findPersons() {
        final AddressBook book = new AddressBook();
        book.addHuman("Овсянников", new Address("Науки", 47, 101));
        book.addHuman("Мазнин", new Address("Тихорецкий", 34, 2));
        book.addHuman("Алтухов", new Address("Науки", 64, 74));
        book.addHuman("Кришталь", new Address("Науки", 47, 52));
        book.addHuman("Железняк", new Address("Тихорецкий", 34, 85));

        assertEquals(new HashSet<>(Arrays.asList("Овсянников", "Алтухов", "Кришталь")), book.findPersons("Науки"));
        assertEquals(new HashSet<>(Arrays.asList("Овсянников", "Алтухов", "Кришталь")), book.findPersons("Науки"));
        assertEquals(Collections.emptySet(), book.findPersons("Бутлерова"));
        assertNotEquals(new HashSet<>(Arrays.asList("Овсянников", "Алтухов", "Кришталь")), book.findPersons("Науки", 47));
        assertEquals(new HashSet<>(Arrays.asList("Овсянников", "Кришталь")), book.findPersons("Науки", 47));
        assertEquals(Collections.emptySet(), book.findPersons("Тихорецкий", 48));
        assertEquals(book.findPersons("Тихорецкий"), book.findPersons("Тихорецкий", 34));
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
