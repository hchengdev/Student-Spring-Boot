package com.studentspringboot.service;

import com.studentspringboot.model.Student;
import com.studentspringboot.repository.IStudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class StudentService implements IStudentService {

    private final IStudentRepository studentRepository;
    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }



    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }


}
