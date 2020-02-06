import java.util.*;


public class AddressBook {
    private Map<String, Address> data = new HashMap<>();

    public Map<String, Address> getData() {
        return data;
    }

    /**
     * Добавить человека.
     * Возвращает true, если человек был успешно добавлен,
     * и false, если человек с таким именем уже есть в адресной книге.
     */
    public boolean addHuman(String body, Address domicile) {
        for (String name : data.keySet()) {
            if (name.equals(body)) {
                return false;
            }
        }
        data.put(body, domicile);
        return true;
    }

    /**
     * Убрать человека.
     * Возвращает true, если человек был успешно удалён,
     * и false, если человек с таким именем отсутствовал в адресной книге.
     */
    public boolean deleteHuman(String body) {
        for (String name : data.keySet()) {
            if (name.equals(body)) {
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
    public boolean changeAddress(String body, Address domicile) {
        for (String name : data.keySet()) {
            if (name.equals(body)) {
                if (domicile == data.get(name)) {
                    return false;
                }
                data.put(name, domicile);
                return true;
            }
        }
        return false;
    }

    /**
     * Возвращает адрес заданного человека.
     * Если человека с такой фамилей нет возвращает null.
     */
    public Address findAddress(String body) {
        for (String name : data.keySet()) {
            if (name.equals(body)) {
                return data.get(name);
            }
        }
        return null;
    }

    /**
     * Возвращает список людей живущих на заданной улице.
     * Если таких нет, то возвращает пустой список.
     */
    public Set<String> findPersons(String street) {
        final Set<String> list = new HashSet<>();
        for (String name : data.keySet()) {
            if (data.get(name).getStreet().equals(street)) {
                list.add(name);
            }
        }
        return list;
    }

    /**
     * Возвращает список людей живущих в заданном доме.
     * Если таких нет, то возвращает пустой список.
     */
    public Set<String> findPersons(String street, int number) {
        final Set<String> list = new HashSet<>();
        for (String name : data.keySet()) {
            if (data.get(name).getStreet().equals(street) && data.get(name).getNumber() == number) {
                list.add(name);
            }
        }
        return list;
    }


    /**
     * Вывод в String
     */
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
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        AddressBook other = (AddressBook) o;
        return data.equals(other.data);
    }

}

