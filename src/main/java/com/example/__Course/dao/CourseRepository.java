package com.example.__Course.dao;

import com.example.__Course.po.Course;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findByStudentId(Long studentId);

    @Query("select c from Course c where c.name like ?1")
    List<Course> findByQuery(String query, Pageable pageable);
//    Course findByName(String name);

//    @Query("select t from Title t")
//    List<Title> findTop(Pageable pageable);

//    @Query("select b from Blog b where b.title like ?1 or b.content like ?1")
//    Page<Title> findByQuery(String query, Pageable pageable);
}
