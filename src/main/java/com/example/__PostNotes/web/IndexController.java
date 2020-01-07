package com.example.__PostNotes.web;

import com.example.__PostNotes.service.StudentService;
import com.example.__PostNotes.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {
    //透過 @RequestMapping 指定從/會被對應到此hello()方法
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String index(Model model){

        return "data";

    }
}