package com.studentspringboot.service;

import com.studentspringboot.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService extends IGenerateService<Student> {
    Page<Student> findAll(Pageable pageable);
}
