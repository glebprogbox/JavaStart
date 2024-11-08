package oop;

public abstract class Car { //делаю класс абстрактным, чтобы нельзя было создать класс "машина"
    protected int speed;
    protected String model;

    public Car(int speed, String model) { //защищенный конструктор (почему не могу сделать приватным?)
        this.speed = speed;
        this.model = model;
    }

    protected void beep() { //неабстрактный защищенный метод (доступен только в дочерних классах), чтобы показать полиморфизм (Override)
        System.out.println("Бип! Я автомобиль!");
    }
}

