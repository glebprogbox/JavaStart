/**
 * Задание 3: Создай свой функциональный интерфейс с методом,
 * который принимает три дробных числа (a, b, c) и возвращает дискриминант (b^2 - 4 * a * c)
 */

package core.interfacefunc.two;

import java.util.Scanner;

public class Main {

    @FunctionalInterface
    interface OperationX {
        double apply(double a, double b, double c);
    }
    static OperationX func = (a, b, c) -> (b*b - 4 * a * c);

    public static void main(String[] args) {
        System.out.println("Введите число 1");
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        System.out.println("Введите число 2");
        double b = scanner.nextDouble();
        System.out.println("Введите число 3");
        double c = scanner.nextDouble();

        double res = func.apply(a, b, c);
        System.out.println("Результат операции = " + res);

    }

}
