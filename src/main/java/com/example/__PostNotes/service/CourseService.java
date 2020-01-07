package com.example.__PostNotes.service;

import com.example.__PostNotes.po.Course;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {
    Course saveCourse(Course course);

    Course getCourse(Long id);

//    Course getCourseByContext(String name);

    Page<Course> listCourse(Pageable pageable);

    List<Course> listCourse();

    List<Course> listCourse(String ids);

//    List<Course> listCourseTop(Integer size);

    Course updateCourse(Long id, Course course) throws NotFoundException;

    void deleteCourse(Long id);

//    Page<Course> listBlog(String query,Pageable pageable);
//
//    public Course getAndConvert(Long id) throws NotFoundException;
}
