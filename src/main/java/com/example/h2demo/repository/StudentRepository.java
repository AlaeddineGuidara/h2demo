package com.example.h2demo.repository;

import com.example.h2demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFiliere(String filiere);
}
