package com.studentspringboot.service;

import com.studentspringboot.repository.IClassRepository;
import org.springframework.stereotype.Service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.studentspringboot.model.Class;


import java.util.Optional;

@Service
public class ClassService implements IClassService {

    private final IClassRepository classRepository;

    public ClassService(IClassRepository classRepository) {
        this.classRepository = classRepository;
    }


    @Override
    public Page<Class> findAll(Pageable pageable) {
        return classRepository.findAll(pageable);
    }

    @Override
    public Iterable<Class> findAll() {
        return classRepository.findAll();
    }

    @Override
    public void save(Class aClass) {
        classRepository.save(aClass);
    }

    @Override
    public Optional<Class> findById(Long id) {
        return classRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        classRepository.deleteById(id);
    }

}

