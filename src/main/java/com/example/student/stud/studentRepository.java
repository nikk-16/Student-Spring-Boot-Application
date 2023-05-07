package com.example.student.stud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface studentRepository
        extends JpaRepository<student, Long> {
    // select * students where email = ?
    @Query("select s from student s where s.email = ?1")
    Optional<student> findstudentByEmail(String email);
}
