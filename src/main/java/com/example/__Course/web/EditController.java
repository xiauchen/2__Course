package com.example.__Course.web;

import com.example.__Course.po.Course;
import com.example.__Course.service.CourseService;
import com.example.__Course.service.StudentService;
import javassist.NotFoundException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RestController
public class EditController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;
    //搜尋 ok
    @GetMapping("/test/{id}")
    public String tags(@PathVariable Long id) throws Exception {
        JSONObject data = new JSONObject();
        data.put("course",courseService.getCourseById(id).orElseThrow(()-> new Exception("What Null")));

        return data.toString();
    }
    //修改by/id
    @PostMapping("/test/{id}")
    public String editPost(@Valid Course course, BindingResult result, @PathVariable Long id, RedirectAttributes attributes) throws NotFoundException {
        Course course1 = courseService.getCourseByName(course.getName());
        if(course1 != null){
            result.rejectValue("name","nameError","不能添加重複的分類");
        }

        if(result.hasErrors()){
            return "admin/types-input";
        }

        Course c = courseService.updateCourse(id,course);
        if(c == null){
            attributes.addFlashAttribute("message","更新失敗");
        }else{
            attributes.addFlashAttribute("message","更新成功");
        }
        return "redirect:/";
    }
    //新增和修改
    @PostMapping("/test")
    public String post(Course course, BindingResult result, RedirectAttributes attributes) throws NotFoundException {

//        title.setName("www");
//        title.setLife(true);
        Course c;
        if (course.getId() == null) {
            c=courseService.saveCourse(course);
            System.out.println("save\n");
        }else{
            c=courseService.updateCourse(course.getId(),course);
            System.out.println(course.getId().toString()+"update\n");
        }

        if(c==null){
            System.out.println("False\n");
        }else{
            System.out.println("True\n");
        }
        return "redirect:/";
    }
    //刪除 ok
    @GetMapping("/test/{id}/delete")
    public String delete(@PathVariable Long id){
        courseService.deleteCourse(id);
        return "400";
    }
}