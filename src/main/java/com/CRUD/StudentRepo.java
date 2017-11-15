package com.CRUD;

import java.util.ArrayList;
import java.util.List;

public class StudentRepo {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudent(Integer id) {
        for (Student student : this.students) {
            if (student.getID() == id) {
                return student;
            }
        }

        return null;

    }

}
