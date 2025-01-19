/**
 * Задание 2:  используя один из встроенных функциональных интерфейсов, реализуй проверку числа на четность.
 * Если число четное, то нужно возвращать true, в противном случае — false.
 * <p>
 * Затем , используя какие-то встроенные функциональные интерфейсы, реализуй две операции:
 * 1-я возводит число в квадрат, 2-я умножает число на 2.
 * <p>
 * Реализуй функциональный метод, принимающий на вход функцию проверки на четность и реализованные операции.
 * Его логика: если число четное, выполняем 1-ю операцию, иначе 2-ю
 */

package core.interfacefunc.one;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Main {
    static Predicate<Integer> isParity = n -> n % 2 == 0;
    static UnaryOperator<Integer> kv = n -> n * n;
    static UnaryOperator<Integer> x2 = n -> n * 2;

    public static void main(String[] args) {
        System.out.println("Введите число");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        System.out.println("Четное число?.." + isParity.test(x));
        validateAndApply(isParity, kv, x2, x);
    }

    public static void validateAndApply(Predicate<Integer> isParity, UnaryOperator<Integer> kv, UnaryOperator<Integer> x2, int x) {
        if (isParity.test(x)) {
            System.out.println("Результат = " + kv.apply(x));
        } else {
            System.out.println("Результат = " + x2.apply(x));
        }
    }

}
