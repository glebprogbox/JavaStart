package oop;

public class Main {

    public static void main(String[] args) {

        ElectricCar Tesla = new ElectricCar(225, "Tesla", 250);
        PetrolCar Mazda = new PetrolCar(200, "Mazda", 150);
        System.out.println("\nЭлектроавтомобиль Tesla, скорость: " + Tesla.getSpeed() + ". Объект: " + Tesla.get());
        System.out.println("Бензиновый автомобиль Mazda, скорость: " + Mazda.getSpeed() + ". Объект: " + Mazda.get() + "\n");

        System.out.println("А сейчас поменяем скорость объекта Tesla..\n");

        Tesla.editSpeed(500);

        System.out.println("Теперь новая скорость Tesla: " + Tesla.getSpeed() + ". Объект: " + Tesla.get());
        System.out.println("Ну да, все верно, был создан новый объект и ссылки на него нет $) Еще разок..\n");

        ElectricCar TeslaNewSpeed = Tesla.editSpeed(500);
        System.out.println("Теперь новая скорость Tesla: " + TeslaNewSpeed.getSpeed() + ". Новый объект: " + TeslaNewSpeed.get());
        System.out.println("При этом старая ссылка в порядке, старая скорость Tesla: " + Tesla.getSpeed() + ". Старый объект: " + Tesla.get() + "\n");

        System.out.println("Изменим ссылку, старую на новую. Таким образом старую потеряем.");
        Tesla = TeslaNewSpeed;
        System.out.println("Теперь все одинаково, старая Tesla: " + Tesla.getSpeed() + ". Объект: " + Tesla.get());
        System.out.println("...и новая Tesla: " + TeslaNewSpeed.getSpeed() + ". Объект: " + TeslaNewSpeed.get() + " ... Ссылки равны.");

        TeslaNewSpeed.beep();
    }

}
