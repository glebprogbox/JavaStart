package collection.students;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {

    //почему тоже статик надо писать, если и так в классе коллекций это статик?
    static List<Student> studentCollection = new ArrayList<>();

    public static void main(String[] args) {

        while (1 == 1) {
            System.out.println("""
                    Что хотите сделать?
                    Add - добавить студента. Search - найти студента. GetAll - вывести всех студентов.""");

            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("add")) {
                readStudent();
            } else if (input.equalsIgnoreCase("search")) {
                // todo implement search
                if (studentCollection.isEmpty()) {
                    System.out.println("Коллекция студентов пуста. Сначала добавьте студентов.");
                    continue;
                }
                String surname = readForSearch();
                List<Student> students = searchStudent(studentCollection, surname);
                if (students.isEmpty()) {
                    System.out.println("Студентов с такой фамилией нет!");
                } else {
                    System.out.println("Студенты найдены:");
                    for(Student student : students) {
                        System.out.println(student.toString());
                    }
                }

            } else {
                sortAndPrint();
            }
        }
    }

    private static String readForSearch() {
        System.out.println("Введите фамилию студента для поиска. Регистр не важен.");

        Scanner add = new Scanner(System.in);
        return add.nextLine();
    }

    private static List<Student> searchStudent(List<Student> students, String surname) {
        int i = 0;
        List<Student> studentTempCollection = new ArrayList<>();
        for (Student st : students) {
            if (st.getMiddleName().equalsIgnoreCase(surname)) {
                studentTempCollection.add(st);
                i++;
            } else {
                i++;
            }
        }
        if (i == 0) {
            return null;
        } else {
            return studentTempCollection;
        }
    }


    private static void sortAndPrint() {
        studentCollection.sort(Comparator.comparing(Student::getDateOfBirth));

        //можно использовать thenComparing и в одну строку писать и вместо :: испольузуются лямбда выражения comparing(student -> student.getDateOfBirth())
        studentCollection.sort(Comparator.comparing(Student::getName));

        System.out.println(studentCollection);
    }

    private static void readStudent() {
        System.out.println("""
                Введите имя, фамилию, дату рождения, возраст и средний балл через запятую или пробелы.
                "Пример: Иван Корнеев 16.05.1990 34 4.4""");

        Scanner add = new Scanner(System.in);
        String inputAdd = add.nextLine();

        addStudentAndValidate(inputAdd);
    }

    private static void addStudentAndValidate(String inputAdd) {
        StringTokenizer addToken = new StringTokenizer(inputAdd, ", ");
        int tokenCount = addToken.countTokens();
        if (!(tokenCount == 5)) {
            System.out.println("Введено недопустимое кол-во параметров! Должно быть - 5.");
        } else {
            addStudent(addToken);
        }
    }

    private static void addStudent(StringTokenizer addToken) {
        String name = addToken.nextToken();
        String middleName = addToken.nextToken();
        String stringDateOfBirth = addToken.nextToken();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Student student = buildStudent(addToken, formatter, stringDateOfBirth, name, middleName);
            System.out.println("Студент добавлен!\n" + student);
        } catch (ParseException e) {
            System.out.println("Ошибка преобразования даты рождения! Указывайте ее корректно - 01.05.1995");
        }
    }

    private static Student buildStudent(StringTokenizer addToken, SimpleDateFormat formatter,
                                        String stringDateOfBirth, String name, String middleName) throws ParseException {
        String stringAge = addToken.nextToken();
        String stringAverageScore = addToken.nextToken();

        Student student = new Student(
                name,
                middleName,
                formatter.parse(stringDateOfBirth),
                Integer.parseInt(stringAge),
                Double.parseDouble(stringAverageScore)
        );

        studentCollection.add(student);
        return student;
    }
}
