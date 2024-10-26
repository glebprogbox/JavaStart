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
