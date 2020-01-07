package com.example.__Course.web;

import com.example.__Course.service.CourseService;
import com.example.__Course.service.StudentService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {
    //透過 @RequestMapping 指定從/會被對應到此hello()方法
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;
    public IndexController() {
    }
    //主頁
    @GetMapping("/")
    public String index() throws JSONException {
        JSONObject data = new JSONObject();

        data.put("course",courseService.listCourse());
        data.put("student",studentService.listStudent());

        return data.toString();

    }

}