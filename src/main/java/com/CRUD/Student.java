package com.CRUD;

public class Student {

    private String firstName;
    private String lastName;
    private Integer age;
    private Integer ID;

    public Student(String firstName, String lastName, Integer age, Integer ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
}
