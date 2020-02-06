package MyClass;


import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class MapTests {

    @Test
    public void addHuman(){
        final AddressBookMap book = new AddressBookMap();
        assertTrue(book.addHuman("Овсянников","Науки",47,101));
        assertFalse(book.addHuman("Овсянников","Науки",47,1110));
        assertTrue(book.addHuman("Мазнин","Политехническая",17,2));
        assertFalse(book.addHuman("Овсянников","Политехническая",17,2));
        assertTrue(book.addHuman("Черныш","Политехническая",17,2));
    }

    @Test
    public void deleteHuman(){
        final AddressBookMap book = new AddressBookMap();
        book.addHuman("Овсянников","Науки",47,101);

        assertFalse(book.deleteHuman("Попов"));
        assertTrue(book.deleteHuman("Овсянников"));
        assertFalse(book.deleteHuman("Овсянников"));
    }

    @Test
    public void findAddress(){
        final AddressBookMap book = new AddressBookMap();
        book.addHuman("Овсянников","Науки",47,101);
        book.addHuman("Мазнин","Политехническая",17,2);

        assertEquals("Науки 47 101",book.findAddress("Овсянников"));
        assertEquals("Политехническая 17 2",book.findAddress("Мазнин"));
        assertNull(book.findAddress("Картелев"));
    }

    @Test
    public void changeAddress(){
        final AddressBookMap book = new AddressBookMap();
        book.addHuman("Овсянников","Науки",47,101);
        final String address = book.findAddress("Овсянников");

        assertFalse(book.changeAddress("Овсянников","Науки",47,101));
        assertTrue(book.changeAddress("Овсянников","Науки",45,101));
        assertNotEquals(address,book.findAddress("Овсянников"));
    }

    @Test
    public void findPersons(){
        final AddressBookMap book = new AddressBookMap();
        book.addHuman("Овсянников","Науки",47,101);
        book.addHuman("Мазнин","Тихорецкий",34,2);
        book.addHuman("Алтухов","Науки",64,74);
        book.addHuman("Кришталь","Науки",47,52);
        book.addHuman("Железняк","Тихорецкий",34,85);


        assertEquals(Collections.emptyList(),book.findPersons("Бутлерова"));
        assertEquals(Collections.emptyList(),book.findPersons("Тихорецкий",48));
        assertEquals(book.findPersons("Тихорецкий"),book.findPersons("Тихорецкий",34));
    }
}
