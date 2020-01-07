package com.example.__Course.dao;

import com.example.__Course.po.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
//    Student findByName(String name);

//    @Query("select l from Student l")
//    List<Student> findTop(Pageable pageable);

}
