package collection.streamapi;

import java.util.List;

/*
Класс клиента.
*/


class Client {
    private Integer id;
    private String name;
    private Integer age;
    private List<Phone> phones;

    public Client(Integer id, String name, Integer age, List<Phone> phones) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phones = phones;
    }

    // Геттеры (в сеттерах пока нет необходимости)
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    //Доработал для проверки себя
    @Override
    public String toString() {
        return (STR."ID - \{getId()}, Имя - \{getName()}, Возраст - \{getAge()}, Телефоны - \{getPhones()}");
    }
}



