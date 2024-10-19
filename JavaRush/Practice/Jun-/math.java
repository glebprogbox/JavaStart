```
import static java.lang.Math.toRadians;

public class Solution {

    public static double sin(double a) {
        a = Math.sin(Math.toRadians(a));
        return a;
    }

    public static double cos(double a) {
        a = Math.cos(Math.toRadians(a));
        return a;
    }

    public static double tan(double a) {
        a = Math.tan(Math.toRadians(a));
        return a;
    }
}
```
public class Solution {

    public static double sqrt(double a) {
        return Math.sqrt(a);
    }

    public static double cbrt(double a) {
        return Math.cbrt(a);
    }

    public static double pow(int number, int power) {
        return Math.pow(number, power);
    }
}
```
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        int[] intArray = getArrayOfTenElements();
        System.out.println(min(intArray));
    }

    public static int min(int[] ints) {
        int mins = Integer.MAX_VALUE;
        for(int minim:ints)
        {
            mins = Math.min(minim, mins);
        }
        return mins;
    }

    public static int[] getArrayOfTenElements() {
        Scanner read = new Scanner(System.in);
        int[] ten = new int[10];
        for(int i = 0; i<ten.length;i++)
        {
            ten[i] = read.nextInt();
        }
        return ten;
    }
}
```
public class Solution {

    public static void main(String[] args) {
        System.out.println(generateNumber());
    }

    public static int generateNumber() {
        int x = (int)(Math.random()*99);
//возвращает от 0 до 99, если хотим от 1 до 99 включительно, добавляем +1
        return x; //или сразу return (int)(Math.random()*99);
    }
}
```

public class Solution {

    public static void main(String[] args) {
        System.out.println("Заработаю ли я себе на BMW?");
        System.out.println(MagicBall.getPrediction());
    }
}

и

import java.util.Random;

public class MagicBall {
    private static final String CERTAIN = "Бесспорно";
    private static final String DEFINITELY = "Определённо да";
    private static final String MOST_LIKELY = "Вероятнее всего";
    private static final String OUTLOOK_GOOD = "Хорошие перспективы";
    private static final String ASK_AGAIN_LATER = "Спроси позже";
    private static final String TRY_AGAIN = "Попробуй снова";
    private static final String NO = "Мой ответ — нет";
    private static final String VERY_DOUBTFUL = "Весьма сомнительно";

    public static String getPrediction() {
        String[] array = new String[8];
        array[0] = CERTAIN;
        array[1] = DEFINITELY;
        array[2] = MOST_LIKELY;
        array[3] = OUTLOOK_GOOD;
        array[4] = ASK_AGAIN_LATER;
        array[5] = TRY_AGAIN;
        array[6] = NO;
        array[7] = VERY_DOUBTFUL;
        Random num = new Random();
        int number = num.nextInt(8);
        String answer=(number<0 || number>7)?null:array[number];
        return answer;
    }
}
```
