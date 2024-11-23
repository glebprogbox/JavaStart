package collection.students;

import java.util.Date;

public class Student {
    private final String name;
    private final String middleName;
    private final Date dateOfBirth;
    private final int age;
    private final double averageScore;

    public Student(String name, String middleName, Date dateOfBirth, int age, double averageScore) {
        this.name = name;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.averageScore = averageScore;
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

    @Override
    public String toString() {
        return "Студент{" +
                "Имя='" + name + '\'' +
                ", Фамилия ='" + middleName + '\'' +
                ", Дата рождения=" + DateUtils.formatDate(dateOfBirth) +
                ", Возраст =" + age +
                ", Средний балл=" + averageScore +
                '}';
    }
}
