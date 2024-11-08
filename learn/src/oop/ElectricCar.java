package oop;

import immutable.ImmutableClass;

public final class ElectricCar extends Car {
    private final int electricEnginePower;

    public ElectricCar(int speed, String model, int electricEnginePower) { //зачем тут protected и почему не могу поставить private?
        super(speed, model); //использую поля суперкласса (родителя)
        this.electricEnginePower = electricEnginePower;
    }

    @Override
    public void beep() {
        System.out.println("Бип! Я электромобиль!");
    }

    public ElectricCar get() {
        return this; //почему использую this, а не могу использовать все поля? почему программа просит new?
    }

    public int getSpeed() {
        return speed;
    }

    public void editSpeed(int speed) {
        this.speed = speed;
    }
}
