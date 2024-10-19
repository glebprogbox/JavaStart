```
public class Solution {

    public static void main(String[] args) {
        String s1 = new String("JavaRush");
        s1 = "JavaRush";
        String s2 = "JavaRush";
//        s2 = new String("JavaRush");
        String s3 = "JavaRush";
//        s3 = new String("JavaRush");
        System.out.println(s1 == s3); \\будет тру
        System.out.println(s2.equals(s3)); \\будет тру
    }
}
```
переопределение equals
```
public boolean equals(Object obj)
{
   if (this == obj)
      return true;

   if (obj == null)
      return false;

   if (!(obj instanceof Person))
      return false;

   Person person = (Person) obj;

    if (this.age != person.age)
    return false;

    if (this.name == null)
    return person.name == null;

return this.name.equals(person.name);}
```
import java.util.Objects;

/* 
Два айфона
*/

public class Iphone {
    private String model;
    private String color;
    private int price;

    public Iphone(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Iphone iphone = (Iphone) o;
        return price == iphone.price &&
                Objects.equals(model, iphone.model) && \\model потому что this тут избыточно, и так подразумевается this.model
                Objects.equals(color, iphone.color);
    }

    public static void main(String[] args) {
        Iphone iphone1 = new Iphone("X", "Black", 999);
        Iphone iphone2 = new Iphone("X", "Black", 999);

        System.out.println(iphone1.equals(iphone2));
    }

}
```
