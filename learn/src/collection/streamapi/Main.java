package collection.streamapi;

/*
Дан код - класс клиента и телефона с enum. Надо:

1. Написать метод, который рандомно создаст список из 1000 клиентов с телефонами
2. Найти самого возрастного клиента, которой пользуется стационарным телефоном
3. Найти все уникальные номера телефонов, которые являются мобильными
4. Подсчитать общее количество мобильных телефонов у всех клиентов
5. Проверить, есть ли хотя бы один клиент, у которого все телефоны только стационарные
6. Найти средний возраст клиентов, которые имеют хотя бы один стационарный телефон
7. Сформировать карту Map<PhoneType, Long>, где ключ – тип телефона, а значение – количество всех телефонов этого
 типа у всех клиентов
8. Найти все пары (Client, Phone), где номер телефона начинается с определённой с "+7" (//тут чуть другое сделаю,
тк long не может быть с +)
9. Найти клиента по заданному имени (String name) и вывести его возраст. Если такого клиента нет, то вывести сообщение
"Клиент не найден".
10. Получить список мобильных телефонов клиента по его id. Если клиента нет в списке, вернуть пустой список
сделать через stream api, там где не получится - через обычный алгоритм
*/


import java.util.*;

import static collection.streamapi.PhoneType.MOBIL;
import static collection.streamapi.PhoneType.STATIONARY;


public class Main {
    static List<Client> clients = new ArrayList<>();

    public void main(String[] args) {
        generateManyClients(clients);
        System.out.println(STR."1000 клиентов сгенерированы! Пример одного: \n\{clients.get(456).toString()}");
        searchMaxAgeAndStationaryPhone();
        uniqueMobilePhones();
        mobilePhonesCount();
        haveOnlyStationaryPhone();
        haveOnlyStationaryPhoneOneClient();
        haveOnlyStationaryPhoneAverageAge();
        createMapofPhones();
        searchClientsWithPhones();
        searchClientsByName();
        getPhonesByIdClient();
    }

    static public void generateManyClients(List<Client> clients) {
        for (int id = 0; id < 1000; id++) {
            Client client = new Client(id, generateNameOfClient(), generateAgeOfClient(), generatePhonesOfClient());
            clients.add(client);
        }
    }

    static public String generateNameOfClient() {
        // буква 'a'
        int leftLimitChar = 97;
        // буква 'z'
        int rightLimitChar = 122;
        Random randomName = new Random();
        Random randomLengthName = new Random();
        return randomName.ints(leftLimitChar, rightLimitChar + 1)
                //ограничивает стрим по кол-ву элементов
                .limit(randomLengthName.nextInt(5, 15))
                //собирает StringBuilder строку, appendCodePoint переводит символ в строку, append добавляет
                //этот символ к строке
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                //StringBuilder в String, иначе будет ошибка
                .toString();
    }

    static public int generateAgeOfClient() {
        Random randomAge = new Random();
        return randomAge.nextInt(18, 66);
    }

    static public List<Phone> generatePhonesOfClient() {
        Random randomType = new Random();
        List<Phone> phones = new ArrayList<>();
        //0 входит в диапазон
        int choiceType = randomType.nextInt(0, 3);
        //только мобильный
        if (choiceType == 0) {
            Phone mobile = new Phone(generateMobilePhoneOfClient(), MOBIL);
            phones.add(mobile);
            //System.out.println(mobile);
        }
        //только стационарный
        if (choiceType == 1) {
            Phone stationary = new Phone(generateStationaryPhoneOfClient(), STATIONARY);
            phones.add(stationary);
            //System.out.println(stationary);
        }
        //моб и стационарный
        if (choiceType == 2) {
            Phone mobile = new Phone(generateMobilePhoneOfClient(), MOBIL);
            Phone stationary = new Phone(generateStationaryPhoneOfClient(), STATIONARY);
            phones.add(stationary);
            phones.add(mobile);
            //System.out.println(STR."\{mobile} \{stationary}");
        }
        return phones;
    }

    static public long generateMobilePhoneOfClient() {
        Random randomCharMobile = new Random();
        int charMobile = randomCharMobile.nextInt(1000000, 2000000);
        return (89951000000L + charMobile);
    }

    static public long generateStationaryPhoneOfClient() {
        Random randomCharStationary = new Random();
        int charStationary = randomCharStationary.nextInt(1000000, 2000000);
        return (84951000000L + charStationary);
    }

