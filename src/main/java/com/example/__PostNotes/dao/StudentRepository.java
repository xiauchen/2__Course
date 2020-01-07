package com.example.__PostNotes.dao;

import com.example.__PostNotes.po.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
//    Student findByName(String name);

//    @Query("select l from Student l")
//    List<Student> findTop(Pageable pageable);

}
