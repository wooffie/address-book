package MyClass;


import java.util.*;

public class AddressBookMap {
    private final Map<String,Address> data = new HashMap<>();


    private static class Address {
        final String  street;
        final int number , flat;

        private Address( String street, int number , int flat) {
            this.street = street;
            this.number = number;
            this.flat = flat;
        }

        @Override
        public String toString(){
            return street + " "  + number + " " + flat;
        }
    }

    /**
     * Добавить человека.
     * Возвращает true, если человек был успешно добавлен,
     * и false, если человек с таким именем уже есть в адресной книге.
     */
    public boolean addHuman(String body , String street , int number , int flat){
        for(String name : data.keySet()){
            if(name.equals(body)){
                return false;
            }
        }
        data.put(body, new Address(street,number,flat));
        return true;
    }

    /**
     * Убрать человека.
     * Возвращает true, если человек был успешно удалён,
     * и false, если человек с таким именем отсутствовал в адресной книге.
     */
    public boolean deleteHuman(String body){
        for(String name : data.keySet()){
            if(name.equals(body)){
                data.remove(name);
                return true;
            }
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
        for(String name : data.keySet()){
            if(name.equals(body)){
                final Address address = data.get(name);
                if(address.street.equals(street) && address.number == number && address.flat == flat){
                    return false;
                }
                data.put(name, new Address(street,number,flat));
                return true;
            }
        }
        return false;
    }

    /**
     * Возвращает адрес заданного человека.
     * Если человека с такой фамилей нет возвращает null.
     */
    public String findAddress(String body){
        for(String name : data.keySet()){
            if(name.equals(body)){
                return data.get(name).toString();
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
        for(String name : data.keySet()){
            if(data.get(name).street.equals(street)){
                list.add(name);
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
        for(String name : data.keySet()){
            if(data.get(name).street.equals(street) && data.get(name).number == number){
                list.add(name);
            }
        }
        return list;
    }


    /**
     * Вывод в String
     */
    @Override
    public String toString(){
            return data.toString();
        }
    }
