package immutable;

public final class ImmutableClass {
    private final int myNumber;

    public ImmutableClass(int myNumber) {
        this.myNumber = myNumber; // конструктор, присваивающий аргумент к переменной класса
    }

    public int getMyNumber() {
        return myNumber;
    }

    public ImmutableClass increment(int number) {
        return new ImmutableClass(myNumber + number);
    }
}
