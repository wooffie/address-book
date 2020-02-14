package ru.spbstu.addressbook;

import java.util.*;


public class AddressBook {
    private final Map<String, Address> data = new HashMap<>();

    /**
     * Вернуть базу данных.
     * (Я решил сделать этот метод public , поэтому передаю новый HashMap , а не ссылку.)
     */
    public Map<String, Address> getData() {
        return new HashMap<>(data);
        // это сделано для того , чтобы у пользователя не было ссылки на data и он работал с методами класса
    }

    /**
     * Добавить человека.
     * Возвращает true, если человек был успешно добавлен,
     * и false, если человек с таким именем уже есть в адресной книге.
     */
    public boolean addHuman(String name, Address address) {
        if (data.containsKey(name)) {
            return false;
        }
        data.put(name, address);
        return true;
    }

    /**
     * Убрать человека.
     * Возвращает true, если человек был успешно удалён,
     * и false, если человек с таким именем отсутствовал в адресной книге.
     */
    public boolean deleteHuman(String name) {
        if (data.containsKey(name)) {
            data.remove(name);
            return true;
        }
        return false;
    }


    /**
     * Изменить адрес.
     * Возвращает true, если адрес был успешно изменён,
     * и false, если человек с таким именем отсутствовал  в адресной книге,
     * либо он уже закреплён за данным адресом.
     */
    public boolean changeAddress(String name, Address address) {
        if (data.containsKey(name) && address != data.get(name)) {
            data.put(name, address);
            return true;
        }
        return false;
    }

    /**
     * Возвращает адрес заданного человека.
     * Если человека с такой фамилей нет возвращает null.
     */
    public Address findAddress(String name) {
        return data.get(name);
    }

    /**
     * Возвращает множество людей живущих на заданной улице.
     * Если таких нет, то возвращает пустой список.
     */
    public Set<String> findPersons(String street) {
        final Set<String> list = new HashSet<>();
        for (Map.Entry<String, Address> entry : data.entrySet()) {
            if (entry.getValue().getStreet().equals(street)) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    public Set<String> findPersons(String street, int number) {
        final Set<String> list = new HashSet<>();
        for (Map.Entry<String, Address> entry : data.entrySet()) {
            if (entry.getValue().getStreet().equals(street) && entry.getValue().getNumber() == number) {
                list.add(entry.getKey());
            }
        }
        return list;
    }


    /**
     * Вывод в String.
     */
    @Override
    public String toString() {
        final List<String> list = new LinkedList<>();
        for (String i : data.keySet()) {
            list.add(i + " " + data.get(i).toString());
        }
        return String.join("\n", list);
    }

    /**
     * Хаш-код.
     */
    @Override
    public int hashCode() {
        return data.hashCode();
    }

    /**
     * Равенство экземпляра класса и другого объекта.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof AddressBook) {
            AddressBook other = (AddressBook) o;
            return data.equals(other.data);
        }
        return false;
    }

}

