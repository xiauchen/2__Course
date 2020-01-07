package com.example.__PostNotes.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
* */
@Entity
@Table(name="c_course")
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String location;
    private String teacher;
    private String time;
    private Integer studentNumber;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Student> students = new ArrayList<>();

    public Course() {
    }
}
