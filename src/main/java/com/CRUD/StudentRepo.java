package com.CRUD;

import java.util.ArrayList;

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
            if (student.getId() == id) {
                return student;
            }
        }

        return null;

    }

}
