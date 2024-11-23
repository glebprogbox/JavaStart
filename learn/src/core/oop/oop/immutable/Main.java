package core.oop.oop.immutable;

public class Main {
    public static void main(String[] args) {

        ImmutableClass originalObj = new ImmutableClass(42); //создаем объект с значением 42
        ImmutableClass immutableObj = originalObj; // присваиваем ссылку оригинала, чтоб не потерять
        int myNumberOrig = originalObj.getMyNumber(); // получаешь значение переменной оригинала
        System.out.println("Исходный значение переменной = " + myNumberOrig);

        int myNumberCopy = immutableObj.getMyNumber();  // инициализируем копию
        System.out.println("Переменая с ссылкой на тот же объект = " + myNumberCopy); //показываем копию, 42
        System.out.println("---------------"); //прочерк

        immutableObj = immutableObj.increment(5); // пытаемся изменить объект по ссылке, но получаем новый объект и новую ссылку
        int myNumberNew = immutableObj.getMyNumber(); // инициализируем измененный объект, будет 47
        System.out.println("При изменении новый объект равен = " + myNumberNew); //показываем новый объект, 47
        System.out.println("Прошлый объект остался равен = " + myNumberOrig); //убеждаемся, что старый объект в норме
    }
}
