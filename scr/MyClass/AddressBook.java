package MyClass;


import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    private final List<Person> data = new ArrayList<>();

    private static class Person {
        final String name , street;
        final int number , flat;

        private Person(String name , String street, int number , int flat) {
            this.name = name;
            this.street = street;
            this.number = number;
            this.flat = flat;
        }

    }


    public boolean add(String body , String street , int number , int flat){
        for(Person i : data){
            if(i.name.equals(body)){
                return false;
            }
        }
        data.add(new Person(body,street,number,flat));
        return true;
    }

    public boolean delete(String body){
        for(Person i : data){
            if(i.name.equals(body)){
                data.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean changeAddress(String body , String street , int number , int flat){
        for(Person i : data){
            if(i.name.equals(body)){
                if(street.equals(i.street) && number == i.number && flat == i.flat){
                    return false;
                }
                data.remove(i);
                data.add(new Person(body,street,number,flat));
                return true;
            }
        }
        return false;
    }

    public String showAddress(String body){
        for(Person i : data){
            if(i.name.equals(body)){
                return i.street + " " + i.number + " " + i.flat;
            }
        }
        return null;
    }

    public List<String> showPersons(String street){
        List<String> list = new ArrayList<>();
        for(Person i: data){
            if(i.street.equals(street)){
                list.add(i.name);
            }
        }
        return list;
    }

    public List<String> showPersons(String street , int number){
        List<String> list = new ArrayList<>();
        for(Person i: data){
            if(i.street.equals(street) && i.number == number){
                list.add(i.name);
            }
        }
        return list;
    }

}
