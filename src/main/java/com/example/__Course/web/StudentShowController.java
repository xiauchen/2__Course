package com.example.__Course.web;

import com.example.__Course.po.Course;
import com.example.__Course.po.Student;
import com.example.__Course.service.CourseService;
import com.example.__Course.service.StudentService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentShowController {
    //透過 @RequestMapping 指定從/會被對應到此hello()方法
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/s")
    public String student() throws JSONException {
        JSONObject data = new JSONObject();
        List<Student> s = studentService.listStudent();
        int i=1;
        for (Student s1: s
        ) {
            data.put("student"+i,s1);
            data.put("student"+i,courseService.listCourseByStudentId(s1.getId()));
            i++;
        }
        return data.toString();
    }
    //獲取byId ok
    @GetMapping("/s/{id}")
    public String tags(@PathVariable Long id) throws Exception {
        JSONObject data = new JSONObject();
        data.put("student",studentService.getStudentById(id).orElseThrow(()-> new Exception("What Null")));
        data.accumulate("course",courseService.listCourseByStudentId(id));
        return data.toString();
    }
    //刪除 ok
    @DeleteMapping("/s/{id}/delete")
    public String delete(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "400";
    }
    //搜尋
    @PostMapping("/s/search")
    public String search(@PageableDefault(size = 7,sort ={"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                         @RequestParam String query, Model model) throws JSONException {
        JSONObject data = new JSONObject();
        List<Student> s = studentService.listStudent("%"+query+"%",pageable);
        int i=1;
        for (Student s1: s
        ) {
            data.put("student"+i,s1);
            data.accumulate("student"+i,courseService.listCourseByStudentId(s1.getId()));
            i++;
        }
        return data.toString();
    }
}
