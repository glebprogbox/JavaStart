package collection.streamapi;

/*
 Класс телефона.
 */

class Phone {
    private Long number;
    private PhoneType type;

    public Phone(Long number, PhoneType type) {
        this.number = number;
        this.type = type;
    }

    public Long getNumber() {
        return number;
    }

    public PhoneType getType() {
        return type;
    }

    //Доработал для проверки себя
    @Override
    public String toString() {
        return (STR."\{getNumber()} \{getType()}");
    }

}

/*
 Перечисление типов телефонов.
*/

enum PhoneType {
    STATIONARY,
    MOBIL
}

