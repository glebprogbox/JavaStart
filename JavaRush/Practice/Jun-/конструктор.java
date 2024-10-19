```
public class Skyscraper {

    public Skyscraper()
        {
            System.out.println("Небоскреб построен.");
        }

    public static void main(String[] args) {
        Skyscraper skyscraper = new Skyscraper();
    }
}
```

public class Skyscraper {
    public static final String SKYSCRAPER_WAS_BUILD = "Небоскреб построен.";
    public static final String SKYSCRAPER_WAS_BUILD_FLOORS_COUNT = "Небоскреб построен. Количество этажей - ";
    public static final String SKYSCRAPER_WAS_BUILD_DEVELOPER = "Небоскреб построен. Застройщик - ";

    public Skyscraper()
    {
        System.out.println(SKYSCRAPER_WAS_BUILD);
    }
    public Skyscraper(int x)
    {
        System.out.println(SKYSCRAPER_WAS_BUILD_FLOORS_COUNT + x);
    }
    public Skyscraper(String x)
    {
        System.out.println(SKYSCRAPER_WAS_BUILD_DEVELOPER + x);
    }
    
    public static void main(String[] args) {
        Skyscraper skyscraper = new Skyscraper();
        Skyscraper skyscraperTower = new Skyscraper(50);
        Skyscraper skyscraperSkyline = new Skyscraper("JavaRushDevelopment");
    }
}
```

public class Skyscraper {
    private int floorsCount;
    private String developer;

    public Skyscraper()
    {
        floorsCount = 5;
        developer = "JavaRushDevelopment";
    }
    public Skyscraper(int floorsCount, String developer)
    {
        this.floorsCount = floorsCount;
        this.developer = developer;
    }

    public static void main(String[] args) {
        Skyscraper skyscraper = new Skyscraper();
        Skyscraper skyscraperUnknown = new Skyscraper(50, "Неизвестно");
    }
}
```
public class CarConcern {
    private final String manufacturer = "Lamborghini";
    private final String model;
    private final int year;
    private final String color;

    public CarConcern(String model, int year, String color) {
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public CarConcern(String model, int year) {
        this.model = model;
        this.year = year;
        color = "Оранжевый";
    }

    public CarConcern(String model) {
        this.model = model;
        year = 4321;
        color = "Оранжевый";
    }
}
```
убрали конструктор и заменили на метод
```
public class Building {
    private String type;

    public Building(String type) {
        this.type = type;
    }

    //напишите тут ваш код

    public static void main(String[] args) {
        Building building = new Building("Ресторан");
        building.initialize("Барбершоп");
    }
}
меняем на
public class Building {
    private String type;

    public void initialize(String type)
    {
        this.type = type;
    }


    public static void main(String[] args) {
        Building building = new Building();
        building.initialize("Ресторан");
        building.initialize("Барбершоп");
    }
}
```
разбираемся с наследованием классов, где есть переменные и конструкторы
```
public class Main
{
   public static void main(String[] args)
   {
      ChildClass obj = new ChildClass();
   }

   public static String print(String text)
   {
      System.out.println(text);
      return text;
   }
}

class ParentClass
{
   public String a = Main.print("ParentClass.a");
   public String b = Main.print("ParentClass.b");

   public ParentClass()
   {
      Main.print("ParentClass.constructor");
   }
}

class ChildClass extends ParentClass
{
   public String c = Main.print("ChildClass.c");
   public String d = Main.print("ChildClass.d");

   public ChildClass()
   {
      Main.print("ChildClass.constructor");
   }
}
```
Будет в консоли
ParentClass.a
ParentClass.b
ParentClass.constructor
ChildClass.c
ChildClass.d
ChildClass.constructor
```
используем super
```
public class Solution {
    public static void main(String[] args) {
        ElectricCar ele = new ElectricCar(); //можно и так new ElectricCar();
        
    }
}
public class Car {

    public Car(String type) {
        System.out.println("Привет. Я " + type);
    }
}

public class ElectricCar extends Car {

    public ElectricCar() {
        super("ElectricCar");
    }
 }
```
