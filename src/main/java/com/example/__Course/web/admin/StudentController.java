package com.example.__Course.web.admin;

import com.example.__Course.po.Course;
import com.example.__Course.po.Student;
import com.example.__Course.service.CourseService;
import com.example.__Course.service.StudentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class StudentController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;
    @PostMapping("/s/edit")
    public String postStudent(Student student, BindingResult result, RedirectAttributes attributes) throws NotFoundException {
        Student s;
        if(student.getId() == null){
            s=studentService.saveStudent(student);
            System.out.println("save\n");
        }else{
            s=studentService.updateStudent(student.getId(),student);
            System.out.println(student.getId().toString()+" update\n");
        }
        if(s == null) {
            System.out.println("False\n");
            return "404";
        }else {
            System.out.println("true\n");
            return "400";
        }
    }
}
