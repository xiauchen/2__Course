package com.example.__PostNotes.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "c_student")
public class Student {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private Integer grade;
    private Integer phoneNumber;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses = new ArrayList<>();

    public Student() {
    }
}
