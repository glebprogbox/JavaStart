package collection_students;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
    static StudentCollection studentCollection = new StudentCollection(); //почему тоже статик надо писать, если и так в классе коллекций это статик?

    public static void main(String[] args) {

        while (1 == 1) {
            System.out.println("\nЧто хотите сделать?\nAdd - добавить студента. Search - найти студента. GetAll - вывести всех студентов.");

            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("add")) {
                System.out.println("Введите имя, фамилию, дату рождения, возраст и средний балл через запятую или пробелы.\n" + "Пример: Иван Корнеев 16.05.1990 34 4.4");

                Scanner add = new Scanner(System.in);
                String inputAdd = add.nextLine();

                StringTokenizer addToken = new StringTokenizer(inputAdd, ", ");
                int tokenCount = addToken.countTokens();
                if (!(tokenCount == 5)) {
                    System.out.println("Введено недопустимое кол-во параметров! Должно быть - 5.");
                } else {
                    String name = addToken.nextToken();
                    String middleName = addToken.nextToken();
                    String stringDateOfBirth = addToken.nextToken();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                    try {
                        Date dateOfBirth = formatter.parse(stringDateOfBirth);
                        String stringAge = addToken.nextToken();
                        int age = Integer.parseInt(stringAge);
                        String stringAverageScore = addToken.nextToken();
                        double averageScore = Double.parseDouble(stringAverageScore);
                        Student student = new Student(name, middleName, dateOfBirth, age, averageScore);
                        studentCollection.addStudent(student);
                        System.out.println("Студент добавлен!\n" + student.getStudentAllInfo());
                    } catch (ParseException e) {
                        System.out.println("Ошибка преобразования даты рождения! Указывайте ее корректно - 01.05.1995");
                    }
                }

            }
        }
    }
}
