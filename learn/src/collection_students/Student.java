package collection_students;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private String name;
    private String middleName;
    private Date dateOfBirth;
    private int age;
    private double averageScore;

    public Student(String name, String middleName, Date dateOfBirth, int age, double averageScore) {
        this.name = name;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.averageScore = averageScore;
    }

    private String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return formatter.format(date);
    }

    public String getStudentAllInfo() {
        return "Студент: " + name + " " + middleName + "\nДата рождения: " + formatDate(dateOfBirth) + "\nВозраст: " + age + "\nСредний балл: " + averageScore;
    }

    public String getStudentBasicInfo() {
        return "Студент: " + name + " " + middleName + ". Дата рождения: " + formatDate(dateOfBirth) + ".\n";
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public double getAverageScore() {
        return averageScore;
    }

}
