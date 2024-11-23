package collection.matrixmultiplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static BufferedWriter writer;
    static String filePathM1 = "learn/src/collection.matrixmultiplication/m1.txt";
    static String filePathM2 = "learn/src/collection.matrixmultiplication/m2.txt";

    /*
    тест для себя
    Matrix mat = new Matrix(3, 4);
    mat.setValue(0, 1, 1);
    System.out.println(mat.getMatrix());
    mat.printMatrix();
     */
    public static void main(String[] args) throws IOException { //пробросил исключения, чтоб не писать try/catch

        validateFile(filePathM1);
        validateFile(filePathM2);


        Matrix matrixOne = createMatrix(readFile(filePathM1));
        System.out.println("Матрица 1:");
        System.out.println(matrixOne);
        Matrix matrixTwo = createMatrix(readFile(filePathM2));
        System.out.println("Матрица 2:");
        System.out.println(matrixTwo);
        Matrix resultMatrix = multiplyMatrix(matrixOne, matrixTwo);
        System.out.println("Итоговая матрица:");
        System.out.println(resultMatrix);
        System.out.println("Записываю в файл..");
        recordMatrixToFile(resultMatrix, "learn/src/collection.matrixmultiplication/multi.txt");
    }

    private static void validateFile(String filePath) {
        if (!filePath.endsWith(".txt")) {
            throw new IllegalArgumentException("Error. File is not a .txt file!"); //бросаю исключение
        }
    }

    private static Matrix createMatrix(List<List<Integer>> tempMatrix) {
        List<Integer> row = tempMatrix.getFirst(); //берем строку
        int maxCols = 0;
        if (row.size() > maxCols) { // определяем максимальное количество столбцов, записываем если больше нуля
            maxCols = row.size();
        }
        Matrix matrix = new Matrix(tempMatrix.size(), maxCols);
        for (int i = 0; i < tempMatrix.size(); i++) {
            for (int j = 0; j < tempMatrix.get(i).size(); j++) {
                matrix.setValue(i, j, tempMatrix.get(i).get(j)); // заполняем матрицу
            }
        }
        return matrix; // Возвращаем созданную матрицу
    }

    //читаем файл, исключение пробросим выше, в main
    private static List<List<Integer>> readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        List<List<Integer>> tempMatrix = new ArrayList<>(); //создаем временную коллекцию
        String tempLine; //временная строка

        while ((tempLine = reader.readLine()) != null) { //читаем все строки, пока не дойдем до последней включительно
            String[] values = tempLine.trim().split(","); //массив элементов, разбиваем строку по запятой
            List<Integer> temp = new ArrayList<>(); //временная коллекция интежеров
            for (String value : values) { //перебираем каждый элемент в строке
                temp.add(Integer.parseInt(value)); // добавляем каждый элемент в коллекцию интежеров
            }
            tempMatrix.add(temp); //добавляем коллекцию интежеров в общую коллекцию
        }
        return tempMatrix;
    }

    public static Matrix multiplyMatrix(Matrix one, Matrix two) { //перемножаем матрицы
        validateMatrix(one, two);
        Matrix resultMatrix = new Matrix(one.getCountRows(), two.getCountCols());
        for (int i = 0; i < one.getCountRows(); i++) { //перебираем строки
            for (int j = 0; j < two.getCountCols(); j++) {
                int sum = 0;
                for (int z = 0; z < one.getCountCols(); z++) { //перебираем строку первой матрицы
                    sum += one.getValue(i, z) * two.getValue(z, j); //суммируем перемножения, значение из строк первой умножаем на значения из колонки второй
                }
                resultMatrix.setValue(i, j, sum); //устанавливаем рез-т в ячейку
            }
        }
        return resultMatrix;
    }

    //пробросил исключение наверх, опять
    public static void recordMatrixToFile(Matrix matrix, String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (List<Integer> temp : matrix.getMatrix()) {
            for (Integer value : temp) {
                writer.write(value + " ");
            }
            writer.newLine();
        }
        writer.close();
        System.out.println("Матрица успешно записана в файл: " + filename);
    }

    public static void validateMatrix(Matrix one, Matrix two) {
        if (one.getCountCols() != two.getCountRows()) {
            System.out.println("Матрицы нельзя перемножить!");
            System.exit(1);
        } else {
            System.out.println("Матрицы можно перемножить!");
        }
    }
}
