Иммутабельный класс Иммутабельность = неизменяемость, пример такого класса - String. Нельзя изменить объект, будет всегда создан новый. Мы используем переменные с модификатором privat и final, те переменные не будут видны в других классах, только в одном классе (нашем) и недоступна другим, и будут неизменяемы. Final добавляем классу для запрета наследования (это вроде позволит не переопределять наши переменные, override не получится использовать).

Пример простого класса. Он иммутабельный, то есть изменить объект (майнамбер) будет нельзя.

public final class ImmutableClassMy { private final int myNumber;

public ImmutableClassMy (int myNumber){ this.myNumber = myNumber; // конструктор, присваивающий аргумент к переменной класса }

public int getMyNumber() { return myNumber; } }

Пример кода с этим классом

public class Main { public static void main(String[] args) { // Создаем объект ImmutableClassMy с значением myNumber = 42 ImmutableClassMy immutableObj = new ImmutableClassMy(42);

    // Получаем значение myNumber из объекта
    int myNumber = immutableObj.getMyNumber();
    System.out.println("myNumber = " + myNumber); //вывели 42

    // Попытка изменить значение myNumber приведет к ошибке компиляции, так как переменная myNumber в классе ImmutableClassMy объявлена как final
    // immutableObj.myNumber = 100; // Ошибка компиляции

    // Создаем новый объект ImmutableClassMy с другим значением myNumber
    ImmutableClassMy anotherObj = new ImmutableClassMy(100);
    int anotherNumber = anotherObj.getMyNumber();
    System.out.println("anotherNumber = " + anotherNumber);
}
}
