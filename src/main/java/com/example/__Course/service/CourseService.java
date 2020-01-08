package com.example.__Course.service;

import com.example.__Course.po.Course;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

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

    Course getCourseByName(String name);

    Optional<Course> getCourseById(Long id);

    List<Course> listCourseByStudentId(Long id);

    List<Course> listCourse(String query, Pageable pageable);

//    Page<Course> listBlog(String query,Pageable pageable);
//
//    public Course getAndConvert(Long id) throws NotFoundException;
}
