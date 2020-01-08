package com.example.__Course.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "c_student")
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer grade;
    private Integer phoneNumber;

    @ManyToMany(mappedBy = "student")
    private List<Course> course = new ArrayList<>();

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Course> getCourses() {
        return course;
    }

    public void setCourses(List<Course> course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
