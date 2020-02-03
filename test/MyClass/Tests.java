package MyClass;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class Tests {

    @Test
    public void add(){
        AddressBook book = new AddressBook();
        Assert.assertTrue(book.add("Овсянников","Науки",47,101));
        Assert.assertFalse(book.add("Овсянников","Науки",47,1110));
        Assert.assertTrue(book.add("Мазнин","Политехническая",17,2));
        Assert.assertFalse(book.add("Овсянников","Политехническая",17,2));
        Assert.assertTrue(book.add("Черныш","Политехническая",17,2));
    }

    @Test
    public void delete(){
        AddressBook book = new AddressBook();
        book.add("Овсянников","Науки",47,101);
        book.add("Мазнин","Политехническая",17,2);
        book.add("Черныш","Политехническая",17,2);

        Assert.assertFalse(book.delete("Попов"));
        Assert.assertTrue(book.delete("Овсянников"));
        Assert.assertFalse(book.delete("Овсянников"));
    }

    @Test
    public void showAddress(){
        AddressBook book = new AddressBook();
        book.add("Овсянников","Науки",47,101);
        book.add("Мазнин","Политехническая",17,2);
        book.add("Попов","Гражданский",34,85);

        Assert.assertEquals("Науки 47 101",book.showAddress("Овсянников"));
        Assert.assertEquals("Политехническая 17 2",book.showAddress("Мазнин"));
        Assert.assertNull(book.showAddress("Картелев"));
    }

    @Test
    public void changeAddress(){
        AddressBook book = new AddressBook();
        book.add("Овсянников","Науки",47,101);
        book.add("Мазнин","Политехническая",17,2);
        book.add("Попов","Гражданский",34,85);

        final String address = book.showAddress("Овсянников");
        Assert.assertFalse(book.changeAddress("Овсянников","Науки",47,101));
        Assert.assertTrue(book.changeAddress("Овсянников","Науки",45,101));
        Assert.assertNotEquals(address,book.showAddress("Овсянников"));
    }

    @Test
    public void showPersons(){
        AddressBook book = new AddressBook();
        book.add("Овсянников","Науки",47,101);
        book.add("Мазнин","Тихорецкий",34,2);
        book.add("Попов","Гражданский",34,85);
        book.add("Алтухов","Науки",64,74);
        book.add("Кришталь","Науки",47,52);
        book.add("Железняк","Тихорецкий",34,85);

        Assert.assertEquals(Arrays.asList("Овсянников", "Алтухов", "Кришталь"),book.showPersons("Науки"));
        Assert.assertEquals(Collections.emptyList(),book.showPersons("Бутлерова"));
        Assert.assertNotEquals(Arrays.asList("Овсянников", "Алтухов", "Кришталь"),book.showPersons("Науки",47));
        Assert.assertEquals(Arrays.asList("Овсянников", "Кришталь"),book.showPersons("Науки",47));
        Assert.assertEquals(Collections.emptyList(),book.showPersons("Тихорецкий",48));
        Assert.assertEquals(book.showPersons("Тихорецкий"),book.showPersons("Тихорецкий",34));
    }
}
