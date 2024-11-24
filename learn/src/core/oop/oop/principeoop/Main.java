package core.oop.oop.principeoop;

public class Main {

    public static void main(String[] args) {

        ElectricCar Tesla = new ElectricCar(225, "Tesla", 250);
        PetrolCar Mazda = new PetrolCar(200, "Mazda", 150);
        System.out.println("\nЭлектроавтомобиль Tesla, скорость: " + Tesla.getSpeed() + ". Объект: " + Tesla.get());
        System.out.println("Бензиновый автомобиль Mazda, скорость: " + Mazda.getSpeed() + ". Объект: " + Mazda.get() + "\n");

        System.out.println("А сейчас поменяем скорость объекта Tesla..\n");

        Tesla.editSpeed(500);

        System.out.println("Теперь новая скорость Tesla: " + Tesla.getSpeed() + ". Объект: " + Tesla.get());
        System.out.println("Ну да, все верно, был изменен объект и ссылка остается на него та же.\n");

        Tesla.beep();
    }

}
