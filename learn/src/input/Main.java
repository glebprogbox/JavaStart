package input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input/test.txt")); //создаю буффер, в котором использую FileReader для чтения файла
        } catch (FileNotFoundException e) { //ловлю ошибку "не найдено"
            System.out.println("Error. File not found!");
        } catch (IOException e) { //ловлю остальные любые ошибки ввода-вывода
            System.out.println("Error. File not found!");
        }

    }
}
