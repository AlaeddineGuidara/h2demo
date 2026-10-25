package com.example.h2demo.service;

import com.example.h2demo.exception.ResourceNotFoundException;
import com.example.h2demo.model.Student;
import com.example.h2demo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> findAll() { return repository.findAll(); }

    public List<Student> findByFiliere(String filiere) { return repository.findByFiliere(filiere); }

    public Student findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Etudiant introuvable avec l'id " + id));
    }

    public Student create(Student student) {
        student.setId(null);
        return repository.save(student);
    }

    public Student update(Long id, Student data) {
        Student existing = findById(id);
        existing.setNom(data.getNom());
        existing.setPrenom(data.getPrenom());
        existing.setEmail(data.getEmail());
        existing.setFiliere(data.getFiliere());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
