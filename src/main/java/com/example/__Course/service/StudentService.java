package com.example.__Course.service;

import com.example.__Course.po.Student;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

    Student getStudent(Long id);
//
//    Student getStudentByContext(String name);

    Page<Student> listStudent(Pageable pageable);

    List<Student> listStudent();

    List<Student> listStudent(String ids);

//    List<Student> listStudentTop(Integer size);

    Student updateStudent(Long id, Student Student) throws NotFoundException;

    void deleteStudent(Long id);
}