    static public void searchMaxAgeAndStationaryPhone() {
        System.out.println("Клиенты с макс.возрастом и хотя бы одним стационарным телефоном ниже.");
        int maxAge = clients.stream()
                //поток интов
                .mapToInt(c -> c.getAge())
                //метод который посчитает макс, мин, среднее
                .summaryStatistics()
                //берем максимальное
                .getMax();
        clients.stream()
                //фильтруем, оставляем клиентов, где макс возраст
                .filter(c -> c.getAge() == maxAge)
                //фильтруем, оставляем клиентов, где есть стац.телефон
                .filter(client -> haveStationaryPhone(client.getPhones()))
                .forEach(System.out::println);
    }

    static public boolean haveStationaryPhone(List<Phone> phones) {
        for (Phone phone : phones) {
            if (phone.getType() == STATIONARY) {
                return true;
            }
        }
        return false;
    }

    static public boolean haveMobilePhone(List<Phone> phones) {
        for (Phone phone : phones) {
            if (phone.getType() == MOBIL) {
                return true;
            }
        }
        return false;
    }

    static public void uniqueMobilePhones() {
        System.out.println("Уникальные номера моб.телефонов ниже.");
        clients.stream()
                .filter(c -> haveMobilePhone(c.getPhones()))
                //читаем подколлекцию телефонов
                .flatMap(c -> c.getPhones().stream())
                //дедупликация
                .distinct()
                .forEach(System.out::println);

    }

    static public void mobilePhonesCount() {
        System.out.println("Количество мобильных телефонов ниже.");
        long count = clients.stream()
                .filter(c -> haveMobilePhone(c.getPhones()))
                .flatMap(c -> c.getPhones().stream())
                .count();
        System.out.println(count);
    }

    static public void haveOnlyStationaryPhone() {
        System.out.println("Клиенты только со стац.телефоном ниже.");
        clients.stream()
                .filter(c -> !haveMobilePhone(c.getPhones()))
                .forEach(System.out::println);
    }

    static public void haveOnlyStationaryPhoneOneClient() {
        System.out.println("Есть ли один клиент только с стац.телефоном?");

        System.out.println(clients.stream()
                .anyMatch(c -> !haveMobilePhone(c.getPhones())));
    }

    static public void haveOnlyStationaryPhoneAverageAge() {
        System.out.println("Средний возраст клиентов, у которых есть стац. телефон ниже.");
        double average = clients.stream()
                .filter(c -> haveStationaryPhone(c.getPhones()))
                .mapToInt(c -> c.getAge())
                .summaryStatistics()
                .getAverage();
        System.out.println(average);
    }

    static public void createMapofPhones() {
        System.out.println("Ниже map с ключом = тип телефона и значением = кол-во этих телефонов.");
        Map<PhoneType, Long> mapPhones = new HashMap();
        long countMobil = clients.stream()
                .flatMap(c -> c.getPhones().stream())
                .filter(phone -> phone.getType() == MOBIL)
                .count();
        long countStationary = clients.stream()
                .flatMap(c -> c.getPhones().stream())
                .filter(phone -> phone.getType() == STATIONARY)
                .count();
        mapPhones.put(MOBIL, countMobil);
        mapPhones.put(STATIONARY, countStationary);
        System.out.println(mapPhones);
    }

    static public void searchClientsWithPhones() {
        System.out.println("Ниже клиенты, у которых телефон начинается на 8995201.");
        clients.stream()
                //оказывается так можно, поток в потоке, предыдущие пока не переделываю
                .filter(c -> c.getPhones().stream()
                        .anyMatch(phone -> phone.getNumber().toString().startsWith("8995201")))
                .forEach(System.out::println);
    }

    static public void searchClientsByName() {
        System.out.println("Введите имя клиента для поиска");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        clients.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .ifPresentOrElse(f -> System.out.println("Клиент найден, возраст: " + f.getAge()),
                        () -> System.out.println("Клиент не найден!"));
    }

    static public void getPhonesByIdClient() {
        System.out.println("Введите ID клиента для получения моб.телефонов, цифрами.");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        clients.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .ifPresentOrElse(c -> c.getPhones().stream()
                                .filter(phone -> phone.getType() == MOBIL)
                                .findFirst()
                                .ifPresentOrElse(p -> System.out.println(p.getNumber()),
                                        () -> System.out.println("Мобильный телефон у клиента отсутствует.")),
                        () -> System.out.println("Клиент не найден!"));
    }

}
