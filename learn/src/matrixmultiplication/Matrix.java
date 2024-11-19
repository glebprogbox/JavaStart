package matrixmultiplication;

import java.util.ArrayList;
import java.util.List;

public class Matrix {
    private List<List<Integer>> matrix;

    public Matrix(int row, int cols) { //создаем коллекцию листов интежер, пустые строчки, строчка = получается объект Лист интежер коллекции
        matrix = new ArrayList<>();
        for (int i = 0; i < row; i++) { //считаем кол-во строк
            List<Integer> temp = new ArrayList<>(); //пустая строка
            for (int j = 0; j < cols; j++) { //идем заполнять строку
                temp.add(0); //ставим нули, чтоб сразу были значения и ничего не падало
            }
            matrix.add(temp); //добавляем строку в коллекцию
        }
    }

    public void setValue(int row, int col, int value) { //установка ячейки
        matrix.get(row).set(col, value);
    }

    public int getValue(int row, int col) {
        return matrix.get(row).get(col);
    }

    public void setMatrixRow(int[] row, int index) { //установка сразу строки по индексу (в нужное место)
        for (int i = 0; i < row.length; i++) {
            matrix.get(index).set(i, row[i]);
        }
    }

    public ArrayList<List<Integer>> getMatrix() { //получение всей матрицы
        return (ArrayList<List<Integer>>) matrix; //почему здесь надо было подписать что именно возвращаем Аррей лист интежер?
    }

    public List<Integer> getMatrixRow(int index) { //получение всей строки
        return matrix.get(index);
    }

    public int getCountRows() { //получение количества строк
        return matrix.size();
    }

    public int getCountCols() { //получение количества столбцов, учитывая, что в каждой строке одинаковое кол-во столбцов
        return matrix.get(0).size();
    }

    public void printMatrix() {
        for (List<Integer> temp : matrix) {
            for (Integer value : temp) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }


}
