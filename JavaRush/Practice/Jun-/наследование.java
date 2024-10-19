наследование
```
public class Woman extends Human{
}

public class Human extends Terran{
}

public class Terran {
}
```

```
public class Vehicle {
    double maxSpeed;

}

public class Car extends Vehicle{
    int wheelCount;
    double weight;
}

public class ElectricCar extends Car{
    int electricEnginePower;
}
```

```
public class Entity {
    public void move(){
        System.out.println("Я передвигаюсь.");
    }

    public void eat(){
        System.out.println("Я ем.");
    }
}

public class Human extends Entity{

    public void speak(){
        System.out.println("Я умею общаться.");
    }
}

public class JavaDeveloper extends Human{

    public void code(){
        System.out.println("Я умею общаться на Java.");
    }
}
```
