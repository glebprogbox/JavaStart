package matrixmultiplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static BufferedWriter writer;

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
        matrixTwo.printMatrix();
        Matrix resultMatrix = multiplyMatrix(matrixOne, matrixTwo);
        if (resultMatrix != null) {
            System.out.println("Итоговая матрица:");
            resultMatrix.printMatrix();
            System.out.println("Записываю в файл..");
            recordMatrixToFile(resultMatrix.getMatrix(), "learn/src/matrixmultiplication/multi.txt");
        } else {
            System.exit(1);
        }
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

    public static Matrix multiplyMatrix(Matrix one, Matrix two) { //перемножаем матрицы
        Matrix resultMatrix = null; //вынес чтоб не была локальной переменной, просила идея
        if (one.getCountCols() != two.getCountRows()) {
            System.out.println("Матрицы нельзя перемножить!");
        } else {
            System.out.println("Матрицы можно перемножить!");
            resultMatrix = new Matrix(one.getCountRows(), two.getCountCols());
            for (int i = 0; i < one.getCountRows(); i++) { //перебираем строки
                for (int j = 0; j < two.getCountCols(); j++) {
                    int sum = 0;
                    for (int z = 0; z < one.getCountCols(); z++) { //перебираем строку первой матрицы
                        sum += one.getValue(i, z) * two.getValue(z, j); //суммируем перемножения, значение из строк первой умножаем на значения из колонки второй
                    }
                    resultMatrix.setValue(i, j, sum); //устанавливаем рез-т в ячейку
                }
            }
        }
        return resultMatrix;
    }

    //какого лешего я первым аргументом не могу подать Matrix matrix ((( ошибка что тип не аррей лист интежеров??
    public static void recordMatrixToFile(List<List<Integer>> matrix, String filename) throws IOException { //пробросил исключение наверх, опять
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (List<Integer> temp : matrix) {
            for (Integer value : temp) {
                writer.write(value + " ");
            }
            writer.newLine();
        }
        writer.close();
        System.out.println("Матрица успешно записана в файл: " + filename);
    }
}
