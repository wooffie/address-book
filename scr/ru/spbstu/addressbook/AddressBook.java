package ru.spbstu.addressbook;

import java.util.*;


public class AddressBook {
    private final Map<String, Address> data = new HashMap<>();


    public Map<String, Address> getData() {
        return new HashMap<>(data);
    }

    public boolean addHuman(String name, Address address) {
        if (data.containsKey(name)) {
            return false;
        }
        data.put(name, address);
        return true;
    }

    public boolean deleteHuman(String name) {
        if (data.containsKey(name)) {
            data.remove(name);
            return true;
        }
        return false;
    }

    public boolean changeAddress(String name, Address address) {
        if (data.containsKey(name) && address != data.get(name)) {
            data.put(name, address);
            return true;
        }
        return false;
    }

    public Address findAddress(String name) {
        return data.get(name);
    }

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

    @Override
    public String toString() {
        final List<String> list = new LinkedList<>();
        for (String i : data.keySet()) {
            list.add(i + " " + data.get(i).toString());
        }
        return String.join("\n", list);
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }

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

