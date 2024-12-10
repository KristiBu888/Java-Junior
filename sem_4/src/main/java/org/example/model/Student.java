package org.example.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String studentname;
    private String studentsurname;
    private int age;

    
    public Student(int id, String studentname, String studentsurname, int age) {
        this.studentname = studentname;
        this.studentsurname = studentsurname;
        this.age = age;
    }

    public Student(String studentname, String studentsurname, int age) {
        this.studentname = studentname;
        this.studentsurname = studentsurname;
        this.age = age;
    }

    public String getName() {
        return studentname;
    }

    public void setName(String studentname) {
        this.studentname = studentname;
    }

    public String getSurname() {
        return studentsurname;
    }

    public void setSurname(String studentsurname) {
        this.studentsurname = studentsurname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id ='" + id + '\'' +
                "name='" + studentname + '\'' +
                "surname='" + studentsurname + '\'' +
                ", age=" + age +
                '}';
    }
}
