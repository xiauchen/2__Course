package com.example.__Course.po;

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

    @ManyToMany(mappedBy = "course")
    private List<Student> student = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updateTime")
    private Date updateTime;

    public Course() {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public List<Student> getStudents() {
        return student;
    }

    public void setStudents(List<Student> student) {
        this.student = student;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", teacher='" + teacher + '\'' +
                ", time='" + time + '\'' +
                ", studentNumber=" + studentNumber +
                ", updateTime=" + updateTime +
                '}';
    }
}
