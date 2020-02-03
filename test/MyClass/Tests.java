package MyClass;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class Tests {

    @Test
    public void addHuman(){
        final AddressBook book = new AddressBook();
        Assert.assertTrue(book.addHuman("Овсянников","Науки",47,101));
        Assert.assertFalse(book.addHuman("Овсянников","Науки",47,1110));
        Assert.assertTrue(book.addHuman("Мазнин","Политехническая",17,2));
        Assert.assertFalse(book.addHuman("Овсянников","Политехническая",17,2));
        Assert.assertTrue(book.addHuman("Черныш","Политехническая",17,2));
    }

    @Test
    public void deleteHuman(){
        final AddressBook book = new AddressBook();
        book.addHuman("Овсянников","Науки",47,101);

        Assert.assertFalse(book.deleteHuman("Попов"));
        Assert.assertTrue(book.deleteHuman("Овсянников"));
        Assert.assertFalse(book.deleteHuman("Овсянников"));
    }

    @Test
    public void findAddress(){
        final AddressBook book = new AddressBook();
        book.addHuman("Овсянников","Науки",47,101);
        book.addHuman("Мазнин","Политехническая",17,2);

        Assert.assertEquals("Науки 47 101",book.findAddress("Овсянников"));
        Assert.assertEquals("Политехническая 17 2",book.findAddress("Мазнин"));
        Assert.assertNull(book.findAddress("Картелев"));
    }

    @Test
    public void changeAddress(){
        final AddressBook book = new AddressBook();
        book.addHuman("Овсянников","Науки",47,101);
        final String address = book.findAddress("Овсянников");

        Assert.assertFalse(book.changeAddress("Овсянников","Науки",47,101));
        Assert.assertTrue(book.changeAddress("Овсянников","Науки",45,101));
        Assert.assertNotEquals(address,book.findAddress("Овсянников"));
    }

    @Test
    public void findPersons(){
        final AddressBook book = new AddressBook();
        book.addHuman("Овсянников","Науки",47,101);
        book.addHuman("Мазнин","Тихорецкий",34,2);
        book.addHuman("Алтухов","Науки",64,74);
        book.addHuman("Кришталь","Науки",47,52);
        book.addHuman("Железняк","Тихорецкий",34,85);

        Assert.assertEquals(Arrays.asList("Овсянников", "Алтухов", "Кришталь"),book.findPersons("Науки"));
        Assert.assertEquals(Collections.emptyList(),book.findPersons("Бутлерова"));
        Assert.assertNotEquals(Arrays.asList("Овсянников", "Алтухов", "Кришталь"),book.findPersons("Науки",47));
        Assert.assertEquals(Arrays.asList("Овсянников", "Кришталь"),book.findPersons("Науки",47));
        Assert.assertEquals(Collections.emptyList(),book.findPersons("Тихорецкий",48));
        Assert.assertEquals(book.findPersons("Тихорецкий"),book.findPersons("Тихорецкий",34));
    }
}
