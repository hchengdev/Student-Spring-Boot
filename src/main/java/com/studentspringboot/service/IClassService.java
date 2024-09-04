package com.studentspringboot.service;

import com.studentspringboot.model.Class;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IClassService extends IGenerateService<Class> {
    Page<Class> findAll(Pageable pageable);
}
