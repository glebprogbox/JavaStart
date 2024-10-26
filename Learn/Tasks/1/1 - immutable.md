Иммутабельный класс Иммутабельность = неизменяемость, пример такого класса - String. Нельзя изменить объект, будет всегда создан новый. Мы используем переменные с модификатором privat и final, те переменные не будут видны в других классах, только в одном классе (нашем) и недоступна другим, и будут неизменяемы. Final добавляем классу для запрета наследования (это вроде позволит не переопределять наши переменные, override не получится использовать).

Пример простого класса. Он иммутабельный, то есть изменить объект (майнамбер) будет нельзя.

public final class ImmutableClassMy { 
private final int myNumber;

public ImmutableClassMy (int myNumber)
{ 
this.myNumber = myNumber; // конструктор, присваивающий аргумент к переменной класса 
}

public int getMyNumber() { 
return myNumber; 
} 
}

Пример кода с этим классом

public class Main { public static void main(String[] args) { 

 // Создаем объект ImmutableClassMy с значением myNumber = 42 
 ImmutableClassMy immutableObj = new ImmutableClassMy(42);

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


Еще пример, более правильный, когда отдаем новый объект при попытке изменения, а не просто запрещаем менять объект
public final class ImmutableClassMy {
    private final int myNumber;

    public ImmutableClassMy (int myNumber)
    {
        this.myNumber = myNumber; // конструктор, присваивающий аргумент к переменной класса
    }

    public int getMyNumber() {
        return myNumber;
    }

    public ImmutableClassMy increment(int number)
    {
        return new ImmutableClassMy(myNumber + number);
    }
}

public class Main {
    public static void main(String[] args) {
        ImmutableClassMy originalObj = new ImmutableClassMy(42); //создаем объект с значением 42
        ImmutableClassMy immutableObj = originalObj; // присваиваем ссылку оригинала, чтоб не потерять
        int myNumberOrig = originalObj.getMyNumber(); // инициализируем оригинал
        System.out.println("Исходный объект = " + myNumberOrig); //показываем оригинал, 42
        int myNumberCopy = immutableObj.getMyNumber();  // инициализируем копию
        System.out.println("Переменая с ссылкой на тот же объект = " + myNumberCopy); //показываем копию, 42
        System.out.println("---------------"); //прочерк
        immutableObj = immutableObj.increment(5); // пытаемся изменить объект по ссылке, но получаем новый объект и новую ссылку
        int myNumberNew = immutableObj.getMyNumber(); // инициализируем измененный объект, будет 47
        System.out.println("При изменении новый объект равен = " + myNumberNew); //показываем новый объект, 47
        System.out.println("Прошлый объект остался равен = " + myNumberOrig); //убеждаемся, что старый объект в норме
    }
    }
