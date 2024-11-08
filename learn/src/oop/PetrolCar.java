package oop;

public final class PetrolCar extends Car {
    private final int petrolEnginePower;

    public PetrolCar(int speed, String model, int petrolEnginePower) {
        super(speed, model);
        this.petrolEnginePower = petrolEnginePower;
    }

    @Override
    public void beep() {
        System.out.println("Бип! Я кушаю бензин!");
    }

    public PetrolCar get() {
        return this;
    }

    public int getSpeed() {
        return speed;
    }

    public void editSpeed(int speed) {
        this.speed = speed;
    }
}
