package MyClass;


import com.sun.deploy.util.StringUtils;

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

    /**
     * Добавить человека.
     * Возвращает true, если человек был успешно добавлен,
     * и false, если человек с таким именем уже есть в адресной книге.
     */
    public boolean addHuman(String body , String street , int number , int flat){
        for(Person i : data){
            if(i.name.equals(body)){
                return false;
            }
        }
        data.add(new Person(body,street,number,flat));
        return true;
    }

    /**
     * Убрать человека.
     * Возвращает true, если человек был успешно удалён,
     * и false, если человек с таким именем отсутствовал в адресной книге.
     */
    public boolean deleteHuman(String body){
        int i = 0;
        while(i < data.size()){
            if(data.get(i).name.equals(body)){
                data.remove(i);
                return true;
            }
            i++;
        }
        return false;
    }


    /**
     * Изменить адрес.
     * Возвращает true, если адрес был успешно изменён,
     * и false, если человек с таким именем отсутствовал  в адресной книге,
     * либо он уже закреплён за данным адресом.
     */
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

    /**
     * Возвращает адрес заданного человека.
     * Если человека с такой фамилей есть возвращает null.
     */
    public String findAddress(String body){
        for(Person i : data){
            if(i.name.equals(body)){
                return i.street + " " + i.number + " " + i.flat;
            }
        }
        return null;
    }

    /**
     * Возвращает список людей живущих на заданной улице.
     * Если таких нет , то возвращает пустой список.
     */
    public List<String> findPersons(String street){
        final List<String> list = new ArrayList<>();
        for(Person i: data){
            if(i.street.equals(street)){
                list.add(i.name);
            }
        }
        return list;
    }

    /**
     * Возвращает список людей живущих в заданном доме.
     * Если таких нет , то возвращает пустой список.
     */
    public List<String> findPersons(String street , int number){
        final List<String> list = new ArrayList<>();
        for(Person i: data){
            if(i.street.equals(street) && i.number == number){
                list.add(i.name);
            }
        }
        return list;
    }


    /**
     * Вывод в String
     */
    @Override
    public String toString(){
        final List<String> list = new ArrayList<>();
        for(Person i: data){
            list.add(i.name + " " +  i.street + " " + i.number + " " + i.flat );
        }
        return StringUtils.join(list, " | ");
    }
}
