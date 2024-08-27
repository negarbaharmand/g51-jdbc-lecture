package se.lexicon.model;

import java.time.LocalDate;

public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private LocalDate createDate;

    //Constructor for inserting data to the database
    public Student(String firstName, String lastName, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    //Constructor for fetching data from the database
    public Student(int studentId, String firstName, String lastName, int age, String email, LocalDate createDate) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.createDate = createDate;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
