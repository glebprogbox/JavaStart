package matrix2x;

public class Main {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {4, 5, 6, 5},
                {7, 8, 9, 6},
                {3, 6, 3, 6}
        }; //создаю двумерный массив (квадрат).  тут подойдет любой квадратный массив

        int x;
        int y;
        int arrLength = arr.length; // узнаю количество строк, и это будет же кол-во столбцов, тк у нас квадрат

        System.out.print("Сейчас выведу диагональ, жди!\n\n");

        for(x = 0; x < arrLength; x++) { //начинаем перебирать строки
            for(y = x; y == x; y++) { // ячейки в строке не перебираем, тк массив квадратный, берем y = x, те выводим каждый раз следующую на строке ячейку y
                System.out.print(arr[x][y] + "\n");
            }
        }

        System.out.print("\nГотово!");

        }
}
