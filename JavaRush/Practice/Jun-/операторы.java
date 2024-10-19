```

public class Solution {

    public static void main(String[] args) {
        taskForCondition();
    }

    public static void taskForCondition() {
        int number = 15;
        boolean firstCondition = number < 15 & number > 25 & (number += 15) < 25;
        boolean secondCondition = (number | 5) > 12 || (number = number + 2) > 40;
        System.out.println(number);//тут будет 30
    }
}
```
public class Solution {

    public static void main(String[] args) {
        int number = 2;
        System.out.println(number + number * (number + ++number));//тут будет 12
    }

}
```

public class Solution {

    public static void main(String[] args) {
        int a = 3;
        int b = ++a + (a-- * ++a);//справа налево. 4+4*4

        System.out.println(b); //тут будет 20
    }
}
```
