package matrixmultiplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException { //пробросил исключения, чтоб не писать try/catch
        String filePathM1 = "learn/src/matrixmultiplication/m1.txt";
        String filePathM2 = "learn/src/matrixmultiplication/m2.txt";
        validateFile(filePathM1);
        validateFile(filePathM2);

//        тест для себя
//        Matrix mat = new Matrix(3, 4);
//        mat.setValue(0, 1, 1);
//        System.out.println(mat.getMatrix());
//        mat.printMatrix();

        Matrix matrixOne = readFileAndCreateMatrix(filePathM1);
        System.out.println("Матрица 1:");
        matrixOne.printMatrix();
        Matrix matrixTwo = readFileAndCreateMatrix(filePathM2);
        System.out.println("Матрица 2:");
        matrixOne.printMatrix();
        multiplyMatrix(matrixOne, matrixTwo);


    }


    private static void validateFile(String filePath) {
        if (!filePath.endsWith(".txt")) {
            System.out.println("Error. File is not a .txt file!");
            System.exit(1);
        }
    }

    //пробросил исключения, чтоб не писать try/catch
    public static Matrix readFileAndCreateMatrix(String filepath) throws IOException { //читаем файл и создаем матрицу, исключение пробросим выше, в main
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        List<List<Integer>> tempMatrix = new ArrayList<>(); //создаем временную коллекцию
        String tempLine; //временная строка
        int maxCols = 0;

        while ((tempLine = reader.readLine()) != null) { //читаем все строки, пока не дойдем до последней включительно
            String[] values = tempLine.trim().split(","); //массив элементов, разбиваем строку по запятой
            List<Integer> temp = new ArrayList<>(); //временная коллекция интежеров
            for (String value : values) { //перебираем каждый элемент в строке
                temp.add(Integer.parseInt(value)); // добавляем каждый элемент в коллекцию интежеров
            }
            tempMatrix.add(temp); //добавляем коллекцию интежеров в общую коллекцию
            maxCols = values.length; // определяем кол-во столбцов по длине массива, подразумеваем что они одинаковые для каждой строки
        }
        Matrix matrix = new Matrix(tempMatrix.size(), maxCols);
        for (int i = 0; i < tempMatrix.size(); i++) {
            for (int j = 0; j < tempMatrix.get(i).size(); j++) {
                matrix.setValue(i, j, tempMatrix.get(i).get(j));
            }
        }
        return matrix;
    }

    public static void multiplyMatrix(Matrix one, Matrix two) { //проверяем, можно ли перемножать матрицы
        if (one.getCountCols() != two.getCountRows()) {
            System.out.println("Матрицы нельзя перемножить!");
        } else {
            System.out.println("Матрицы можно перемножить!");
        }


    }
}
