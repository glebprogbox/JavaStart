package collection_students;

import java.util.ArrayList;

public class StudentCollection {
    public static ArrayList<Student> students = new ArrayList<>(); //создаю коллекцию, статик - видна всем экземплярам класса

    public int size() {
        return students.size();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Student>  addStudent(Student student) {
        students.add(student);
        return students;
    }



}
